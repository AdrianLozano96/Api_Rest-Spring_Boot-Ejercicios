package org.adrianl.javasoft.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dao.Tarea;
import org.adrianl.javasoft.dto.TareaDto;
import org.adrianl.javasoft.mapper.TareaMapper;
import org.adrianl.javasoft.repository.TareaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TareaController {

    private final TareaRepository tareaRepository;
    private final TareaMapper tareaMapper;

    @GetMapping("/tareas")
    public ResponseEntity<?> obtenerTodos() {
        List<Tarea> result = tareaRepository.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            List<TareaDto> listDto = result.stream().map(tareaMapper::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(listDto); //200
            //return ResponseEntity.ok(result); //200
        }
    }

    @GetMapping("/tarea/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
        Tarea result = tareaRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(tareaMapper.toDto(result));   //200
    }

    @PostMapping("/tarea")
    public ResponseEntity<TareaDto> save(@RequestBody TareaDto tareaDto) {
        try {
            Tarea tarea = tareaMapper.fromDto(tareaDto);
            Tarea tareaInsertado = tareaRepository.save(tarea);
            return ResponseEntity.ok(tareaMapper.toDto(tareaInsertado));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Insertar, Error al insertar el tarea. Campos incorrectos " + e.getMessage());
        }
    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<?> borrarTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }

//----------------------------------------------------------------------------------------------------------------------
    @GetMapping("/tarea/{id}/actividades")
    public ResponseEntity<?> obtenerActividad(@PathVariable Long id) {
        Tarea result = tareaRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result.getActividad());   //200
    }
    //MIRAR
    @PostMapping("/tarea/actividad")
    public ResponseEntity<TareaDto> saveActividad(@RequestBody TareaDto tareaDto) {
        try {
            Tarea tarea = tareaMapper.fromDto(tareaDto);
            Tarea tareaInsertado = tareaRepository.save(tarea);
            return ResponseEntity.ok(tareaMapper.toDto(tareaInsertado));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Insertar, Error al insertar el tarea. Campos incorrectos " + e.getMessage());
        }
    }
    @PutMapping("/tarea/{id}/actividades")
    public ResponseEntity<?> editarActividades(@RequestBody Tarea editar, @PathVariable Long id) {
        return tareaRepository.findById(id).map(p -> {
            p.setActividad(editar.getActividad());
            return ResponseEntity.ok(tareaRepository.save(p));    //200
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();   //404 not found
        });
    }
    //MIRAR
    @DeleteMapping("/tarea/{id}/actividades")
    public ResponseEntity<?> borrarTareaActividad(@PathVariable Long id) {
        tareaRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }

}
