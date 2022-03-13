package com.example.restApiWithKotlin.transformer

import com.example.restApiWithKotlin.domain.Person
import com.example.restApiWithKotlin.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer : Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(name = source.name, lastName = source.lastName)
    }
}