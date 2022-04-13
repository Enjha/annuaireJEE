package mybootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mybootapp.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
	List<Group> findByName(String name);
	List<Group> findByNameLike(String name);
}