package org.adrianl.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.repository.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginRepository loginRepository;

    @GetMapping("/logins")
    public ResponseEntity<?> obtenerTodos() {
        List<Login> result = loginRepository.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            return ResponseEntity.ok(result);   //200
        }
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
        Login result = loginRepository.findById(id).orElse(null);
        if (result == null)
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        else
            return ResponseEntity.ok(result);   //200
    }

    @PostMapping("/login")
    public ResponseEntity<?> nuevoProyecto(@RequestBody Login nuevo) {
        Login saved = loginRepository.save(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);   //201 usuario insertado
    }

    @PutMapping("/login/{id}")
    public ResponseEntity<?> editarLogin(@RequestBody Login editar, @PathVariable Long id) {
        return loginRepository.findById(id).map(p -> {
            p.setCorreo(editar.getCorreo());
            return ResponseEntity.ok(loginRepository.save(p));    //200
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();   //404 not found
        });
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<?> borrarLogin(@PathVariable Long id) {
        loginRepository.deleteById(id);
        return ResponseEntity.noContent().build();  //204 sin contenido
    }

}
