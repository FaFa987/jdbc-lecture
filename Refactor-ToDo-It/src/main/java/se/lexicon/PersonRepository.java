package se.lexicon;


import se.lexicon.models.Person;

import java.util.List;

public interface PersonRepository{
    Person findById(int id);
    List<Person> findAll();
    Person save(Person person);
    void deleteById(int id);
}
