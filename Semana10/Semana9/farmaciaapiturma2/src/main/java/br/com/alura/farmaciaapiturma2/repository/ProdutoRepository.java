package br.com.alura.farmaciaapiturma2.repository;

import br.com.alura.farmaciaapiturma2.dto.DadosAtualizacaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoRepository, Integer> {
    void atualizar(DadosAtualizacaoDTO produtoDTO);
}
