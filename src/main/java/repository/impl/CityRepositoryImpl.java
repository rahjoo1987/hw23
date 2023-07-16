package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.City;
import repository.CityRepository;

import javax.persistence.EntityManager;

public class CityRepositoryImpl extends BaseEntityRepositoryImpl<City>implements CityRepository {
    public CityRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
