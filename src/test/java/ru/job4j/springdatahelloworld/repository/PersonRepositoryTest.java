package ru.job4j.springdatahelloworld.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.job4j.springdatahelloworld.model.Person;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        personRepository.deleteAll();
    }

    @Test
    public void whenSavePerson_thenFindById() {
        var person = new Person();
        person.setName("John Doe");
        person.setEmail("john.doe@example.com");
        personRepository.save(person);
        var foundPerson = personRepository.findById(person.getId());
        assertThat(foundPerson).isPresent();
        assertThat(foundPerson.get().getName()).isEqualTo("John Doe");
    }

    @Test
    public void whenFindAll_thenReturnAllPersons() {
        var person1 = new Person();
        person1.setName("John Doe");
        person1.setEmail("john.doe@example.com");
        var person2 = new Person();
        person2.setName("Jane Doe");
        person2.setEmail("jane.doe@example.com");
        personRepository.save(person1);
        personRepository.save(person2);
        var persons = personRepository.findAll();
        assertThat(persons).hasSize(2);
        assertThat(persons).extracting(Person::getName).contains("John Doe", "Jane Doe");
    }
}