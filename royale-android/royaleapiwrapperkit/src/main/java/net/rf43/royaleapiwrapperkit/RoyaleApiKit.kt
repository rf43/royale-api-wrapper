package net.rf43.royaleapiwrapperkit

import android.util.Log
import android.view.View
import net.rf43.royaleapiwrapperkit.callbacks.TopPlayerCallback
import net.rf43.royaleapiwrapperkit.consumer.ApiDataService
import net.rf43.royaleapiwrapperkit.consumer.RawTopPlayerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoyaleApiKit(developerKey: String) {

    private val royaleApiDataService = ApiDataService.create(developerKey)

    fun getTopPlayers(delegate: TopPlayerCallback<RawTopPlayerModel.RawTopPlayer>) {
        royaleApiDataService.topPlayers().enqueue(object : Callback<List<RawTopPlayerModel.RawTopPlayer>?> {
            override fun onFailure(call: Call<List<RawTopPlayerModel.RawTopPlayer>?>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<RawTopPlayerModel.RawTopPlayer>?>,
                response: Response<List<RawTopPlayerModel.RawTopPlayer>?>
            ) {
                if (response.isSuccessful && response.body() != null)
                delegate.onUpdate(response.body())
            }
        })
    }
}