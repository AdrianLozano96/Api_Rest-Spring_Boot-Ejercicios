package org.adrianl.javasoft.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dto.ProgramadorDto;
import org.adrianl.javasoft.mapper.ProgramadorMapper;
import org.adrianl.javasoft.repository.ProgramadorRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProgramadorControllerTestMockMVC {

    @MockBean
    private ProgramadorRepository programadorRepository;
    @MockBean
    private ProgramadorMapper programadorMapper;

    private final Programador programador = Programador.builder()
            .id(1)
            .nombre("nombre")
            .build();
    private final ProgramadorDto programadorDto = ProgramadorDto.builder()
            .nombre(programador.getNombre())
            .build();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    public ProgramadorControllerTestMockMVC(ProgramadorRepository programadorRepository, ProgramadorMapper programadorMapper) {
        this.programadorRepository = programadorRepository;
        this.programadorMapper = programadorMapper;
    }

    @Test
    @Order(1)
    void findAllTest() throws Exception {
        Mockito.when(programadorRepository.findAll()).thenReturn(List.of(programador));
        Mockito.when(programadorMapper.toDto(List.of(programador))).thenReturn(List.of(programadorDto));
        mockMvc
                .perform(
                        get("/programadores")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is(programador.getNombre())))
                .andReturn();
        Mockito.verify(programadorRepository, Mockito.times(1)).findAll();
//        Mockito.verify(programadorMapper, Mockito.times(1)).toDto(List.of(programador));
    }

    @Test
    @Order(2)
    void findByIdTest() throws Exception {
        Mockito.when(programadorRepository.findById(programador.getId()))
                .thenReturn(Optional.of(programador));
        Mockito.when(programadorMapper.toDto(programador)).thenReturn(programadorDto);
        mockMvc.perform(
                        get("/programador/" + programador.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is(programador.getNombre())))
                .andReturn();
        Mockito.verify(programadorRepository, Mockito.times(1)).findById(programador.getId());
//        Mockito.verify(programadorMapper, Mockito.times(1)).toDto(programador);
    }
}