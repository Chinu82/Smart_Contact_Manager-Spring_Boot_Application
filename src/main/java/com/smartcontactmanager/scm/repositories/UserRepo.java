package com.smartcontactmanager.scm.repositories;


import com.smartcontactmanager.scm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//used for db interactions
@Repository
public interface UserRepo extends JpaRepository<User,String> {
    //extra methods related db operations
    //custom query methods

    //custom finder methods
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
