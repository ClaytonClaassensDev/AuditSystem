package com.group12.entity;

import java.time.LocalDate;
/** Author: Stefano Ngantweni
 *   Student no: 216 283 132
 *   Date: 02-07-2020
 *   Description: Entity for Ticket
 */

public class Ticket {
    private String ticketId;
    private String ticketDesc;
    private Issue ticketIssue;
    private LocalDate ticketDate;

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.ticketDesc = builder.ticketDesc;
        this.ticketIssue = builder.ticketIssue;
        this.ticketDate = builder.ticketDate;
    }

    //Getters
    public String getTicketId() { return ticketId; }
    public String getTicketDesc() { return ticketDesc; }
    public Issue getTicketIssue() { return ticketIssue; }
    public LocalDate getTicketDate() { return ticketDate; }

    @Override
    public String toString() {
        return "Builder{" +
                "ticketId=" + ticketId +
                ", ticketDesc='" + ticketDesc + '\'' +
                ", ticketIssue=" + ticketIssue +
                ", ticketDate=" + ticketDate +
                '}';
    }

    //Builder inner-class
    public static class Builder{
        private String ticketId;
        private String ticketDesc;
        private Issue ticketIssue;
        private LocalDate ticketDate;

        //Setters
        public Builder setTicketId(String ticketId) { this.ticketId = ticketId;
            return this;}
        public Builder setTicketDesc(String ticketDesc) { this.ticketDesc = ticketDesc;
            return this;}
        public Builder setTicketIssue(Issue ticketIssue) { this.ticketIssue = ticketIssue;
            return this;}
        public Builder setTicketDate(LocalDate ticketDate) { this.ticketDate = ticketDate;
            return this;}

        //build method
        public Ticket build(){return new Ticket(this);}

        //copy method
        public Ticket.Builder copy( Ticket ticket)
        {
            this.ticketId = ticket.ticketId;
            this.ticketDesc = ticket.ticketDesc;
            this.ticketIssue = ticket.ticketIssue;
            this.ticketDate = ticket.ticketDate;
            return this;
        }
    }
}