package com.example.hydra_hymail.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class Settings(
    @PrimaryKey val id: Int = 0, // Single row for app settings
    val darkMode: Boolean = false,
    val fontScale: Float = 1.0f,
    val language: String = "en",
    val notificationsEnabled: Boolean = true,
    val biometricEnabled: Boolean = false
)
