package com.example.hydra_hymail.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * RetrofitInstance is our one-stop setup for network calls.
 * This creates Retrofit services for all APIs we use in the app.
 *
 * Why centralize this?
 * - Keeps API configuration consistent across the app
 * - Easier to change base URLs or timeout settings later
 * - Devs can clearly see where to add new APIs
 */
object RetrofitInstance {

    // Replace this with your actual base URL (for mock API or backend)
    private const val BASE_URL = "https://your-backend-api.com/"

    // Logging interceptor for debugging API calls
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Shows request & response in Logcat
    }

    // OkHttp client with logging and timeouts
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS) // 30 sec connect timeout
        .readTimeout(30, TimeUnit.SECONDS)    // 30 sec read timeout
        .writeTimeout(30, TimeUnit.SECONDS)   // 30 sec write timeout
        .build()

    // Retrofit builder configured with Gson
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // JSON <-> Kotlin
            .build()
    }

    // --- API interfaces ---
    // Each API interface is created here so you can use it anywhere in the app

    val postApi: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }

    val userApi: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    val settingsApi: SettingsApi by lazy {
        retrofit.create(SettingsApi::class.java)
    }

    val maintenanceApi: MaintenanceApi by lazy {
        retrofit.create(MaintenanceApi::class.java)
    }

    val mapApi: MapApi by lazy {
        retrofit.create(MapApi::class.java)
    }

    val leaderboardApi: LeaderboardApi by lazy {
        retrofit.create(LeaderboardApi::class.java)
    }

    val cloudinaryApi: CloudinaryApi by lazy {
        retrofit.create(CloudinaryApi::class.java)
    }

    val googleMapsApi: GoogleMapsApi by lazy {
        retrofit.create(GoogleMapsApi::class.java)
    }

    val openWeatherApi: OpenWeatherApi by lazy {
        retrofit.create(OpenWeatherApi::class.java)
    }
}
