package io.github.curso.mscartao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.curso.mscartao.domain.ClienteCartao;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao,Long> {
    
    List<ClienteCartao> findByCpf(String cpf);
}
