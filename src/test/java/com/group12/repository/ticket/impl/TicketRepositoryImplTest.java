package com.group12.repository.ticket.impl;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.factory.IssueFactory;
import com.group12.factory.TicketFactory;
import com.group12.repository.ticket.TicketRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * @author Stefano Ngantweni - 216283132
 * Desc: Repository Implementation test for ticket
 * Date: 28 August 2020
 */

public class TicketRepositoryImplTest {

    private static TicketRepository repository = TicketRepositoryImpl.getRepository();//
    private static Issue issue = IssueFactory.createIssue("Health","First aid kits need replacing","Unsolved");
    private static Ticket ticket = TicketFactory.createTicket(issue);
    private static Issue newIss = IssueFactory.createIssue("Health","First aid kits need replacing","Resolved");

   //This checks if the ticketId of the ticket created is the same as the one parsed into the method
    @Test
    public void a_create() {
        Ticket created = repository.create(ticket);
        Assert.assertEquals(ticket.getTicketId(), created.getTicketId());
        System.out.println("Created: "+created);
    }

    //This checks if the read method returns the correct ticket
    @Test
    public void b_read() {
        Ticket read = repository.read(ticket.getTicketId());
        Assert.assertEquals(ticket, read);
        System.out.println("Read: "+ read);
    }

    //This method checks if you can update a Ticket in the repository
    @Test
    public void c_update() {

        Ticket updated = new Ticket.Builder()
                .copy(ticket)
                .setTicketIssue(newIss)
                .build();
        updated = repository.update(updated);
        Assert.assertEquals("Resolved",updated.getTicketIssue().getIssueStatus());
        System.out.println("Updated: "+ updated);

    }

    //This method checks if you can delete a Ticket in the repository
    @Test
    public void e_delete() {
        boolean deleted = repository.delete(ticket.getTicketId());
        assertTrue(deleted);
    }

    //This method checks if you can return all the Tickets in the repository
    @Test
    public void d_getAll() {
        System.out.println("All Tickets: " + repository.getAll());
        assertEquals(1, repository.getAll().size());
    }
}