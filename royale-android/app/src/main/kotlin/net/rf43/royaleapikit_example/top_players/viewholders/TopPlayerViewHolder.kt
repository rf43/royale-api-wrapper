package net.rf43.royaleapikit_example.top_players.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit.provider.TopPlayerModel

class TopPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val clanName = itemView.findViewById<TextView>(R.id.top_player_clan_title)
    private val clanBadge = itemView.findViewById<ImageView>(R.id.top_player_clan_badge)
    private val playerName = itemView.findViewById<TextView>(R.id.top_player_name)
    private val playerRank = itemView.findViewById<TextView>(R.id.top_player_rank)
    private val playerTag = itemView.findViewById<TextView>(R.id.top_player_tag)
    private val playerRankMovementAmount = itemView.findViewById<TextView>(R.id.top_player_rank_movement_amount)
    private val playerRankMovementArrow = itemView.findViewById<ImageView>(R.id.top_player_rank_movement_arrow)

    fun bind(item: TopPlayerModel.TopPlayer, position: Int) {
        setClanUi(item)
        setPlayerUi(item, position)
    }

    private fun setClanUi(player: TopPlayerModel.TopPlayer) {
        clanName.text = player.clan.name

        if (player.clan.tag.isBlank()) {
            clanBadge.setImageDrawable(itemView.context.getDrawable(R.drawable.no_clan))
        } else {
            Glide.with(itemView.context).load(player.clan.badge.image).into(clanBadge)
        }
    }

    private fun setPlayerUi(player: TopPlayerModel.TopPlayer, position: Int) {
        playerTag.text = itemView.resources.getString(R.string.player_tag_with_leading_hash, player.tag)
        playerName.text = player.name
        playerRank.text = itemView.resources.getString(R.string.ranking_with_number_hash, position + 1)

        val movement = getPlayerRankMovement(player)
        playerRankMovementAmount.text = movement.toString()
        if (movement > 0) {
            playerRankMovementArrow.setImageDrawable(itemView.context.getDrawable(R.drawable.ic_arrow_upward))
        } else {
            playerRankMovementArrow.setImageDrawable(itemView.context.getDrawable(R.drawable.ic_arrow_downward))
        }
    }

    private fun getPlayerRankMovement(player: TopPlayerModel.TopPlayer): Int {
        return player.previousRank.minus(player.rank)
    }
}
