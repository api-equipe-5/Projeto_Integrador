package com.fatec.team1.TeachingPlatform.application.dto;

import com.fatec.team1.TeachingPlatform.domain.AccountRole;
import com.fatec.team1.TeachingPlatform.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class ProfileDTO is used to publicly expose data stored in the database
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDTO {
    private long id;
    private String name;
    private String email;
    private AccountRole role;

    public UserAccountDTO(UserAccount userAccount) {
        this.id = userAccount.getId();
        this.name = userAccount.getName();
        this.email = userAccount.getEmail();
        this.role = userAccount.getRole();
    }

}
