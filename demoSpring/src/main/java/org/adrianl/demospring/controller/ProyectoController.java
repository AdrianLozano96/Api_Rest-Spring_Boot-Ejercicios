package org.adrianl.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.ProyectoDTO;
import org.adrianl.demospring.mapper.ProyectoMapper;
import org.adrianl.demospring.model.Programador;
import org.adrianl.demospring.model.Proyecto;
import org.adrianl.demospring.repository.ProgramadorRepository;
import org.adrianl.demospring.repository.ProyectoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/app")
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;
    private final ProgramadorRepository programadorRepository;
    private final ProyectoMapper proyectoMapper;

    @GetMapping("/proyectos")
    public ResponseEntity<?> obtenerTodos() {
        List<Proyecto> result = proyectoRepository.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            return ResponseEntity.ok(result);   //200
        }
    }

    @GetMapping("/proyectos/progr/{name}")
    public ResponseEntity<?> obtenerTodosPorProgramador(@PathVariable String nombre) {
        Programador prog = programadorRepository.findByNombre(nombre).orElse(null);
        List<Proyecto> result = prog.getProyectos(); //proyectoRepository.findByProgramador(prog);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            return ResponseEntity.ok(result);   //200
        }
    }

    @GetMapping("/proyecto/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
        Proyecto result = proyectoRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }

    @PostMapping("/proyecto")
    public ResponseEntity<ProyectoDTO> nuevoProyecto(@RequestBody ProyectoDTO proyectoDTO) {
        try {
            Proyecto proyecto = proyectoMapper.fromDTO(proyectoDTO);
            Proyecto proyectoInsertado = proyectoRepository.save(proyecto);
            return ResponseEntity.ok(proyectoMapper.toDTO(proyectoInsertado));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Insertar, Error al insertar el proyecto. Campos incorrectos " + e.getMessage());
        }
    }

    @PutMapping("/proyecto/{id}")
    public ResponseEntity<?> editarProyecto(@RequestBody Proyecto editar, @PathVariable Long id) {
        return proyectoRepository.findById(id).map(p -> {
            p.setNombre(editar.getNombre());
            return ResponseEntity.ok(proyectoRepository.save(p));    //200
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();   //404 not found
        });
    }

    @DeleteMapping("/proyecto/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable Long id) {
        proyectoRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }
}
