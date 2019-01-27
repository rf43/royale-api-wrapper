package net.rf43.royaleapiwrapper.top_players

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.rf43.royaleapiwrapper.BuildConfig
import net.rf43.royaleapiwrapper.R
import net.rf43.royaleapiwrapper.top_players.adapters.TopPlayersListAdapter
import net.rf43.royaleapiwrapperkit.RoyaleApiKit
import net.rf43.royaleapiwrapperkit.consumer.RawTopPlayerModel

class ActivityTopPlayers : AppCompatActivity() {

    private lateinit var royaleApiKit: RoyaleApiKit
    private lateinit var topPlayerRecyclerView: RecyclerView
    private lateinit var topPlayerLoadingIndicator: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_top_players)

        royaleApiKit = RoyaleApiKit(BuildConfig.developerKey)

        topPlayerLoadingIndicator = findViewById(R.id.top_player_loading_indicator)
        topPlayerLoadingIndicator.visibility = View.VISIBLE

        topPlayerRecyclerView = findViewById(R.id.recycler_top_players)
        topPlayerRecyclerView.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch(Dispatchers.Main) {
            val theList = royaleApiKit.getTopPlayers()
            delay(5000)
            initTopPlayerList(theList)
            topPlayerLoadingIndicator.visibility = View.GONE
        }
    }

    private fun initTopPlayerList(players: List<RawTopPlayerModel.RawTopPlayer>) {
        topPlayerRecyclerView.adapter = TopPlayersListAdapter(context = this, players = players)
    }
}