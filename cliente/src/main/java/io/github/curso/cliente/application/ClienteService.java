package io.github.curso.cliente.application;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.curso.cliente.domain.Cliente;
import io.github.curso.cliente.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    
    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){

        return repository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){

        return repository.findByCpf(cpf);
    }


}
