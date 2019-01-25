package net.rf43.royaleapiwrapper

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import net.rf43.royaleapiwrapperkit.RoyaleApiKit
import net.rf43.royaleapiwrapperkit.callbacks.TopPlayerCallback
import net.rf43.royaleapiwrapperkit.consumer.RawTopPlayerModel

class MainActivity : AppCompatActivity() {

    private lateinit var royaleApiKit: RoyaleApiKit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        royaleApiKit = RoyaleApiKit(BuildConfig.developerKey)

        val button = findViewById<Button?>(R.id.button_yo)
        button?.setOnClickListener {
            royaleApiKit.getTopPlayers(object : TopPlayerCallback<RawTopPlayerModel.RawTopPlayer> {
                override fun onUpdate(playerList: List<RawTopPlayerModel.RawTopPlayer>?) {
                    Log.w("", "")
                }
            })
        }
    }
}
