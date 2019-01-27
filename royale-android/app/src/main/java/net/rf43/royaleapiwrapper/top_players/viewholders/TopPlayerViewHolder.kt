package net.rf43.royaleapiwrapper.top_players.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.rf43.royaleapiwrapper.R
import net.rf43.royaleapiwrapperkit.consumer.RawTopPlayerModel

class TopPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView = itemView.findViewById<TextView>(R.id.top_player_name)

    fun bind(player: RawTopPlayerModel.RawTopPlayer) {
        nameTextView.text = player.name
    }
}