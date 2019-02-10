package net.rf43.royaleapikit_example.top_players.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.rf43.royaleapikit.provider.TopPlayerModel
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit_example.top_players.viewholders.TopPlayerSkeletonViewHolder
import net.rf43.royaleapikit_example.top_players.viewholders.TopPlayerViewHolder

class TopPlayersListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var players: List<TopPlayerModel.TopPlayer>
    private val skeletonViewListCount = 10

    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == R.layout.item_top_player) {
            TopPlayerViewHolder(LayoutInflater.from(context).inflate(viewType, parent, false))
        } else {
            TopPlayerSkeletonViewHolder(LayoutInflater.from(context).inflate(viewType, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return if (this::players.isInitialized) {
            players.size
        } else {
            skeletonViewListCount
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (this::players.isInitialized) {
            R.layout.item_top_player
        } else {
            R.layout.item_loading_skeleton
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (this::players.isInitialized && holder is TopPlayerViewHolder) {
            holder.bind(players[position], position)
        }
    }

    fun addPlayers(players: List<TopPlayerModel.TopPlayer>) {
        this.players = players
        this.notifyDataSetChanged()
    }
}