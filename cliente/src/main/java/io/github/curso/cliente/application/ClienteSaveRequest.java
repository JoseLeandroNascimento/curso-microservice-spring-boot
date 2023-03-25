package io.github.curso.cliente.application;

import io.github.curso.cliente.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;


    public Cliente toModel(){

        return new Cliente(cpf,nome,idade);
    }
}
