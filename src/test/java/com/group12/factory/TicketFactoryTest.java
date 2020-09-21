package com.group12.factory;

import com.group12.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class TicketFactoryTest {

    Issue issueTest = IssueFactory.createIssue("", "");
    @Test
    public void createTicket() {
            Ticket ticket = TicketFactory.createTicket(issueTest);
            Assert.assertNotEquals(null, ticket.getTicketId());//if the ticket has a ticketID it has been created
            System.out.println(ticket);

    }

}