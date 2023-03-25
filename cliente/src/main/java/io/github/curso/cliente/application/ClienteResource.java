package io.github.curso.cliente.application;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.curso.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteResource {
    
    private final ClienteService service;

    @GetMapping("")
    public String status(){

        log.info("Obtendo o status do microservices de clientes");
        
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        
        var cliente = request.toModel();

        service.save(cliente);
        
        URI headerLocation = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .query("cpf={cpf}")
                            .buildAndExpand(cliente.getCpf())
                            .toUri();

        return ResponseEntity.created(headerLocation).build();
    }


    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){

        var cliente = service.getByCPF(cpf);

        if(cliente.isEmpty()){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }
}
