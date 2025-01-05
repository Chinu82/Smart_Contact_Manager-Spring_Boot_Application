package com.smartcontactmanager.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")  //if we want to change the name of table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String userId;  //primary key

    @Column(name = "user_name",nullable = false)
    private String name;    //name -> user_name (column name)

    @Column(unique = true, nullable = false)    //notnull and unique
    private String email;

    private String password;
    
    @Column(length = 1000)  //contains 1000 of chars
    private String about;

    @Column(length = 1000)
    private String profilePic;

    private String phoneNumber;

    //information
    private Boolean enabled=false;
    private boolean emailVerified = false;  //by default false
    private boolean phoneVerified = false;
    private boolean twiterVerified = false;
    private boolean facebookVerified = false;

    //self, google, facebook, github, linkedin
    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String providerUserId;
    
    //add more if needed
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true) //cascade means user update means all updated
    private List <Contact> contacts = new ArrayList<>();
}