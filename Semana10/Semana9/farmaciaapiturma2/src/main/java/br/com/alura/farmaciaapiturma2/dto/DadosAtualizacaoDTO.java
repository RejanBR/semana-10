package br.com.alura.farmaciaapiturma2.dto;

import org.jetbrains.annotations.NotNull;

public record DadosAtualizacaoDTO (
    @NotNull
    int id,
    String descricaoProduto,
    double precoProduto) {


}
