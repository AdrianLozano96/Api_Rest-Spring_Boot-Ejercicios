package org.adrianl.demospring.mapper;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.ProyectoDTO;
import org.adrianl.demospring.model.Proyecto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProyectoMapper {
    private final ModelMapper modelMapper;

    public ProyectoDTO toDTO(Proyecto proyecto) {
        return modelMapper.map(proyecto, ProyectoDTO.class);
    }
    public Proyecto fromDTO(ProyectoDTO proyectoDTO) {
        return modelMapper.map(proyectoDTO, Proyecto.class);
    }
    public List<ProyectoDTO> toDTO(List<Proyecto> proyectos) {
        return proyectos.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<Proyecto> fromDTO(List<ProyectoDTO> proyectoDTO) {
        return proyectoDTO.stream().map(this::fromDTO).collect(Collectors.toList());
    }

}
