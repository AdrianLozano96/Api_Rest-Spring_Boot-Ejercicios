package org.adrianl.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.ProyectoDTO;
import org.adrianl.demospring.dto.RepositorioDTO;
import org.adrianl.demospring.mapper.RepositorioMapper;
import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.model.Proyecto;
import org.adrianl.demospring.model.Repositorio;
import org.adrianl.demospring.repository.RepositorioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RepositorioController {

    private final RepositorioRepository repositorioRepository;
    private final RepositorioMapper repositorioMapper;

    @GetMapping("/repositorios")
    public ResponseEntity<?> obtenerTodos() {
        List<Repositorio> result = repositorioRepository.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            return ResponseEntity.ok(result);   //200
        }
    }

    @GetMapping("/repositorio/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
        Repositorio result = repositorioRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }
/*
    @PostMapping("/repositorio")
    public ResponseEntity<?> nuevoRepositorio(@RequestBody Repositorio nuevo) {
        Repositorio saved = repositorioRepository.save(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);   //201 usuario insertado
    }

 */
    @PostMapping("/repositorio")
    public ResponseEntity<RepositorioDTO> nuevoRepositorio(@RequestBody RepositorioDTO repositorioDTO) {
        try {
            Repositorio repositorio = repositorioMapper.fromDTO(repositorioDTO);
            Repositorio repositorioInsertado = repositorioRepository.save(repositorio);
            return ResponseEntity.ok(repositorioMapper.toDTO(repositorioInsertado));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Insertar, Error al insertar el repositorio. Campos incorrectos " + e.getMessage());
        }
    }

    @PutMapping("/repositorio/{id}")
    public ResponseEntity<?> editarRepositorio(@RequestBody Repositorio editar, @PathVariable Long id) {
        return repositorioRepository.findById(id).map(p -> {
            p.setNombre(editar.getNombre());
            return ResponseEntity.ok(repositorioRepository.save(p));    //200
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();   //404 not found
        });
    }

    @DeleteMapping("/repositorio/{id}")
    public ResponseEntity<?> borrarRepositorio(@PathVariable Long id) {
        repositorioRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }

}
