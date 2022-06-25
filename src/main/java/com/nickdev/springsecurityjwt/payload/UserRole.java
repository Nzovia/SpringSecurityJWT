package com.nickdev.springsecurityjwt.payload;
import lombok.Data;

@Data
public class UserRole {
    private  String userEmail;
    private  String roleName;
}
