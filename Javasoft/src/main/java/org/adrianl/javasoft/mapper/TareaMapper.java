package org.adrianl.javasoft.mapper;

import lombok.RequiredArgsConstructor;
import org.adrianl.javasoft.dao.Tarea;
import org.adrianl.javasoft.dto.TareaDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TareaMapper {
    private final ModelMapper modelMapper;

    public TareaDto toDto(Tarea tarea) {
        return modelMapper.map(tarea, TareaDto.class);
    }
    public Tarea fromDto(TareaDto tareaDto) {
        return modelMapper.map(tareaDto, Tarea.class);

    }
    public List<TareaDto> toDto(List<Tarea> tarea) {
        return tarea.stream().map(this::toDto).collect(Collectors.toList());
    }
    public List<Tarea> fromDto(List<TareaDto> tarea) {
        return tarea.stream().map(this::fromDto).collect(Collectors.toList());
    }
}
