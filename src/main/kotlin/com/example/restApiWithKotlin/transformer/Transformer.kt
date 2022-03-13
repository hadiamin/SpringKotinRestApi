package com.example.restApiWithKotlin.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}