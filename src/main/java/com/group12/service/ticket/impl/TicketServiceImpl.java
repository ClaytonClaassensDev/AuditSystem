package com.group12.service.ticket.impl;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.repository.ticket.TicketRepository;
import com.group12.repository.ticket.impl.TicketRepositoryImpl;
import com.group12.service.ticket.TicketService;

import java.util.HashSet;
import java.util.Set;

/**
        * @author Stefano Ngantweni - 216283132
        * Desc: Service Implementation class for ticket
        * Date: 4 September 2020
        */


public class TicketServiceImpl implements TicketService {

    private static TicketService service = null;
    private TicketRepository repository;

    private TicketServiceImpl(){
        this.repository = TicketRepositoryImpl.getRepository();}


    //to get the Service you want to work on
    public static TicketService getService(){
        if(service == null) service = new TicketServiceImpl();
        return  service;
    }

    /**
     * Business Logic
     */
    //Business Logic 1: When you want close a ticket when the issue has been resolved
    public boolean closeTicket(Issue iss, Ticket ticket){
        boolean ticketClose = false;
        Issue issSolved = new Issue.Builder().copy(iss).setIssueStatus("Resolved").build();
        Ticket tcktSolved;
        if(!(iss.getIssueStatus().equalsIgnoreCase("Resolved"))){
            tcktSolved = new Ticket.Builder().copy(ticket).setTicketIssue(issSolved).build();
            update(tcktSolved);
            ticketClose = true;
            System.out.println("Ticket has been closed");
        }

        return ticketClose;
    }

    //Business Logic 2: When you want close a ticket when the issue has been resolved
    public Set<Ticket> getAllOpen(){
        Set<Ticket> openTick = new HashSet<>();

        for(Ticket ticket: repository.getAll()){
            if(ticket.getTicketIssue().getIssueStatus().equalsIgnoreCase("Unresolved")){
                openTick.add(ticket);
            }
        }
        return openTick;
    }



    //CRUD
    @Override
    public Ticket create(Ticket t) {
        return this.repository.create(t);
    }

    @Override
    public Ticket read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Ticket update(Ticket t) {
        return this.repository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<Ticket> getAll() {
        return this.repository.getAll();
    }
}
