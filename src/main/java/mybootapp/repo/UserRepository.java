package mybootapp.repo;

import mybootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameLike(String name);
}