package net.rf43.royaleapikit

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.rf43.royaleapikit.consumer.ApiDataService
import net.rf43.royaleapikit.consumer.RawConstantsModel
import net.rf43.royaleapikit.consumer.RawPlayerModel
import net.rf43.royaleapikit.consumer.RawTopPlayerModel
import net.rf43.royaleapikit.extensions.isValid
import retrofit2.HttpException

class RoyaleApiKit(private val context: Context, developerKey: String, private val useCache: Boolean = true) {

    private val royaleApiDataService: ApiDataService = ApiDataService.create(developerKey)
    private val royaleLog: Logger = Logger(RoyaleApiKit::class.java.simpleName)

    private lateinit var royaleConstants: RawConstantsModel.RawConstant

    init {
        GlobalScope.launch(Dispatchers.Main) {
            royaleConstants = getRawApiConstants()
        }
    }

    /**
     * There are 3 ways to get these objects
     *  - Memory
     *      - The object will be in memory
     *          - If the object is inside the refresh limit
     *          - * AND *
     *          - If the object has been previously created
     *  - File system
     *      - The object will exist as a json file
     *      - If the object was previously written to the file system
     *  - External API
     *
     * Leveraging these 3 methods of storage, we should try all three in the exact order
     * so for example, when attempting to retrieve the top players...
     *
     *  - Has the top players object been initialized and is it valid?
     *      - yes
     *          - use that object
     *      - no
     *          - Does the json file exist?
     *              - yes
     *                  - Retrieve the file
     *              - no
     *                  - Retrieve the json from the API
     *  (Note: that is a shortened version for example purposes)
     *
     **/

    /**
     * Retrieves the raw constants
     */
    suspend fun getRawApiConstants(): RawConstantsModel.RawConstant {
        return if (this::royaleConstants.isInitialized && royaleConstants.isValid()) {
            royaleConstants
        } else {
            royaleConstants = RoyaleConstants(context, royaleApiDataService).getConstants()
            royaleConstants
        }
    }

    suspend fun getRawTopPlayers(): List<RawTopPlayerModel.RawTopPlayer> {
        val pList = royaleApiDataService.topPlayersAsync()

        try {
            val response = pList.await()
            if (response.body() != null && response.isSuccessful) {
                response.body()?.let {
                    return it
                }
            }
        } catch (e: HttpException) {
            royaleLog.e(message = "There was an HttpException error", methodName = "getTopPlayers", throwable = e)
        } catch (e: Throwable) {
            royaleLog.e(message = "There was a Throwable error", methodName = "getTopPlayers", throwable = e)
        }

        return emptyList()
    }

    suspend fun getRawPlayer(playerId: String): RawPlayerModel.RawPlayer {
        val playerResponseAsync = royaleApiDataService.playerAsync(playerId)

        try {
            val response = playerResponseAsync.await()
            if (response.body() != null && response.isSuccessful) {
                response.body()?.let {
                    return it
                }
            }
        } catch (e: HttpException) {
            royaleLog.e(message = "There was an HttpException error", methodName = "getPlayer", throwable = e)
        } catch (e: Throwable) {
            royaleLog.e(message = "There was a Throwable error", methodName = "getPlayer", throwable = e)
        }

        return RawPlayerModel.RawPlayer(null, null, null, null)
    }
}