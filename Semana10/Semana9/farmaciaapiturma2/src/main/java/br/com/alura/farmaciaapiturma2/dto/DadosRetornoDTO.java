package br.com.alura.farmaciaapiturma2.dto;

import br.com.alura.farmaciaapiturma2.model.Produto;
import br.com.alura.farmaciaapiturma2.repository.ProdutoRepository;

public class DadosRetornoDTO {

    public DadosRetornoDTO(Object nome1, Object descricao, Object preco, Object produtoPreco) {
    }

    public DadosRetornoDTO(Produto produto) {
    }

    public DadosRetornoDTO(ProdutoRepository produtoRepository) {
    }
}
