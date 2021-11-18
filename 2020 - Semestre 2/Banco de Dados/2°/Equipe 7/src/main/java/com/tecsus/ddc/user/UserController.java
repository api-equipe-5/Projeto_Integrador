package com.tecsus.ddc.user;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public User find(String login, String password) {
        User tmpUser = User.builder()
                .login(login)
                .password(password)
                .build();
        Optional<User> user = userRepository.find(tmpUser);
        if (user.isPresent()) {
            List<Role> roles = roleRepository.findAll(user.get().getLogin());
            user.get().setRoles(roles);
            return user.get();
        }
        System.out.println("Usuário não encontrado");
        return null;
    }
}
