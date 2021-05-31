package br.com.alura.kotlin.spring.resource

import br.com.alura.kotlin.spring.domain.dto.TopicoDetalhamentoDto
import br.com.alura.kotlin.spring.domain.dto.TopicoRequestDto
import br.com.alura.kotlin.spring.domain.enumerable.StatusTopicoEnum
import br.com.alura.kotlin.spring.domain.sealed.CurtiuOperacao
import org.springframework.cache.annotation.CacheEvict
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping(value = ["topicos"])
class TopicoResource {

    private var totalGostou = 0;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun cadastra(@RequestBody @Valid request: TopicoRequestDto): TopicoDetalhamentoDto {
        totalGostou = calcular(totalGostou, request.avaliacao)

        return TopicoDetalhamentoDto(
            titulo = "Alura",
            dataCriacao = LocalDateTime.now(),
            nomeAutor = "Kleber",
            mensagem = "Esse é topico da Alura",
            status = StatusTopicoEnum.NAO_RESPONDIDO,
            gostei = totalGostou,
            id = null
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/"])
    fun detalhar(): TopicoDetalhamentoDto {
        return TopicoDetalhamentoDto(
            titulo = "Alura",
            dataCriacao = LocalDateTime.now(),
            nomeAutor = "Kleber",
            mensagem = "Esse é topico da Alura",
            status = StatusTopicoEnum.NAO_RESPONDIDO,
            gostei = totalGostou,
            id = null
        )
    }

    private fun calcular(total: Int, operacao: CurtiuOperacao) : Int = when(operacao) {
        is CurtiuOperacao.Curtiu -> total + 1
        is CurtiuOperacao.NaoCurtiu -> total - 1
    }

}