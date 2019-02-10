package net.rf43.royaleapikit_example.top_players.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit.consumer.RawTopPlayerModel

class TopPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val clanName = itemView.findViewById<TextView>(R.id.top_player_clan_title)
    private val clanBadge = itemView.findViewById<ImageView>(R.id.top_player_clan_badge)
    private val playerName = itemView.findViewById<TextView>(R.id.top_player_name)
    private val playerRank = itemView.findViewById<TextView>(R.id.top_player_rank)
    private val playerTag = itemView.findViewById<TextView>(R.id.top_player_tag)

    fun bind(player: RawTopPlayerModel.RawTopPlayer, position: Int) {
        setClanUi(player)
        setPlayerUi(player, position)
    }

    private fun setClanUi(player: RawTopPlayerModel.RawTopPlayer) {

        if (player.clan?.name.isNullOrBlank()) {
            clanName.text = itemView.resources.getString(R.string.no_clan)
            clanBadge.setImageDrawable(itemView.context.getDrawable(R.drawable.no_clan))
        } else {
            clanName.text = player.clan?.name
            Glide.with(itemView.context).load(player.clan?.badge?.image).into(clanBadge)
        }

    }

    private fun setPlayerUi(player: RawTopPlayerModel.RawTopPlayer, position: Int) {
        playerTag.text = itemView.resources.getString(R.string.player_tag_with_leading_hash, player.tag)
        playerName.text = player.name
        playerRank.text = itemView.resources.getString(R.string.ranking_with_number_hash, position + 1)
    }
}
