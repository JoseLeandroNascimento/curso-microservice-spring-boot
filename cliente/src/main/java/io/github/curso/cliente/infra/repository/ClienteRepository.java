package io.github.curso.cliente.infra.repository;

import io.github.curso.cliente.domain.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
 
    Optional<Cliente> findByCpf(String cpf);
}
