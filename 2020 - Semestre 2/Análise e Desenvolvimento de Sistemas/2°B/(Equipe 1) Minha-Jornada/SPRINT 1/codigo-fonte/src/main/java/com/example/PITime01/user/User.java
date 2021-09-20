package com.example.PITime01.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "springproject")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Profile profile;

    public UserDTO toUserDTO() {
        return new UserDTO(this.id, this.name, this.profile);
    }
}