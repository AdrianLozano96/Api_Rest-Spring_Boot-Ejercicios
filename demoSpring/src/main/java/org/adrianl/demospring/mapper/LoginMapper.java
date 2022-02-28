package org.adrianl.demospring.mapper;

import lombok.RequiredArgsConstructor;
import org.adrianl.demospring.dto.LoginDTO;
import org.adrianl.demospring.dto.ProyectoDTO;
import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.model.Proyecto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LoginMapper {
    private final ModelMapper modelMapper;

    public LoginDTO toDTO(Login login) {
        return modelMapper.map(login, LoginDTO.class);
    }
    public Login fromDTO(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, Login.class);
    }
    public List<LoginDTO> toDTO(List<Login> logins) {
        return logins.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<Login> fromDTO(List<LoginDTO> loginDTO) {
        return loginDTO.stream().map(this::fromDTO).collect(Collectors.toList());
    }

}