package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
}
