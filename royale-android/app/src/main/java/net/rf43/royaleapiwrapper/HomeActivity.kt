package net.rf43.royaleapiwrapper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.rf43.royaleapiwrapper.top_players.ActivityTopPlayers

class HomeActivity : AppCompatActivity() {

    private lateinit var homeTitle: TextView
    private lateinit var topPlayerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeTitle = findViewById(R.id.home_title)
        topPlayerButton = findViewById(R.id.home_top_players_button)

        topPlayerButton.setOnClickListener {
            startActivity(Intent(
                    this,
                    ActivityTopPlayers::class.java
            ))
        }
    }
}