package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Ticket;
import repository.TicketRepository;

import javax.persistence.EntityManager;

public class TicketRepositoryImpl extends BaseEntityRepositoryImpl<Ticket>implements TicketRepository {

    public TicketRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
