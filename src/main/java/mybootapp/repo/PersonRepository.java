package mybootapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mybootapp.model.Group;
import mybootapp.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByEmailLike(String name);
	List<Person> findByFirstNameLike(String name);
	List<Person> findByLastNameLike(String name);
}