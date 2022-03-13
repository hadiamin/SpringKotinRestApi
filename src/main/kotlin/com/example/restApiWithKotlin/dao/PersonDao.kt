package com.example.restApiWithKotlin.dao

import com.example.restApiWithKotlin.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: JpaRepository<Person, Long>