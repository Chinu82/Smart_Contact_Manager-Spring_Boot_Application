package com.smartcontactmanager.scm.services;

import com.smartcontactmanager.scm.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> getuserById(String id); //if exist then retrieve else error

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExistingById(String id);

    boolean isUserExistingByEmail(String email);

    List<User> getAllUsers();

//    add more methods here related user service[logic]
}
