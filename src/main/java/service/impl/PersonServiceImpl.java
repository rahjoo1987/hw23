package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import command.PersonCommand;
import domain.Person;
import repository.PersonRepository;
import service.PersonService;

public class PersonServiceImpl extends BaseEntityServiceImpl<Person, PersonRepository>implements PersonService {
    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    public Person getByUsername(String username) {
        return repository.getByUsername(username);
    }

    @Override
    public PersonCommand personSignup(PersonCommand c) {
        return repository.personSignup(c);
    }

    @Override
    public Boolean checkPassword(String pass) {
        return true;
    }
}
