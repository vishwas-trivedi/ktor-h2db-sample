package com.example.models

import org.jetbrains.exposed.sql.Table

/**
 * Data class representing Article data
 */
data class Article(val id: Int, val title: String, val body: String)


/**
 * Object representing Article table
 */
object Articles : Table()
{
    val id = integer("id").autoIncrement()
    val title = varchar("title",128).default("Default title")
    val body= varchar("body", 1024)

    override val primaryKey = PrimaryKey(id)
}
