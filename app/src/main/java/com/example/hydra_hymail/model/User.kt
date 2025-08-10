package com.example.hydra_hymail.model

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val profilePictureUrl: String? = null,
    val role: UserRole = UserRole.CONSUMER,
    val badges: List<Badge> = emptyList(),
    val settings: Settings = Settings(),
    val joinedAt: Long = System.currentTimeMillis()
)

enum class UserRole {
    CONSUMER,
    TENANT,
    GUEST
}
