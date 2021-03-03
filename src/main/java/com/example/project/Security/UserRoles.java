package com.example.project.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRoles {
    STUDENT(Sets.newHashSet(UserPermission.STUDENT_READ,UserPermission.STUDENT_WRITE)),
    TEACHER(Sets.newHashSet(UserPermission.TEACHER_READ,UserPermission.TEACHER_WRITE));
    private final Set<UserPermission> permissions;
    UserRoles(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthority()
    {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+ this.name())); //This refers to the enum name
        return permissions;
    }

}
