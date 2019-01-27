package net.rf43.royaleapikit_example.top_players

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit_example.common.BaseActivity
import net.rf43.royaleapikit_example.top_players.adapters.TopPlayersListAdapter
import net.rf43.royaleapikit.consumer.RawTopPlayerModel

class ActivityTopPlayers : BaseActivity() {

    private lateinit var topPlayerRecyclerView: RecyclerView
    private lateinit var topPlayerLoadingIndicator: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_top_players)

        topPlayerLoadingIndicator = findViewById(R.id.top_player_loading_indicator)
        topPlayerLoadingIndicator.visibility = View.VISIBLE

        topPlayerRecyclerView = findViewById(R.id.recycler_top_players)
        topPlayerRecyclerView.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch(Dispatchers.Main) {
            initTopPlayerList(royaleApiKit.getRawTopPlayers())
            topPlayerLoadingIndicator.visibility = View.GONE
        }
    }

    private fun initTopPlayerList(players: List<RawTopPlayerModel.RawTopPlayer>) {
        topPlayerRecyclerView.adapter =
            TopPlayersListAdapter(context = this, players = players)
    }
}