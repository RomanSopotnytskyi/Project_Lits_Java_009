package com.lits.project.service.impl;

import com.lits.project.dto.UserDTO;
import com.lits.project.exception.UserNotFoundException;
import com.lits.project.models.User;
import com.lits.project.repository.UserRepository;
import com.lits.project.service.UserService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    //@Autowired
    //private TicketService ticketService;

    @Override
    public UserDTO addUser(UserDTO userDTO){
        User user = userRepository.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)), UserDTO.class);
    }

    @Override
    public UserDTO deleteUser(Long id){
        UserDTO userDTO = getUserById(id);
        userRepository.delete(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        return userRepository.findById(id).map(userToEdit -> {
            userToEdit.setUsername(userDTO.getUsername());
            userToEdit.setPassword(userDTO.getPassword());
            userToEdit.setStatus(userDTO.getStatus());
            userToEdit.setEmail(userDTO.getEmail());
            userToEdit.setAge(userDTO.getAge());
            userToEdit.setFirstname(userDTO.getFirstname());
            userToEdit.setLastname(userDTO.getLastname());
            userRepository.save(userToEdit);
            return modelMapper.map(userToEdit, UserDTO.class);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }
/*
    @Transactional
    public User addTicketToUser(Long userId, Long ticketId){
        User user = get(userId); //getUserById
        Ticket ticket = ticketService.getTicket(ticketId);
        if(Objects.nonNull(ticket.getUser())){
            throw new TicketIsAlreadyAssignedException(ticketId,
                    ticket.getUser().getIdUser());
        }
        user.addTickets(ticket);
        ticket.setUser(user);
        return user;
    }
    @Transactional
    public User removeTicketToUser(Long userId, Long ticketId){
        User user = get(userId);     //getUserById
        Ticket ticket = ticketService.getTicket(ticketId);
        user.deleteTickets(ticket);
        return user;
    }
*/

}
