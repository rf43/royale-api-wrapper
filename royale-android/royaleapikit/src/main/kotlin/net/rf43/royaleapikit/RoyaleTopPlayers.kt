package net.rf43.royaleapikit

import android.content.Context
import net.rf43.royaleapikit.consumer.ApiDataService
import net.rf43.royaleapikit.consumer.RawTopPlayerModel

class RoyaleTopPlayers(private val context: Context, private val royaleApiDataService: ApiDataService) {

    private val royaleLog: Logger = Logger(RoyaleTopPlayers::class.java.simpleName)

    private lateinit var rawTopPlayer: RawTopPlayerModel.RawTopPlayer

}