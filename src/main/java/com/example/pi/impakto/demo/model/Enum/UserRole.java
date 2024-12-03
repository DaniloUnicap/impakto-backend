package com.example.pi.impakto.demo.model.Enum;

public enum UserRole {
    ADMIN("admin");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
