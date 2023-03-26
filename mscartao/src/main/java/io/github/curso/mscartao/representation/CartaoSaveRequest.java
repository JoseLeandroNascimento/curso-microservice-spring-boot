package io.github.curso.mscartao.representation;

import java.math.BigDecimal;

import io.github.curso.mscartao.domain.BandeiraCartao;
import io.github.curso.mscartao.domain.Cartao;
import lombok.Data;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){

        return new Cartao(nome,bandeira,renda,limite);
    }
}
