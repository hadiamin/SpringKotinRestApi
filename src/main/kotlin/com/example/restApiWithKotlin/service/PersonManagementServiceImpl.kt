package com.example.restApiWithKotlin.service

import com.example.restApiWithKotlin.dao.PersonDao
import com.example.restApiWithKotlin.domain.Person
import com.example.restApiWithKotlin.dto.AddPersonRequest
import com.example.restApiWithKotlin.dto.PersonResponse
import com.example.restApiWithKotlin.dto.UpdatePersonRequest
import com.example.restApiWithKotlin.transformer.AddPersonRequestTransformer
import com.example.restApiWithKotlin.transformer.toPersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(private val personDao: PersonDao,
                                  private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()

    override fun findAll(pageable: Pageable): Page<PersonResponse> = this.personDao.findAll(pageable).map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse = this.saveOrUpdate(addPersonRequestTransformer.transform(addPersonRequest))

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")
        return this.saveOrUpdate(person.apply {
            name = updatePersonRequest.name
            lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}