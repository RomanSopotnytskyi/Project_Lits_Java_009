package com.lits.project.repository;

import com.lits.project.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    //Optional<User> findByUsername(String username);

    //@Query("select u from User u where u.age > ?1")
    //Iterable<User> findByAgeGreaterThan(int ids);
}