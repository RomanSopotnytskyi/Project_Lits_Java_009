package com.lits.project.exception;

import java.text.MessageFormat;

public class TicketIsAlreadyAssignedException extends RuntimeException{
    public TicketIsAlreadyAssignedException(final Long ticketId, final Long userId){
        super(MessageFormat.format("ticet: {0} is already assigned to user: {1}", ticketId, userId));
    }
}
