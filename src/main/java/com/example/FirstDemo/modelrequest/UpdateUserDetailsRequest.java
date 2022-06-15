package com.example.FirstDemo.modelrequest;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequest {
    @NotNull(message = "First name cannot be null")
    private String firstname;
    @NotNull(message = "Last name cannot be null")
    private String lastname;

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
}
