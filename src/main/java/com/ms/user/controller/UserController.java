package com.ms.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ms.user.dto.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.service.UserService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {

        var usuario = new UserModel();
        BeanUtils.copyProperties(userRecordDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usuario));

    }
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> userModels = userService.listAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(userModels);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable UUID id) {
        var user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
