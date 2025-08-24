package com.produtosapi.produtosapi.controller;

import com.produtosapi.produtosapi.model.Produto;
import com.produtosapi.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class produtoController {

    private ProdutoRepository produtoRepository;

    public produtoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido:" + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return  produto;
    }


}
