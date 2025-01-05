package com.smartcontactmanager.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserForms {

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Min 3 Characters is required")
    private String name;
    
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min=6, message = "Min 6 Characters are required")
    private String password;

    @NotBlank(message = "About is required")
    private String about;
    @NotBlank(message = "Phone number is required")
    @Size(min = 8, max=12, message = "Invalid Number")
    private String phoneNumber;
}
