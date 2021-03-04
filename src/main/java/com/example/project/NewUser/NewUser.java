package com.example.project.NewUser;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewUser {
    @NotBlank(message = "Name cannot be null")
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 20, message = "name must be bigger than 3 characters and must be less than 20")
    private String name;
    @NotNull(message = "value must be filled in")
    @NotBlank(message = "must not be blank")
    @Size(min = 4, max=12, message="username must be ")
    private String username;
    @NotBlank(message = "password may not be empty")
    @NotNull(message = "Password may not be empty")
    private String password;
    private boolean isTeacher;

    public NewUser() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }


}
