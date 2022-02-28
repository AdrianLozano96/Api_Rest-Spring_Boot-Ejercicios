package org.adrianl.demospring.mapper;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.RepositorioDTO;
import org.adrianl.demospring.model.Repositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RepositorioMapper {
    private final ModelMapper modelMapper;

    public RepositorioDTO toDTO(Repositorio repositorio) {
        return modelMapper.map(repositorio, RepositorioDTO.class);
    }
    public Repositorio fromDTO(RepositorioDTO repositorioDTO) {
        return modelMapper.map(repositorioDTO, Repositorio.class);
    }
    public List<RepositorioDTO> toDTO(List<Repositorio> repositorios) {
        return repositorios.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<Repositorio> fromDTO(List<RepositorioDTO> repositorioDTO) {
        return repositorioDTO.stream().map(this::fromDTO).collect(Collectors.toList());
    }

}