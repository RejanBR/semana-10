package br.com.alura.farmaciaapiturma2.controller;

import br.com.alura.farmaciaapiturma2.dto.DadosAtualizacaoDTO;
import br.com.alura.farmaciaapiturma2.dto.DadosRetornoDTO;
import br.com.alura.farmaciaapiturma2.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping("/produtos") // Added a base path for the controller
public class ProdutoController {

    private final ProdutoRepository produtoRepository; // Assuming you have a repository class

    // Constructor injection for the repository
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping // Removed unnecessary generic types, fixed method signature
    public ResponseEntity<Page<Object>> listar(@PageableDefault(size = 2, sort = "nome") Pageable pageable) {
        var produtosPage = produtoRepository.findAll(pageable)
                .map(DadosRetornoDTO::new); // Mapping each product to DadosRetornoDTO
        return (ResponseEntity<Page<Object>>) ResponseEntity.ok();
    }

    @PutMapping("/{id}") // Added id parameter to path
    @Transactional
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody DadosAtualizacaoDTO produtoDTO) {
        var optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            var produto = optionalProduto.get();
            produto.atualizar(produtoDTO); // Assuming you have an update method in your entity
            return ResponseEntity.noContent().build();
        } else {
            ResponseEntity<Void> build = null;
            return build;
        }
    }

}