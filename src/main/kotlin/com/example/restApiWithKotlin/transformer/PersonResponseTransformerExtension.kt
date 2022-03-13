package com.example.restApiWithKotlin.transformer

import com.example.restApiWithKotlin.domain.Person
import com.example.restApiWithKotlin.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = this?.id ?: 1L,
        fullname = "${this?.lastName}, ${this?.name}"
    )
}