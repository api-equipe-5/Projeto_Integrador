package com.iacit.iacit;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.iacit.iacit.models.Roles;
import com.iacit.iacit.models.Status;
import com.iacit.iacit.models.Users;
import com.iacit.iacit.repository.RoleRepository;
import com.iacit.iacit.repository.StatusRepository;
import com.iacit.iacit.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IacitApplication implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

	public static void main(String[] args) {
        logger.info("Starting API");
		SpringApplication.run(IacitApplication.class, args);
        logger.info("API is running");
    }

	@Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository uRepository;

    @Autowired
    StatusRepository rRepository;

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
        
        List<Status> currentStatus = rRepository.findAll();
        if(currentStatus.size()<=0){
            Status notInit = new Status();
            notInit.setId((long)1);
            notInit.setStatus("JORNADA NAO INICIADA");
            rRepository.save(notInit);

            Status pausa = new Status();
            pausa.setId((long)2);
            pausa.setStatus("DESCANSO");
            rRepository.save(pausa);

            Status almoco = new Status();
            almoco.setId((long)3);
            almoco.setStatus("ALMOCO");
            rRepository.save(almoco);

            Status entregue = new Status();
            entregue.setId((long)4);
            entregue.setStatus("ENTREGUE");
            rRepository.save(entregue);

            Status cancelada = new Status();
            cancelada.setId((long)5);
            cancelada.setStatus("CANCELADA");
            rRepository.save(cancelada);

            Status caminho = new Status();
            caminho.setId((long)6);
            caminho.setStatus("A CAMINHO");
            rRepository.save(cancelada);

            Status atrasado = new Status();
            atrasado.setId((long)7);
            atrasado.setStatus("ATRASADO");
            rRepository.save(atrasado);

            Status andamento = new Status();
            andamento.setId((long)8);
            andamento.setStatus("EM ANDAMENTO");
            rRepository.save(andamento);
        }
	}

}


