package com.lits.project.service;

import com.lits.project.dto.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    TicketDTO addTicket(TicketDTO ticket);

    public List<TicketDTO> getAllTickets();

    TicketDTO getTicketById(Long id);

    TicketDTO deleteTicket(Long id);

    TicketDTO updateTicket(Long id,TicketDTO ticketDTO);
}
