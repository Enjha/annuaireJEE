package mybootapp.repo;

import mybootapp.model.XUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface XUserRepository extends JpaRepository<XUser, String> {
    XUser findByUserNameLike(String name);
}