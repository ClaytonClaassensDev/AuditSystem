package com.group12.factory;

import com.group12.entity.Ticket;
import org.junit.Assert;
import org.junit.Test;

public class TicketFactoryTest {


    @Test
    public void createTicket() {
             Ticket ticket = TicketFactory.createTicket("123");
            Assert.assertNotEquals(null, ticket.getTicketId());//if the ticket has a ticketID it has been created


    }

}