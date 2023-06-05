package com.example.spring.postgresql.repository

import com.example.spring.postgresql.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>