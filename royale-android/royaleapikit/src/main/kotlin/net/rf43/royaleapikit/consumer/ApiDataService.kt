package net.rf43.royaleapikit.consumer

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDataService {

    @GET("player/{playerId}")
    fun playerAsync(@Path("playerId") playerId: String): Deferred<Response<RawPlayerModel.RawPlayer>>

    @GET("top/players")
    fun topPlayersAsync(): Deferred<Response<List<RawTopPlayerModel.RawTopPlayer>?>>

    @GET("popular/players")
    fun popularPlayersAsync(): Deferred<Response<List<RawPopularPlayerModel.RawPopularPlayer>>>

    @GET("constants")
    fun constantsAsync(): Deferred<Response<ResponseBody>>

    companion object {
        private const val CR_API_BASE_ENDPOINT = "https://api.royaleapi.com/"

        fun create(developerKey: String): ApiDataService {

            val builder = OkHttpClient().newBuilder().addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader("auth", developerKey).build()
                chain.proceed(request)
            }

            val retrofit = Retrofit.Builder()
                .baseUrl(CR_API_BASE_ENDPOINT)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(ApiDataService::class.java)
        }
    }
}