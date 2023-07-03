package com.nelkinda.training.hello

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository

interface HelloRepository : JpaRepository<Hello, Long>

@Entity
data class Hello(
    @Id
    val id: Long,
    val message: String,
)
