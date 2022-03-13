package com.example.restApiWithKotlin.dto

data class AddPersonRequest(val name:String, val lastName:String? = null)