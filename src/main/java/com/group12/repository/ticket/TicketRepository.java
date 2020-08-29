package com.group12.repository.ticket;

import com.group12.entity.Ticket;
import com.group12.repository.IRepository;

import java.util.Set;
/**
 * @author Stefano Ngantweni - 216283132
 * Desc: Repository Interface for ticket
 * Date: 28 August 2020
 */

public interface TicketRepository extends IRepository<Ticket, String> {
        Set<Ticket> getAll();
}
