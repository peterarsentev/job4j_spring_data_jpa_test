package ru.job4j.springdatahelloworld;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.job4j.springdatahelloworld.model.Person;
import ru.job4j.springdatahelloworld.repository.PersonRepository;

@SpringBootApplication
@AllArgsConstructor
public class SpringDataHelloWorldApp implements CommandLineRunner {

    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataHelloWorldApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personRepository.deleteAll();
        Person person = new Person(0L, "Alex", "email");
        personRepository.save(person);
        System.out.println(person.getId());
        System.out.println(personRepository.findAll().iterator().hasNext());
        System.out.println(personRepository.findAll().iterator().next());
    }
}
