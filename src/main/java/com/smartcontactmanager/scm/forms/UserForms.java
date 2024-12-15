package com.smartcontactmanager.scm.forms;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserForms {
    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;
}
