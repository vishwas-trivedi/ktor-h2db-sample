package com.example.repository

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Article
import com.example.models.Articles
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class ArticleRepositoryImpl : IArticleRepository {

    //<editor-fold desc="Public methods">

    /**
     * Fetch list of all the articles
     */
    override suspend fun get(): List<Article> = dbQuery {
        /*
        Articles.selectAll() returns an instance of Query, so to get the list of Article instances,
        we need to manually extract data for each row and convert it to our data class.
        We accomplish that using the helper function resultRowToArticle that builds an Article from the ResultRow.
        */
        Articles.selectAll().map(::resultRowToArticle)
    }

    /**
     * Fetch specific article
     */
    override suspend fun getById(id: Int): Article? {
        //You can use comparison like eq, less, greater or arithmetic functions like plus, times, etc
        return Articles.select(Articles.id eq id)
            .map(::resultRowToArticle)
            .singleOrNull()
    }

    /**
     *
     */
    override suspend fun add(title: String, body: String): Article? {
        // This would create a nullable resultRow
        val insertStatement = Articles.insert {
            it[Articles.title] = title
            it[Articles.body] = body
        }.resultedValues?.singleOrNull()

        // This
        return insertStatement?.let(::resultRowToArticle)
    }

    /**
     * Used to update th
     */
    override suspend fun update(id: Int, title: String, body: String): Boolean {
        val updateResult = Articles.update({Articles.id eq id}){
            it[Articles.title] = title
            it[Articles.body] = body
        } > 0
        return updateResult
    }

    /**
     *
     */
    override suspend fun delete(id: Int): Boolean {
        //return Articles.deleteWhere(1, 1) { Articles.id eq id } > 0
        return Articles.deleteWhere { Articles.id eq id } > 0
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    /**
     * Helper function method to extract query result
     */
    private fun resultRowToArticle(row:ResultRow) = Article(
        id = row[Articles.id],
        title = row[Articles.title],
        body = row[Articles.body]
    )

    // </editor-fold>
}