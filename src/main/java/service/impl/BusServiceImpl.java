package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Bus;
import repository.BusRepository;
import service.BusService;

public class BusServiceImpl extends BaseEntityServiceImpl<Bus, BusRepository>implements BusService {
    public BusServiceImpl(BusRepository repository) {
        super(repository);
    }
}
