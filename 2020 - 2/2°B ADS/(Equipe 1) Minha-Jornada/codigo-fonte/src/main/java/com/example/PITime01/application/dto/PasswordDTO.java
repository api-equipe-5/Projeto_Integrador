package com.example.PITime01.application.dto;

import lombok.Data;

@Data
public class PasswordDTO {

    String currentPassword;
    String newPassword;
    String confirmPassword;
}
