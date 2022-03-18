package org.adrianl.javasoft.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dto.ProgramadorDto;
import org.adrianl.javasoft.mapper.ProgramadorMapper;
import org.adrianl.javasoft.repository.ProgramadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProgramadorController {
    private final ProgramadorRepository programadorRepository;
    private final ProgramadorMapper programadorMapper;

    @GetMapping("/programadores")
    public ResponseEntity<List<Programador>> obtenerTodos() {
        List<Programador> result = programadorRepository.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            return ResponseEntity.ok(result);   //200
        }
    }

    @GetMapping("/programador/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
        Programador result = programadorRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }

    @GetMapping("/programador/{id}/tareas")
    public ResponseEntity<?> obtenerTareas(@PathVariable Long id) {
        Programador result = programadorRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result.getTareas());   //200
    }

    @GetMapping("/programador/name/{name}")
    public ResponseEntity<?> obtenerPorNombre(@PathVariable String name) {
        Programador result = programadorRepository.findByNombre(name).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }


    @PostMapping("/programador")
    public ResponseEntity<ProgramadorDto> save(@RequestBody ProgramadorDto programadorDto) {
        try {
            Programador programador = programadorMapper.fromDto(programadorDto);
            //checkUsuarioData(programador);
            Programador programadorInsertado = programadorRepository.save(programador);
            return ResponseEntity.ok(programadorMapper.toDto(programadorInsertado));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Insertar, Error al insertar el programador. Campos incorrectos " + e.getMessage());
        }
    }

    @PutMapping("/programador/{id}")
    public ResponseEntity<?> editarProgramador(@RequestBody Programador editar, @PathVariable Long id) {
        return programadorRepository.findById(id).map(p -> {
            p.setNombre(editar.getNombre());
            return ResponseEntity.ok(programadorRepository.save(p));    //200
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();   //404 not found
        });
    }

    @PutMapping("/programador/{id}/avatar")
    public ResponseEntity<?> editarProgramadorAvatar(@RequestBody Programador editar, @PathVariable Long id) {
        return programadorRepository.findById(id).map(p -> {
            p.setAvatar(editar.getAvatar());
            return ResponseEntity.ok(programadorRepository.save(p));    //200
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();   //404 not found
        });
    }

    @DeleteMapping("/programador/{id}")
    public ResponseEntity<?> borrarProgramador(@PathVariable Long id) {
        programadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }
}