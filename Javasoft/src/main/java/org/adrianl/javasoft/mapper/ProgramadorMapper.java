package org.adrianl.javasoft.mapper;


import lombok.RequiredArgsConstructor;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dto.ProgramadorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProgramadorMapper {
    private final ModelMapper modelMapper;

    public ProgramadorDto toDto(Programador programador) {
        return modelMapper.map(programador, ProgramadorDto.class);
    }
    public Programador fromDto(ProgramadorDto programadorDto) {
        return modelMapper.map(programadorDto, Programador.class);
    }
    public List<ProgramadorDto> toDto(List<Programador> programador) {
        return programador.stream().map(this::toDto).collect(Collectors.toList());
    }
    public List<Programador> fromDto(List<ProgramadorDto> programador) {
        return programador.stream().map(this::fromDto).collect(Collectors.toList());
    }

}