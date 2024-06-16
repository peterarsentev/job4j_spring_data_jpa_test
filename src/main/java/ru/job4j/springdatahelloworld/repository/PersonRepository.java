package ru.job4j.springdatahelloworld.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.springdatahelloworld.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
