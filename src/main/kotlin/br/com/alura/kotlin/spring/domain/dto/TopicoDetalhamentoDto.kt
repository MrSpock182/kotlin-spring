package br.com.alura.kotlin.spring.domain.dto

import br.com.alura.kotlin.spring.domain.enumerable.StatusTopicoEnum
import java.time.LocalDateTime

data class TopicoDetalhamentoDto(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val nomeAutor: String,
    val status: StatusTopicoEnum
)
