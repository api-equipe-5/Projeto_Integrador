package com.fatec.team1.TeachingPlatform.domain;

import com.fatec.team1.TeachingPlatform.application.config.JwtResponse;
import com.fatec.team1.TeachingPlatform.application.dto.UserAccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthentication{
    private UserAccount userAccount;
    private JwtResponse jwtResponse;
}
