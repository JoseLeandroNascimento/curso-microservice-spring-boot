package io.github.curso.mscartao.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.curso.mscartao.domain.Cartao;
import io.github.curso.mscartao.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repo;

    @Transactional
    public Cartao save(Cartao cartao){

        return repo.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenor(Long renda){
        
        var rendaBigDecima = BigDecimal.valueOf(renda);

        return repo.findByRendaLessThanEqual(rendaBigDecima);
        
    }
}
