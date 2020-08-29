package com.group12.repository.ticket;

import com.group12.entity.Ticket;
import com.group12.repository.IRepository;

import java.util.Set;

public interface TicketRepository extends IRepository<Ticket, String> {
        Set<Ticket> getAll();
}
