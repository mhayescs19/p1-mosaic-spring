package com.example.project.NewUser;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User that represents a new user from the create user page.
 * This Is a DTO
 */
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
    @Size(min = 13, max = 20,message = "Age must be between 13 and 20")
    private int age;
    @NotBlank(message = "Field must be filled in")
    @NotNull(message = "Field must be filled in")
    private String year;
    private final String Role;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return Role;
    }

    public NewUser() {
        this.Role = "STUDENT";
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
    @Override
    public String toString() {
        return "NewUser{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Age=" + age +
                ", year='" + year + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
