package com.example.project.Security;

public enum UserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    TEACHER_READ("teacher:read"),
    TEACHER_WRITE("teacher:write");
    private final String permission;
    UserPermission(String perms)
    {
        this.permission = perms;
    }

    public String getPermission() {
        return permission;
    }
}
