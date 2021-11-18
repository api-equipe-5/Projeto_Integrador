package br.gov.sp.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;
import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.entity.Conversa;
import br.gov.sp.fatec.springbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;
import br.gov.sp.fatec.springbootapp.service.SegurancaService;



@SpringBootTest //inicia a aplicacao
//sem nenhuma gravacao usamos transactional e rollback
@Transactional //cada metodo tem uma conexao aberta alem da transacao
@Rollback
class SpringBootAppApplicationTests {
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private AutorizacaoRepository autRepo; 

    @Autowired
    private SegurancaService segService;

    @Test
    void testaInsercao(){
        Usuario usuario = new  Usuario();
        usuario.setNome("Teste234");
        usuario.setSenha("senha");
        usuario.setAvatar("base64 image");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        Autorizacao aut = new Autorizacao();
        aut.setNome("ROLE_USUARIO");
        autRepo.save(aut);
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getAutorizacoes().iterator().next().getId());
    } 
    //autorizacoes devem ser previamente salvas no banco ou referencia alguma existente
    @Test
    void testaInsercaoAutorizacao(){
        Usuario usuario = new  Usuario();
        usuario.setNome("Usuario3");
        usuario.setSenha("senha");
        usuario.setAvatar("base64 image");
        usuarioRepo.save(usuario);
        Autorizacao aut = new Autorizacao();
        aut.setNome("ROLE_USUARIO3");
        aut.setUsuarios(new HashSet<Usuario>());
        aut.getUsuarios().add(usuario);
        autRepo.save(aut); 
        assertNotNull(aut.getUsuarios().iterator().next().getId());
    } 
    
       
    @Test
    void testaAutorizacao(){
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("ROLE_ADMIN", usuario.getAutorizacoes().iterator().next().getNome());


    }
    @Test 
    void testaUsuario(){
        Autorizacao aut = autRepo.findById(1L).get();
        assertEquals("Fabiola", aut.getUsuarios().iterator().next().getNome());
    } 

    @Test 
    void testaBuscaUsuarioNomeContains(){
        List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("A");
        assertFalse(usuarios.isEmpty());
    }
    @Test 
    void testaBuscaUsuarioNome(){
        Usuario usuario = usuarioRepo.findByNome("Fabiola");
        assertNotNull(usuario);
    }
     @Test 
    void testaBuscaUsuarioNomeQuery(){
        Usuario usuario = usuarioRepo.buscaUsuarioPorNome("Fabiola");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaUsuarioNomeSenha(){
        Usuario usuario = usuarioRepo.findByNomeAndSenha("Fabiola", "12345"); 
        assertNotNull(usuario);   
    }
    @Test
    void testaBuscaUsuarioNomeSenhaQuery(){
        Usuario usuario = usuarioRepo.buscaUsuaioPorNomeESenha("Fabiola", "12345"); 
        assertNotNull(usuario);   
    }
    @Test 
    void testaBuscaUsuarioNomeAutorizacao(){
        List<Usuario> usuarios = usuarioRepo.findByAutorizacoesNome("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }
    
    @Test 
    void testaBuscaUsuarioNomeAutorizacaoQuery(){
        List<Usuario> usuarios = usuarioRepo.buscaPorNomeAutorizacao("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }

    // @Test
    // void testaServicoCriaUsuario(){
    //     Usuario usuario = segService.criarUsuario("normal2", "senha123","base64 image", "ROLE_USUARIO");
    //     assertNotNull(usuario);
    // }

}

