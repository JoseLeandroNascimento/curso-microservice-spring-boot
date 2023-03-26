package io.github.curso.mscartao.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.curso.mscartao.domain.Cartao;
import io.github.curso.mscartao.domain.ClienteCartao;
import io.github.curso.mscartao.representation.CartaoSaveRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartaoResource {
    
    private final CartaoService service;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){

        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request){

        Cartao cartao = request.toModel();

        service.save(cartao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda) {
        
        List<Cartao> list = service.getCartoesRendaMenor(renda);

        return ResponseEntity.ok(list);
    }

    // @GetMapping(params = "cpf")
    // public ResponseEntity<List<CartoesPorClientResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        
    //     List<ClienteCartao> list = clienteCartaoService.listCartaoByCpf(cpf);

    //     List<CartoesPorClientResponse> resultsList = list.stream()
    //         .map(CartoesPorClientResponse::fromModel)
    //         .collect(Collectors.toList());

    //     return ResponseEntity.ok(resultsList);
    // }
}
