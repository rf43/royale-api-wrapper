package net.rf43.royaleapikit

import android.content.Context
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.rf43.royaleapikit.consumer.ApiDataService
import net.rf43.royaleapikit.consumer.RawPlayerModel
import net.rf43.royaleapikit.consumer.RawTopPlayerModel
import retrofit2.HttpException

class RoyaleApiKit(private val context: Context, developerKey: String) {

    private val royaleApiDataService: ApiDataService = ApiDataService.create(developerKey)

    init {
        GlobalScope.launch {
            val royaleConstants = RoyaleConstants(context, royaleApiDataService).getConstants()
            Log.i("launch", "Constants string...")
            Log.i("launch", royaleConstants.toString())
        }
    }

    suspend fun getTopPlayers(): List<RawTopPlayerModel.RawTopPlayer> {
        val pList = royaleApiDataService.topPlayersAsync()

        try {
            val response = pList.await()
            if (response.body() != null && response.isSuccessful) {
                response.body()?.let {
                    return it
                }
            }
        } catch (e: HttpException) {
            Log.e("RoyaleApiKit", "getTopPlayers -> There was an HttpException error", e)
        } catch (e: Throwable) {
            Log.e("RoyaleApiKit", "getTopPlayers -> There was a Throwable error", e)
        }

        return emptyList()
    }

    suspend fun getPlayer(playerId: String): RawPlayerModel.RawPlayer {
        val playerResponseAsync = royaleApiDataService.playerAsync(playerId)

        try {
            val response = playerResponseAsync.await()
            if (response.body() != null && response.isSuccessful) {
                response.body()?.let {
                    return it
                }
            }
        } catch (e: HttpException) {
            Log.e("RoyaleApiKit", "getPlayer -> There was an HttpException error", e)
        } catch (e: Throwable) {
            Log.e("RoyaleApiKit", "getPlayer -> There was a Throwable error", e)
        }

        return RawPlayerModel.RawPlayer(null, null, null, null)
    }
}