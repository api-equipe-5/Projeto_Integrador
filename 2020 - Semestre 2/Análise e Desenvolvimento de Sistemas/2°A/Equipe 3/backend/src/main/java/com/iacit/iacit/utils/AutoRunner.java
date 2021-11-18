package com.iacit.iacit.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.iacit.iacit.models.Roles;
import com.iacit.iacit.models.Users;
import com.iacit.iacit.repository.RoleRepository;
import com.iacit.iacit.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class AutoRunner implements CommandLineRunner{
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository uRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Roles> roles = roleRepository.findAll();

        if(roles.size()<=0){

            Roles roleAdm = new Roles();
            roleAdm.setId((long) 1);
            roleAdm.setName("ROLE_ADM");
            roleRepository.save(roleAdm);

            Roles roleFin = new Roles();
            roleFin.setId((long) 2);
            roleFin.setName("ROLE_FINANCEIRO");
            roleRepository.save(roleFin);

            Roles roleGer = new Roles();
            roleGer.setId((long) 3);
            roleGer.setName("ROLE_GERENTE");
            roleRepository.save(roleGer);

            Roles roleMot = new Roles();
            roleMot.setId((long) 4);
            roleMot.setName("ROLE_MOTORISTA");
            roleRepository.save(roleMot);
        }

        Optional<Users> user_adm = uRepository.findById("1");

        if(user_adm.isEmpty()) {
            Users adm = new Users();
            adm.setMatricula("1");
            adm.setLogin("admin");
            adm.setSenha("admin");
            adm.setNome("ADM");

            Roles role = new Roles();
            role.setId((long)1);

            Set<Roles> rls = new HashSet<>();
            rls.add(role);

            adm.setRoles(rls);

            uRepository.save(adm);
        }

        Optional<Users> user_fin = uRepository.findById("2");

        if(user_fin.isEmpty()) {
            Users fin = new Users();
            fin.setMatricula("2");
            fin.setLogin("finan");
            fin.setSenha("finan");
            fin.setNome("FINANCEIRO");

            Roles role = new Roles();
            role.setId((long)2);

            Set<Roles> rls = new HashSet<>();
            rls.add(role);

            fin.setRoles(rls);

            uRepository.save(fin);
        }

        Optional<Users> user_ger = uRepository.findById("3");

        if(user_ger.isEmpty()) {
            Users ger = new Users();
            ger.setMatricula("3");
            ger.setLogin("gerente");
            ger.setSenha("gerente");
            ger.setNome("GERENTE");

            Roles role = new Roles();
            role.setId((long)3);

            Set<Roles> rls = new HashSet<>();
            rls.add(role);

            ger.setRoles(rls);

            uRepository.save(ger);
        }

    }
}
