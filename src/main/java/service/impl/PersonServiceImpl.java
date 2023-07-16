package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Person;
import repository.PersonRepository;
import service.PersonService;

public class PersonServiceImpl extends BaseEntityServiceImpl<Person, PersonRepository>implements PersonService {
    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }
}
