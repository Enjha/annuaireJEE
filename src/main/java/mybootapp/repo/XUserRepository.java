package mybootapp.repo;

import mybootapp.model.Person;
import mybootapp.model.XUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface XUserRepository extends JpaRepository<XUser, String> {
    XUser findByUserNameLike(String name);
}