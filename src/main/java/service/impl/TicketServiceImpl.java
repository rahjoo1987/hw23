package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;

public class TicketServiceImpl extends BaseEntityServiceImpl<Ticket, TicketRepository>implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}
