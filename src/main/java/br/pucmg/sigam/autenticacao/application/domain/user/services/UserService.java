package br.pucmg.sigam.autenticacao.application.domain.user.services;

import br.pucmg.sigam.autenticacao.api.dtos.UserRequestDTO;
import br.pucmg.sigam.autenticacao.api.dtos.UserResponseDTO;
import br.pucmg.sigam.autenticacao.application.domain.user.mappers.UserMapper;
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

    public List<UserResponseDTO> getAllUsers() {
        return mapper.convertListUserEntityToListUserResponseDTO(repository.findAll());
    }

    public UserResponseDTO saveNewUser(final UserRequestDTO userRequestDTO) {
        var user = repository.save(mapper.convertUserRequestDTOToUserEntity(userRequestDTO));

        return mapper.convertUserEntityToUserResponseDTO(user);
    }
}
