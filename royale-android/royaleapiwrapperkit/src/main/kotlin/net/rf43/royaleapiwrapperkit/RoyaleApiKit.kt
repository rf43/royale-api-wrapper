package net.rf43.royaleapiwrapperkit

import android.util.Log
import net.rf43.royaleapiwrapperkit.consumer.ApiDataService
import net.rf43.royaleapiwrapperkit.consumer.RawTopPlayerModel
import retrofit2.HttpException

class RoyaleApiKit(developerKey: String) {

    private val royaleApiDataService = ApiDataService.create(developerKey)

    suspend fun getTopPlayers(): List<RawTopPlayerModel.RawTopPlayer> {
        val pList = royaleApiDataService.topPlayersAsync()
        try {
            val response = pList.await()
            response.body()?.let {
                return it
            }
        } catch (e: HttpException) {
            Log.e("RoyaleApiKit", "There was an HttpException error", e)
        } catch (e: Throwable) {
            Log.e("RoyaleApiKit", "There was a Throwable error", e)
        }

        return emptyList()
    }
}