package br.com.alura.kotlin.spring.resource

import br.com.alura.kotlin.spring.domain.TopicoRequestDto
import org.springframework.cache.annotation.CacheEvict
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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

}