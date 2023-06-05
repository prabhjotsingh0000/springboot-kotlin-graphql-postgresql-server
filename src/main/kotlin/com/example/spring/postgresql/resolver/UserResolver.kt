package com.example.spring.postgresql.resolver

import com.example.spring.postgresql.model.User
import com.example.spring.postgresql.repository.UserRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserResolver(private val userRepository: UserRepository) {

    @QueryMapping
    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    @QueryMapping
    fun getUser(@Argument id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    @MutationMapping
    fun createUser(@Argument name: String, @Argument email: String): User {
        println("Resolver for createUser is called with name: $name, email: $email")

        val user = User(name = name, email = email)
        return userRepository.save(user)
    }

    @MutationMapping
    fun updateUser(@Argument id: Long, @Argument name: String, @Argument email: String): User? {
        val user = userRepository.findById(id).orElse(null)
        if (user != null) {
            user.name = name
            user.email = email
            userRepository.save(user)
        }
        return user
    }

    @MutationMapping
    fun deleteUser(@Argument id: Long): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
