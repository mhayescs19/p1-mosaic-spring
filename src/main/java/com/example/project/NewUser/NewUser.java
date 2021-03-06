package com.example.project.NewUser;


import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User that represents a new user from the create user page.
 * This Is a DTO
 */
public class NewUser {
    @NotBlank(message = "Name cannot be null")
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 20, message = "name must be bigger than 3 characters and must be less than 20")
    private String name;
    @NotNull(message = "Username must be filled in")
    @NotBlank(message = "Username must not be blank")
    @Size(min = 4, max=12, message="username must be greater then 4 digits long and less than 12 digits")
    private String username;
    @NotBlank(message = "password may not be empty")
    @NotNull(message = "Password may not be empty")
    private String password;
    @NotNull
    @Min(value = 13,message = "Age must be greater than 13 or equal to")
    @Max(value = 20,message = "Age must be less than 20 or equal to")
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
    public Map<String,Object> toMap()
    {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("Name",getName());
        objectMap.put("Year",getYear());
        objectMap.put("Role",getRole());
        objectMap.put("IDNumber",getUsername());
        objectMap.put("Password",getPassword());
        objectMap.put("Age",getAge());
        return objectMap;
    }

}
