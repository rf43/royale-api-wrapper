package net.rf43.royaleapiwrapperkit.consumer

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDataService {

    @GET("player/{playerId}")
    fun player(@Path("playerId") playerId: String): Call<RawPlayerModel.RawPlayer>

    @GET("top/players")
    fun topPlayers(): Call<List<RawTopPlayerModel.RawTopPlayer>?>

    @GET("popular/players")
    fun popularPlayers(): Call<List<RawPopularPlayerModel.RawPopularPlayer>>

    @GET("constants")
    fun constants(): Call<ResponseBody>

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
                .build()

            return retrofit.create(ApiDataService::class.java)
        }
    }
}