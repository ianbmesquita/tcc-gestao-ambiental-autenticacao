package br.pucmg.sigam.autenticacao.api.controllers;

import br.pucmg.sigam.autenticacao.api.dtos.UserRequestDTO;
import br.pucmg.sigam.autenticacao.application.domain.user.models.User;
import br.pucmg.sigam.autenticacao.application.domain.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    private List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    private ResponseEntity<User> saveNewUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(service.saveNewUser(userRequestDTO));
    }
}
