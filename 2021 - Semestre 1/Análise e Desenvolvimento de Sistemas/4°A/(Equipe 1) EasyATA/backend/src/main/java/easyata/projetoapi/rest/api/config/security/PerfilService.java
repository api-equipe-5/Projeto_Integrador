package easyata.projetoapi.rest.api.config.security;

import easyata.projetoapi.rest.api.model.Perfil;
import easyata.projetoapi.rest.api.repository.PerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository){
        this.perfilRepository = perfilRepository;
    }

    public Perfil save(Perfil perfil){
        return this.perfilRepository.save(perfil);
    }
}
