package repository;

import base.repository.BaseEntityRepository;
import command.PersonCommand;
import domain.Person;

public interface PersonRepository extends BaseEntityRepository<Person> {
    Person getByUsername(String username);
    PersonCommand personSignup(PersonCommand c);
}
