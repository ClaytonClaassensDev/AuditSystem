package com.group12.repository.ticket.impl;

import com.group12.entity.Ticket;
import com.group12.repository.ticket.TicketRepository;

import java.util.HashSet;
import java.util.Set;

public class TicketRepositoryImpl implements TicketRepository {

    private static TicketRepository repository = null;
    private Set<Ticket> ticketDB;

    private TicketRepositoryImpl(){ this.ticketDB = new HashSet<>();}

    public static TicketRepository getRepository(){
        if(repository == null) repository = new TicketRepositoryImpl();
        return  repository;
    }

    @Override
    public Ticket create(Ticket t) {
        this.ticketDB.add(t);
        return t;
    }

    @Override
    public Ticket read(String id) {
        Ticket ticket = this.ticketDB.stream()
                .filter(t -> t.getTicketId().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
        return ticket;
    }

    @Override
    public Ticket update(Ticket t) {
        boolean deleteTicket = delete(t.getTicketId());
        if(deleteTicket){
            this.ticketDB.add(t);
            return t;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Ticket ticket = read(id);
        //get the ticket
        if(ticket != null){// ticket exists
            this.ticketDB.remove(ticket);
            return true;
        }
        return false;
    }

    @Override
    public Set<Ticket> getAll() {
        return this.ticketDB;
    }

}
