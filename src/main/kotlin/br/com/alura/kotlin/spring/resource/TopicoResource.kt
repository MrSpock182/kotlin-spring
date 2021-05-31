package br.com.alura.kotlin.spring.resource

import br.com.alura.kotlin.spring.domain.dto.TopicoDetalhamentoDto
import br.com.alura.kotlin.spring.domain.dto.TopicoRequestDto
import br.com.alura.kotlin.spring.domain.enumerable.StatusTopicoEnum
import org.springframework.cache.annotation.CacheEvict
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping(value = ["topicos"])
class TopicoResource {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun cadastra(@RequestBody @Valid request: TopicoRequestDto): String {
        return request.mensagem
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
            id = null
        )
    }

}