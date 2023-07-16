package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Person;
import repository.PermissionRepository;
import repository.PersonRepository;

import javax.persistence.EntityManager;

public class PersonRepositoryImpl extends BaseEntityRepositoryImpl<Person>implements PersonRepository {
    public PersonRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
}
