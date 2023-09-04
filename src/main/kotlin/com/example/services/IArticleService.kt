package com.example.services

import com.example.models.Article

interface IArticleService {
    suspend fun getAll(): List<Article>?
}