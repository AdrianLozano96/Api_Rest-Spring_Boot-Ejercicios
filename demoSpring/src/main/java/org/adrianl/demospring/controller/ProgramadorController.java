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
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProgramadorController {

    private final ProgramadorRepository programadorRepository;
    private final ProgramadorMapper programadorMapper;

    @GetMapping("/programadores")
    public ResponseEntity<?> obtenerTodos() {
        List<Programador> result = programadorRepository.findAll(); //Se crea una lista
        if (result.isEmpty()) { //Si la lista esta vacia devolver una respuesta
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {    //Si la lista tiene contenido se devuelve
            //return ResponseEntity.ok(result);   //200
            List<ProgramadorDTO> listDTO = result.stream().map(programadorMapper::toDTO).collect(Collectors.toList());
            return ResponseEntity.ok(listDTO);
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
        return programadorRepository.findById(id).map(p -> { //Lo que se devuelve el elemento editado
            p.setNombre(editar.getNombre());//Lo que se va a editar del producto
            return ResponseEntity.ok(programadorRepository.save(p));    //200
        }).orElseGet(() -> {    //Sino encuentra el elemento devolver mensaje
            return ResponseEntity.notFound().build();   //404 not found
        });
    }

    @DeleteMapping("/programador/{id}")
    public ResponseEntity<?> borrarProgramador(@PathVariable Long id) {
        programadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }



}
