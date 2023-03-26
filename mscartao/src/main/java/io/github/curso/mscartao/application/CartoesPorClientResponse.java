package io.github.curso.mscartao.application;

import java.math.BigDecimal;

import io.github.curso.mscartao.domain.BandeiraCartao;
import io.github.curso.mscartao.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartoesPorClientResponse {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;


    public static CartoesPorClientResponse fromModel(ClienteCartao model){

        return new CartoesPorClientResponse(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getCartao().getLimit()
             );
    }
}

