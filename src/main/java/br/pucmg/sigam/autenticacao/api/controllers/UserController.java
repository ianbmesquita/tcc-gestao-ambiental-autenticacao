package br.pucmg.sigam.autenticacao.api.controllers;

import br.pucmg.sigam.autenticacao.api.dtos.UserRequestDTO;
import br.pucmg.sigam.autenticacao.api.dtos.UserResponseDTO;
import br.pucmg.sigam.autenticacao.application.domain.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    private ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok().body(service.getAllUsers());
    }

    @PostMapping
    private ResponseEntity<UserResponseDTO> saveNewUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity(service.saveNewUser(userRequestDTO), HttpStatus.CREATED);
    }
}
