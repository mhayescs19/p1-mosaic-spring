package com.example.project.Security.Auth;

import java.util.Optional;

public interface UserDao {
    Optional<User> selectUserByUsername(String username);
}
