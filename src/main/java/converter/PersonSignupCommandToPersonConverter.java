package converter;

import command.PersonCommand;
import domain.Person;

public class PersonSignupCommandToPersonConverter implements BaseConverter <PersonCommand, Person>{

    @Override
    public Person convert(PersonCommand personCommand) {
        Person person = new Person();
        person.setUserName(personCommand.getUserName());
        person.setPassword(personCommand.getPassword());
        person.setFirstName(personCommand.getFirstName());
        person.setLastName(personCommand.getLastName());
        person.setMobileNumber(personCommand.getMobileNumber());
        person.setNationalCode(personCommand.getNationalCode());
        return person;
    }
}
