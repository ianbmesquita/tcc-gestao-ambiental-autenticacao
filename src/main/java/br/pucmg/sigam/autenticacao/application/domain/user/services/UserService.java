package br.pucmg.sigam.autenticacao.application.domain.user.services;

import br.pucmg.sigam.autenticacao.api.dtos.UserRequestDTO;
import br.pucmg.sigam.autenticacao.application.domain.user.mappers.UserMapper;
import br.pucmg.sigam.autenticacao.application.domain.user.models.User;
import br.pucmg.sigam.autenticacao.infra.dataproviders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User saveNewUser(final UserRequestDTO userRequestDTO) {
        return repository.save(mapper.convertUserRequestDTOToUserEntity(userRequestDTO));
    }
}
