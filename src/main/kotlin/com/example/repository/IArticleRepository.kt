package com.example.repository

import com.example.models.Article

interface IArticleRepository {
    /**
     *
     */
    suspend fun get(): List<Article>

    /**
     *
     */
    suspend fun getById(id: Int): Article?

    /**
     *
     */
    suspend fun add(title: String, body: String): Article?
    suspend fun update(id: Int, title: String, body: String): Boolean
    suspend fun delete(id: Int): Boolean
}