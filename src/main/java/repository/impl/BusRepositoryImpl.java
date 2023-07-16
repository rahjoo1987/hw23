package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Bus;
import repository.BusRepository;

import javax.persistence.EntityManager;

public class BusRepositoryImpl extends BaseEntityRepositoryImpl<Bus>implements BusRepository {
    public BusRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Bus> getEntityClass() {
        return Bus.class;
    }
}
