package com.lits.project.service;

import com.lits.project.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(Long id);

    public UserDTO deleteUser(Long id);

    public UserDTO updateUser(UserDTO userDTO, Long id);
}