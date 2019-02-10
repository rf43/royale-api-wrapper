package net.rf43.royaleapikit_example.top_players.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.rf43.royaleapikit.provider.TopPlayerModel
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit_example.top_players.viewholders.TopPlayerViewHolder

class TopPlayersListAdapter(val context: Context, val players: List<TopPlayerModel.TopPlayer>) :
        RecyclerView.Adapter<TopPlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPlayerViewHolder {
        return TopPlayerViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_top_player,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: TopPlayerViewHolder, position: Int) {
        holder.bind(players[position], position)
    }
}