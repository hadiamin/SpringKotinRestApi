package com.example.restApiWithKotlin.service

import com.example.restApiWithKotlin.dto.AddPersonRequest
import com.example.restApiWithKotlin.dto.PersonResponse
import com.example.restApiWithKotlin.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PersonManagementService {
    fun findById(id:Long): PersonResponse?
    fun findAll(pageable: Pageable): Page<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long)
}