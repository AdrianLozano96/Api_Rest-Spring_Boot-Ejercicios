package org.adrianl.demospring.service;

import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends BaseService<Login, Long, LoginRepository>{


}
