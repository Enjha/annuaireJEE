package mybootapp.dao;

import mybootapp.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByEmailLike(String name);
	Person findPersonByEmailLike(String name);
	List<Person> findByFirstNameLike(String name);
	List<Person> findByLastNameLike(String name);
	List<Person> findAll(Sort sort);
}