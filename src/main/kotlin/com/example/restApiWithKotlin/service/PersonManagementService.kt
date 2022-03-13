package com.example.restApiWithKotlin.service

import com.example.restApiWithKotlin.dto.AddPersonRequest
import com.example.restApiWithKotlin.dto.PersonResponse
import com.example.restApiWithKotlin.dto.UpdatePersonRequest

interface PersonManagementService {
    fun findById(id:Long): PersonResponse?
    fun findAll(): List<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long)
}