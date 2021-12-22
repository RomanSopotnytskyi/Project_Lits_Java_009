package com.lits.project.rest;

import com.lits.project.dto.TicketDTO;
import com.lits.project.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAll(){
        List<TicketDTO> ticketDTO = ticketService.getAllTickets();
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<TicketDTO> addUser(@Validated @RequestBody TicketDTO ticketDTO){
        return new ResponseEntity<>(ticketService.addTicket(ticketDTO), HttpStatus.CREATED);
    }

    @GetMapping("/ticket/{id}")
    public TicketDTO getById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @DeleteMapping("/ticket/{id}")
    public TicketDTO delete(@PathVariable Long id) {
        return ticketService.deleteTicket(id);
    }

    @PutMapping("/ticket/{id}")
    public TicketDTO updateTicket(@PathVariable("id") Long id,@Validated @RequestBody TicketDTO ticketDTO) {
        return ticketService.updateTicket(id, ticketDTO);
    }
}
