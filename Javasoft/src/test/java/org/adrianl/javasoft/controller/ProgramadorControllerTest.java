package org.adrianl.javasoft.controller;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dto.ProgramadorDto;
import org.adrianl.javasoft.mapper.ProgramadorMapper;
import org.adrianl.javasoft.repository.ProgramadorRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = {ProgramadorController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProgramadorControllerTest {

    private List<ProgramadorDto> programadoresDTO;
    private List<Programador> programadores;
    @InjectMocks
    private ProgramadorController controller;
    @MockBean
    private ProgramadorRepository repository;
    @MockBean
    private ProgramadorMapper mapper;
    private Programador programador;
    private ProgramadorDto programadorDTO;

    @BeforeAll
    void beforeAll(){
        controller = new ProgramadorController(repository, mapper);
        programador = Programador.builder().id(1).nombre("José").username("user1").correo("programador@hotmail.com").avatar("avatar1").build();
        programadorDTO = new ProgramadorDto(1, "José", "user1", "programador@hotmail.com", "avatar1");
        programadores = new ArrayList<>();
        programadores.add(programador);
        programadoresDTO = new ArrayList<>();
        programadoresDTO.add(programadorDTO);
    }

    @Test
    @Order(1)
    void obtenerTodos() {
        when(repository.findAll()).thenReturn(programadores);
        when(mapper.toDto(programadores)).thenReturn(programadoresDTO);
        ResponseEntity<List<Programador>> response = controller.obtenerTodos();//Cambiar a dto
        List<Programador>responseList = response.getBody(); //Cambiar a DTO
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(programadores.size(), responseList.size()),
                () -> assertEquals(programadoresDTO.size(), responseList.size()),
                () -> assertEquals(programadores.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(programadoresDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(programadores.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(programadoresDTO.get(0).getNombre(), responseList.get(0).getNombre())
        );
        verify(repository, times(1)).findAll();
//        verify(mapper, times(1)).toDto(programadores);
    }

    @Test
    @Order(2)
    void obtenerUno() {
        when(mapper.toDto(programador)).thenReturn(programadorDTO);
        when(repository.findById(1L)).thenReturn(Optional.of(programador));
        ResponseEntity response = controller.obtenerUno(1L);
        //ProgramadorDto programadorResponse = (ProgramadorDto) response.getBody();
        Programador programadorResponse = (Programador) response.getBody();
        assertAll(
                () -> assertNotNull(programadorResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(programadorDTO.getId(), programadorResponse.getId()),
                () -> assertEquals(programadorDTO.getNombre(), programadorResponse.getNombre()),
                () -> assertEquals(programadorDTO.getUsername(), programadorResponse.getUsername()),
                () -> assertEquals(programadorDTO.getCorreo(), programadorResponse.getCorreo()),
                () -> assertEquals(programadorDTO.getAvatar(), programadorResponse.getAvatar())
        );
        //verify(mapper, times(1)).toDto(programador);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @Order(3)
    void obtenerPorNombre() {
        /*
        when(mapper.toDto(programadores)).thenReturn(programadoresDTO);
        when(repository.findByNombre("José")).thenReturn(Optional.of(programador));
        ResponseEntity response = controller.obtenerPorNombre("José");
        Programador responseList = (Programador) response.getBody();    //Porque en el controlador da Object <?>
        assertAll(
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(infras.size(), responseList.size()),
                () -> assertEquals(infrasDTO.size(), responseList.size()),
                () -> assertEquals(infras.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(infrasDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(infras.get(0).getTipo(), responseList.get(0).getTipo()),
                () -> assertEquals(infrasDTO.get(0).getTipo(), responseList.get(0).getTipo())
        );
        verify(repository, times(1)).findAllByTipo("tipo_prueba");
        verify(mapper, times(1)).toDTOList(infras);

         */

    }

    @Test
    @Order(4)
    void save() {
        when(repository.save(programador)).thenReturn(programador);
        when(mapper.fromDto(programadorDTO)).thenReturn(programador);
        when(mapper.toDto(programador)).thenReturn(programadorDTO);
        ResponseEntity<ProgramadorDto> response = controller.save(programadorDTO);  //Porque en el controller esta DTO
        ProgramadorDto infraDTOResponse = response.getBody();
        assertAll(
                () -> assertNotNull(infraDTOResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(programadorDTO.getId(), infraDTOResponse.getId()),
                () -> assertEquals(programadorDTO.getNombre(), infraDTOResponse.getNombre())
        );
        verify(mapper, times(1)).fromDto(programadorDTO);
        verify(mapper, times(1)).toDto(programador);
        verify(repository, times(1)).save(programador);
    }

    @Test
    @Order(5)
    void editarProgramador() {
        /*
        when(repository.save(programador)).thenReturn(programador);
        //when(mapper.fromDto(programadorDTO)).thenReturn(programador);
        //when(mapper.toDto(programador)).thenReturn(programadorDTO);
        ResponseEntity response = controller.editarProgramador(programador, programador.getId());
        //ResponseEntity response = controller.obtenerUno(1L);
        Programador programadorResponse = (Programador) response.getBody();
        assertAll(
                () -> assertNotNull(programadorResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(programador.getId(), programadorResponse.getId()),
                () -> assertEquals(programadorDTO.getNombre(), programadorResponse.getNombre())
        );
        verify(mapper, times(1)).fromDto(programadorDTO);
        verify(mapper, times(1)).toDto(programador);
        verify(repository, times(1)).save(programador);

         */
    }

    @Test
    @Order(6)
    void borrarProgramador() {
        doNothing().when(repository).deleteById(1L);
        when(repository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity response = controller.borrarProgramador(1L);
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById(1L);
       // verify(repository, times(1)).findById(1L);
    }
}