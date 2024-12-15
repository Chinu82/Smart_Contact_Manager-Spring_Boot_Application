package com.smartcontactmanager.scm.services;

import com.smartcontactmanager.scm.entities.User;
import com.smartcontactmanager.scm.helipers.ResourceNotFoundException;
import com.smartcontactmanager.scm.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserService{

    //for saving
    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {

        //user id generate
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        //password encode
        //user.setPassword(userId);


        return userRepo.save(user);
    }

    @Override
    public Optional<User> getuserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user1 = userRepo
                .findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));

        //updating
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePic(user.getProfilePic());
        user1.setEnabled(user.getEnabled());
        user1.setEmailVerified(user.isEmailVerified());
        user1.setPhoneVerified(user.isPhoneVerified());
        user1.setProvider(user.getProvider());
        user1.setProviderUserId(user.getProviderUserId());

        //save the user in database
        User save = userRepo.save(user1);

        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user1 = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        userRepo.delete(user1);
    }

    @Override
    public boolean isUserExistingById(String id) {
        User user1 = userRepo.findById(id).orElse(null);

        return user1 != null ? true:false;
    }

    @Override
    public boolean isUserExistingByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null?true:false;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
