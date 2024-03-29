package com.utkudogrusoz.bookservice.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name="books")
data class BookEntity @JvmOverloads constructor(
        @Id
        @GeneratedValue(generator = "UUID")
        @Column(name = "id")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = "",
        val title: String,
        val bookYear: Int,
        val author: String,
        val pressName: String,
        val isbn: String

) {
}