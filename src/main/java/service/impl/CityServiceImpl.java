package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.City;
import repository.CityRepository;
import service.CityService;

public class CityServiceImpl extends BaseEntityServiceImpl<City, CityRepository>implements CityService {
    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }
}
