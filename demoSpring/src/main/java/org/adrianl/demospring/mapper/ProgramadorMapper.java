package org.adrianl.demospring.mapper;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.ProgramadorDTO;
import org.adrianl.demospring.model.Programador;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProgramadorMapper {
    private final ModelMapper modelMapper;

    public ProgramadorDTO toDTO(Programador programador) {
        return modelMapper.map(programador, ProgramadorDTO.class);
    }
    public Programador fromDTO(ProgramadorDTO programadorDTO) {
        return modelMapper.map(programadorDTO, Programador.class);

    }
    public List<ProgramadorDTO> toDTO(List<Programador> programador) {
        return programador.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Programador> fromDTO(List<ProgramadorDTO> programador) {
        return programador.stream().map(this::fromDTO).collect(Collectors.toList());
    }

}