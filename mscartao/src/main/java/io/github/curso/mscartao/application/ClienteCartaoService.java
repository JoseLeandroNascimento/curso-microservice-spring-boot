package io.github.curso.mscartao.application;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.curso.mscartao.domain.ClienteCartao;
import io.github.curso.mscartao.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    
    private final ClienteCartaoRepository repo;

    public List<ClienteCartao> listCartaoByCpf(String cpf){

        return repo.findByCpf(cpf);
    }
}
