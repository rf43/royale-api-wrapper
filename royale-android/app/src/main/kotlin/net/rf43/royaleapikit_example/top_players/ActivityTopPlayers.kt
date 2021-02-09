package net.rf43.royaleapikit_example.top_players

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.rf43.royaleapikit.provider.TopPlayerModel
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit_example.common.BaseActivity
import net.rf43.royaleapikit_example.top_players.adapters.TopPlayersListAdapter

class ActivityTopPlayers : BaseActivity() {

    private lateinit var topPlayersAdapter: TopPlayersListAdapter
    private lateinit var topPlayerLoadingIndicator: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_top_players)

        topPlayerLoadingIndicator = findViewById(R.id.top_player_loading_indicator)
        topPlayerLoadingIndicator.visibility = View.VISIBLE

        val topPlayerRecyclerView = findViewById<RecyclerView>(R.id.recycler_top_players)
        topPlayerRecyclerView.layoutManager = LinearLayoutManager(this)
        topPlayerRecyclerView.adapter = TopPlayersListAdapter(context = this)

        topPlayersAdapter = topPlayerRecyclerView.adapter as TopPlayersListAdapter

        GlobalScope.launch(Dispatchers.Main) {
            loadPlayersIntoList(royaleApiKit.getTopPlayers())
            topPlayerLoadingIndicator.visibility = View.GONE
        }
    }

    private fun loadPlayersIntoList(players: List<TopPlayerModel.TopPlayer>) {
        topPlayersAdapter.addPlayers(players)
    }
}