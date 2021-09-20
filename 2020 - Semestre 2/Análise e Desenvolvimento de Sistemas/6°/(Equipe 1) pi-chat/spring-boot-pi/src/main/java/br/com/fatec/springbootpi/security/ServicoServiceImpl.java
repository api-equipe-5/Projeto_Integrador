// package br.com.fatec.springbootpi.security;

// import java.util.Date;

// import javax.transaction.Transactional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import br.com.fatec.springbootpi.entity.TipoUsuario;
// import br.com.fatec.springbootpi.entity.Usuario;
// import br.com.fatec.springbootpi.repository.TipoUsuarioRepository;
// import br.com.fatec.springbootpi.repository.UsuarioRepository;

// @Service("servioService")
// public class ServicoServiceImpl implements ServicoService{
    
//     @Autowired
//     private UsuarioRepository userRepo;

//     @Autowired
//     private TipoUsuarioRepository tipoUserRepo;
    
//     // @Override
//     // @Transactional
//     // public Usuario criarUsuario(String nomeUsuario, String cpfUsuario, String tipoUsuario, Date dataCriado) {
//     //     Usuario usuario = new Usuario();
        
//     //     TipoUsuario tipoUser = tipoUserRepo.findByNome(tipoUsuario);
                
//     //     if(tipoUser == null){
//     //         tipoUser = new TipoUsuario();
            
//     //         tipoUser.setNome(tipoUsuario);

//     //         tipoUserRepo.save(tipoUser);
//     //     }

//     //     usuario.setNomeUsuario(nomeUsuario);
//     //     usuario.setCpfUsuario(cpfUsuario);
//     //     usuario.setDataCriado(dataCriado);
//     //     usuario.setTiposUsuarios(tipoUser);
    
//     //     userRepo.save(usuario);

//     //     return usuario;
//     // }
// /*
//     @Override
//     public TipoUsuario criarTipoUsuario(String nomeTipoUsuario) {
//         TipoUsuario tipoUsuario = new TipoUsuario();
//         tipoUsuario.setNome(nomeTipoUsuario);

//         // Validação
//         if (tipoUsuario == null){
//             System.out.println("TipoUsuario já existente!");
//         }
    
//         tipoUserRepo.save(tipoUsuario);

//         return tipoUsuario;
//     }*/
// }