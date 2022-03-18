package org.adrianl.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.LoginDTO;
import org.adrianl.demospring.mapper.LoginMapper;
import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.pagination.PaginationLinksUtils;
import org.adrianl.demospring.repository.LoginRepository;
import org.adrianl.demospring.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginRepository loginRepository;
    private final LoginService loginService;
    private final LoginMapper loginMapper;
    private final PaginationLinksUtils paginationLinksUtils;

    @GetMapping("/logins")
    //Se recibe un Pageable con el tamaño y la página inicial por defecto, el pageable para el findAll que devuelve un page de Login
    public ResponseEntity<?> obtenerTodos(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                          HttpServletRequest request) { //Para optener la uri actual (la petición)
        Page<Login> result = loginService.findAll(pageable);

        if (result.isEmpty()) {
            //throw new ProductoNotFoundException();
            return ResponseEntity.notFound().build();
        } else {

            Page<LoginDTO> dtoList = result.map(loginMapper::toDTO);    //Se devuelve un Page de Login
            //Para obtener la paginación
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
            //Encabezado link con los componentes de paginationLinks, pasandole los resultados y la uri
            return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(dtoList, uriBuilder))
                    .body(dtoList);

        }

    }

/*
    @GetMapping("/logins")
    public ResponseEntity<?> obtenerTodos() {
        List<Login> result = loginRepository.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();   //404 no hay usuarios
        } else {
            return ResponseEntity.ok(result);   //200
        }
    }

 */

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
