package org.adrianl.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.ProgramadorDTO;
import org.adrianl.demospring.mapper.ProgramadorMapper;
import org.adrianl.demospring.model.Programador;
import org.adrianl.demospring.model.Proyecto;
import org.adrianl.demospring.repository.ProgramadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProgramadorController {    //Meterle algunas de las cosas que tene el profe

    private final ProgramadorRepository programadorRepository;
    private final ProgramadorMapper programadorMapper;

    @GetMapping("/programadores")
    public ResponseEntity<?> obtenerTodos() {
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

    @GetMapping("/programador/name/{name}")
    public ResponseEntity<?> obtenerPorNombre(@PathVariable String name) {
        Programador result = programadorRepository.findByNombre(name).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }

    @GetMapping("/programador/proy/{name}")
    public ResponseEntity<?> obtenerProyectosDeUnProgramador(@PathVariable String name) {
        Programador prog = programadorRepository.findByNombre(name).orElse(null);
        List<Proyecto> result = prog.getProyectos();
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }

    @PostMapping("/programador")
    public ResponseEntity<ProgramadorDTO> save(@RequestBody ProgramadorDTO programadorDTO) {
        try {
            Programador programador = programadorMapper.fromDTO(programadorDTO);
            //checkUsuarioData(programador);
            Programador programadorInsertado = programadorRepository.save(programador);
            return ResponseEntity.ok(programadorMapper.toDTO(programadorInsertado));
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

    @DeleteMapping("/programador/{id}")
    public ResponseEntity<?> borrarProgramador(@PathVariable Long id) {
        programadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }



}
