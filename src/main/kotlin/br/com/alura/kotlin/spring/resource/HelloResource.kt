package br.com.alura.kotlin.spring.resource

import br.com.alura.kotlin.spring.domain.TopicoRequestDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloResource {

    @GetMapping(value = ["/"])
    fun hello(): String {
        return "Hello World"
    }

}