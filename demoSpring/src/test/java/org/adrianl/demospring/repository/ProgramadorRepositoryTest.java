package org.adrianl.demospring.repository;

import org.adrianl.demospring.model.Programador;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ProgramadorRepositoryTest {

    private final Programador programadorTestId = Programador.builder()
            .id(1)
            .nombre("Manuel")
            .salario(10.0)
            .build();

    @Autowired
    private ProgramadorRepository programadorRepository;

    @Test
    @Order(1)
    public void save() {
        Programador programador = programadorRepository.save(programadorTestId);
        assertAll(
                () -> assertNotNull(programador),
                () -> assertEquals(programadorTestId.getId(), programador.getId()),
                () -> assertEquals(programadorTestId.getNombre(), programador.getNombre()),
                () -> assertEquals(programadorTestId.getSalario(), programador.getSalario())
        );
    }

    @Test
    @Order(2)
    public void getAllProgramadores() {
        List<Programador> programadors = programadorRepository.findAll();
        assertAll(
                () -> assertTrue(programadors.size() > 0),
                () -> assertEquals(programadors.get(0).getId(), programadorTestId.getId())
        );
    }

    @Test
    @Order(3)
    public void getProgramadorById() {
        var programador = programadorRepository.save(programadorTestId);
        var programadorId = programadorRepository.findById(programador.getId()).get();
        assertAll(
                () -> assertNotNull(programadorId),
                () -> assertEquals(programador.getId(), programadorId.getId()),
                () -> assertEquals(programador.getNombre(), programadorId.getNombre()),
                () -> assertEquals(programador.getSalario(), programadorId.getSalario())
        );
    }

    @Test
    @Order(4)
    public void updateProgramador() {
        var prog = programadorRepository.save(programadorTestId);
        prog = programadorRepository.findById(prog.getId()).get();
        prog.setNombre("Jose");
        var res = programadorRepository.save(prog);
        assertAll(
                () -> assertNotNull(res),
                () -> assertEquals(programadorTestId.getId(), res.getId()),
                () -> assertEquals("Jose", res.getNombre()),
                () -> assertEquals(programadorTestId.getSalario(), res.getSalario())
        );
    }

    @Test
    @Order(5)
    public void deleteProgramador() {
        Programador programador = programadorRepository.save(programadorTestId);
        programador = programadorRepository.findById(programador.getId()).get();
        programadorRepository.delete(programador);
        assertNull(programadorRepository.findById(programador.getId()).orElse(null));
    }

    @Test
    void findByNombre() {
    }
}