package org.adrianl.javasoft.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.javasoft.dao.Proyecto;
import org.adrianl.javasoft.dto.ProyectoDto;
import org.adrianl.javasoft.mapper.ProyectoMapper;
import org.adrianl.javasoft.repository.ProyectoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoRepository proyectoRepository;
    private final ProyectoMapper proyectoMapper;

    @GetMapping("/proyectos")
    public ResponseEntity<?> listado(
            // Podemos buscar por los campos que quieramos... nombre, precio... así construir consultas
            //@RequestParam(required = false, name = "nombre") Optional<String> nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        // Consulto en base a las páginas
        Pageable paging = PageRequest.of(page, size, Sort.Direction.ASC, sort);
        Page<Proyecto> pagedResult;
        try {/*
             if (nombre.isPresent()) {
                pagedResult = programadorRepository.findByNombre(nombre.get(), paging);
             } else {
            */
            pagedResult = proyectoRepository.findAll(paging);
            Page<ProyectoDto> dtoList = pagedResult.map(proyectoMapper::toDto);
            return ResponseEntity.ok(dtoList);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
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
    public ResponseEntity<ProyectoDto> nuevoProyecto(@RequestBody ProyectoDto proyectoDto) {
        try {
            Proyecto proyecto = proyectoMapper.fromDto(proyectoDto);
            Proyecto proyectoInsertado = proyectoRepository.save(proyecto);
            return ResponseEntity.ok(proyectoMapper.toDto(proyectoInsertado));
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
