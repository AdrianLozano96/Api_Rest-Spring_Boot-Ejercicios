package org.adrianl.javasoft.mapper;

import lombok.RequiredArgsConstructor;
import org.adrianl.javasoft.dao.Proyecto;
import org.adrianl.javasoft.dto.ProyectoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProyectoMapper {
    private final ModelMapper modelMapper;

    public ProyectoDto toDto(Proyecto proyecto) {
        return modelMapper.map(proyecto, ProyectoDto.class);
    }
    public Proyecto fromDto(ProyectoDto proyectoDto) {
        return modelMapper.map(proyectoDto, Proyecto.class);
    }
    public List<ProyectoDto> toDto(List<Proyecto> proyecto) {
        return proyecto.stream().map(this::toDto).collect(Collectors.toList());
    }
    public List<Proyecto> fromDto(List<ProyectoDto> proyecto) {
        return proyecto.stream().map(this::fromDto).collect(Collectors.toList());
    }
}
