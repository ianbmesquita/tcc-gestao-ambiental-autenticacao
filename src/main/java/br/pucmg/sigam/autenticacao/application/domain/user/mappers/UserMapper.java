package br.pucmg.sigam.autenticacao.application.domain.user.mappers;

import br.pucmg.sigam.autenticacao.api.dtos.UserRequestDTO;
import br.pucmg.sigam.autenticacao.application.domain.user.models.User;
import br.pucmg.sigam.autenticacao.application.domain.user.models.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertUserRequestDTOToUserEntity(final UserRequestDTO requestDTO) {
        return User.builder()
                .name(requestDTO.getName())
                .login(requestDTO.getLogin())
                .password(requestDTO.getPassword())
                .role(UserRole.valueOf(requestDTO.getRole()))
                .locked(Boolean.FALSE)
                .build();
    }
}
