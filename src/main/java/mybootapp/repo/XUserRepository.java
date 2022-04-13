package mybootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mybootapp.model.XUser;

public interface XUserRepository extends JpaRepository<XUser, String> {

}