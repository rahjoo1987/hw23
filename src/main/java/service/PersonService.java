package service;

import base.service.BaseEntityService;
import command.PersonCommand;
import domain.Person;

public interface PersonService extends BaseEntityService<Person> {
    Person getByUsername(String username);
    PersonCommand personSignup(PersonCommand c);
    Boolean checkPassword(String pass);
}
