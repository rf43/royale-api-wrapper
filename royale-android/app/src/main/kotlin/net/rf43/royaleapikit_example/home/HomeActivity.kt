package net.rf43.royaleapikit_example.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit_example.common.BaseActivity
import net.rf43.royaleapikit_example.top_players.ActivityTopPlayers

class HomeActivity : BaseActivity() {

    private lateinit var homeTitle: TextView
    private lateinit var topPlayerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeTitle = findViewById(R.id.home_title)
        topPlayerButton = findViewById(R.id.home_top_players_button)

        topPlayerButton.setOnClickListener {
            startActivity(
                    Intent(
                            this,
                            ActivityTopPlayers::class.java
                    )
            )
        }
    }
}