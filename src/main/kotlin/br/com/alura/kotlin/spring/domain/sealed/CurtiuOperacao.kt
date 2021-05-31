package br.com.alura.kotlin.spring.domain.sealed

import com.fasterxml.jackson.annotation.JsonCreator

sealed class CurtiuOperacao {

    private companion object {
        @JvmStatic
        @JsonCreator
        fun procuraAtributo(simpleName: String): CurtiuOperacao? {
            return CurtiuOperacao::class.sealedSubclasses.first {
                it.simpleName == simpleName
            }.objectInstance
        }
    }

    object Curtiu: CurtiuOperacao()
    object NaoCurtiu: CurtiuOperacao()
}
