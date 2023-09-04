package com.example.services

import com.example.models.Article
import com.example.repository.IArticleRepository
import io.ktor.server.plugins.*

class ArticleServiceImpl(private val articleRepo:IArticleRepository) : IArticleService {


    /**
     *
     */
    @Throws(NotFoundException::class)
    override suspend fun getAll(): List<Article>? {
        val articles : List<Article>? = articleRepo.get()
        if (!articles.isNullOrEmpty()) {
            return articles;
        }
        throw NotFoundException()
    }
}