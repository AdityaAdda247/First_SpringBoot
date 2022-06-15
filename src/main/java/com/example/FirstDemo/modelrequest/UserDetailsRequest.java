package com.example.FirstDemo.modelrequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {
    @NotNull(message = "First name cannot be null")
    private String firstname;
    @NotNull(message = "Last name cannot be null")
    private String lastname;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Enter valid email")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min=8,max=16,message = "Password must be equal or grater than 8 characters ans lass than 16 characters")
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
