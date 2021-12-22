package com.lits.project.service.impl;

import com.lits.project.dto.TicketDTO;
import com.lits.project.exception.TicketNotFoundException;
import com.lits.project.models.Ticket;
import com.lits.project.repository.TicketRepository;
import com.lits.project.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = StreamSupport.stream(ticketRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return tickets.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TicketDTO addTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.save(modelMapper.map(ticketDTO, Ticket.class));
        return modelMapper.map(ticket, TicketDTO.class);
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        return modelMapper.map(ticketRepository.findById(id).orElseThrow(()->new TicketNotFoundException(id)), TicketDTO.class);
    }

    @Override
    public TicketDTO deleteTicket(Long id){
        TicketDTO ticketDTO = getTicketById(id);
        ticketRepository.delete(modelMapper.map(ticketDTO, Ticket.class));
        return ticketDTO;
    }

    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        return ticketRepository.findById(id).map(ticketToEdit -> {
            ticketToEdit.setPlace(ticketDTO.getPlace());
            ticketToEdit.setPrice(ticketDTO.getPrice());
            ticketToEdit.setStatus(ticketDTO.getStatus());
            ticketToEdit.setType(ticketDTO.getType());
            ticketRepository.save(ticketToEdit);
            return modelMapper.map(ticketToEdit, TicketDTO.class);
        }).orElseThrow(() -> new TicketNotFoundException(id));
    }
}
