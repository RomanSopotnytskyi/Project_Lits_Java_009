package com.lits.project.rest;

import com.lits.project.dto.UserDTO;
import com.lits.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> addUser(@Validated @RequestBody UserDTO user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id,@Validated @RequestBody UserDTO user) {
        return userService.updateUser(user, id);
    }
}

