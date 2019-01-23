package net.rf43.royaleapiwrapperkit

import android.util.Log
import net.rf43.royaleapiwrapperkit.api.RawTopPlayerModel
import net.rf43.royaleapiwrapperkit.api.RoyaleApiDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoyaleApiKit(developerKey: String) {

    private val royaleApiDataService = RoyaleApiDataService.create(developerKey)

    fun getTopPlayers(max: Int = 1000) {
        royaleApiDataService.topPlayers().enqueue(object : Callback<List<RawTopPlayerModel.RawTopPlayer>> {
            override fun onFailure(call: Call<List<RawTopPlayerModel.RawTopPlayer>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<RawTopPlayerModel.RawTopPlayer>>,
                response: Response<List<RawTopPlayerModel.RawTopPlayer>>) {
                Log.i("ROYALE_API_KIT", "onResponse => list of top players returned")
                Log.w("ROYALE_API_KIT", response.body().toString())
            }
        })
    }
}