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
 * Desc: Repository Implementation Test for report
 * Date: 28 August 2020
 */

public class TicketRepositoryImplTest {

    private static TicketRepository repository = TicketRepositoryImpl.getRepository();
    private static Issue issue = IssueFactory.createIssue("Health","First aid kits need replacing","Unsolved");
    private static Ticket ticket = TicketFactory.createTicket(issue);
    private static Issue newIss = IssueFactory.createIssue("Health","First aid kits need replacing","Resolved");
    @Test
    public void a_create() {
        Ticket created = repository.create(ticket);
        Assert.assertEquals(ticket.getTicketId(), created.getTicketId());
        System.out.println("Created: "+created);
    }

    @Test
    public void b_read() {
        Ticket read = repository.read(ticket.getTicketId());
        Assert.assertEquals(ticket, read);
        System.out.println("Read: "+ read);
    }

    @Test
    public void c_update() {

        Ticket updated = new Ticket.Builder().copy(ticket).setTicketIssue(newIss).build();
        updated = repository.update(updated);
        Assert.assertEquals("Resolved",updated.getTicketIssue().getIssueStatus());
        System.out.println("Updated: "+ updated);

    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(ticket.getTicketId());
        assertTrue(deleted);
    }

    @Test
    public void d_getAll() {
        System.out.println("All Tickets: " + repository.getAll());
        assertEquals(1, repository.getAll().size());
    }
}