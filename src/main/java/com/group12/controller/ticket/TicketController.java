package com.group12.controller.ticket;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.factory.IssueFactory;
import com.group12.factory.TicketFactory;
import com.group12.service.issue.impl.IssueServiceImpl;
import com.group12.service.ticket.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    IssueServiceImpl IssueService;
    //Issue issue = IssueFactory.createIssue("Health","First Aid");//I create an Issue because I dont have the IssueController details yet

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket){

        Issue issue = IssueService.getIssueByID(ticket.getTicketIssue().getIssueID());// This will be used once I can use Issue class
            Ticket newTick = null;
            newTick = TicketFactory.createTicket(issue);

            return ticketService.create(ticket);

    }

    @GetMapping("/read/{id}")
    public Ticket read(@PathVariable String id){
        return ticketService.read(id);
    }

    @PutMapping("/update")
    public Ticket update(@RequestBody Ticket ticket){
        return ticketService.update(ticket);
    }

    @GetMapping("/all")
    public Set<Ticket> getAll(){return ticketService.getAll();}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return ticketService.delete(id);

    }

    //Business Logic
    @PostMapping("/closeTicket/{tickId}")
    public boolean closeTicket(@PathVariable String tickId){
        return ticketService.closeTicket(tickId);
    }

    @GetMapping("/openTickets")
    public Set<Ticket> getAllOpen(){
        return  ticketService.getAllOpen();
    }

}
