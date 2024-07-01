package com.comparus.demo.controller;

import com.comparus.demo.api.UserApi;
import com.comparus.demo.api.model.User;
import com.comparus.demo.domain.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = new ArrayList<>();
        for (String dataSource : userService.getDataSources()) {
            users.addAll(userService.getAllUsers(dataSource));
        }
        return ResponseEntity.ok(users);
    }
}
