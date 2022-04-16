package mybootapp.repo;

import mybootapp.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findAll(Sort sort);
}