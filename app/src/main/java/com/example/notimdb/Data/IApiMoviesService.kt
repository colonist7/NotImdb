package com.example.notimdb.Data
//
//import com.example.notimdb.Data.response.MovieDaraResponse
//import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
//import kotlinx.coroutines.Deferred
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//import retrofit2.http.GET
//
//const val MOVIES_URL = "https://my-json-server.typicode.com/nikoloz14/movies-db/db"
//
//interface IApiMoviesService {
//
//    @GET
//    fun getMoviesData(): Deferred<MovieDaraResponse>
//
//    companion object {
//        operator fun invoke(): IApiMoviesService {
//            val requestInterceptor = Interceptor {chain ->
//                val url = chain.request()
//                               .url()
//                               .newBuilder()
//                               .build()
//                val request = chain.request().newBuilder().url(url).build()
//
//                return@Interceptor chain.proceed(request)
//            }
//
//            val okHttpClient = OkHttpClient.Builder()
//                                            .addInterceptor(requestInterceptor)
//                                            .build()
//
//            return Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl(MOVIES_URL)
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(IApiMoviesService::class.java)
//        }
//    }
//}