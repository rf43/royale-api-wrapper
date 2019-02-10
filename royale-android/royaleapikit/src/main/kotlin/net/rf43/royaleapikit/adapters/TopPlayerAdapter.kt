package net.rf43.royaleapikit.adapters

import net.rf43.royaleapikit.consumer.RawTopPlayerModel
import net.rf43.royaleapikit.provider.TopPlayerModel

class TopPlayerAdapter {

    fun convert(rawTopPlayer: RawTopPlayerModel.RawTopPlayer?): TopPlayerModel.TopPlayer {
        val name = rawTopPlayer?.name ?: "UNKNOWN"
        val tag = rawTopPlayer?.tag ?: "UNKNOWN"
        val rank = rawTopPlayer?.rank ?: 0
        val prevRank = rawTopPlayer?.previousRank ?: 0

        val clanTag = rawTopPlayer?.clan?.tag ?: ""
        val clanName = rawTopPlayer?.clan?.name ?: "NO CLAN"

        val clanBadgeImgUrl = rawTopPlayer?.clan?.badge?.image ?: ""


        return TopPlayerModel.TopPlayer(
                name,
                tag,
                rank,
                prevRank,
                0,
                0,
                TopPlayerModel.TopPlayerClan(
                        clanTag,
                        clanName,
                        TopPlayerModel.TopPlayerClanBadge(
                                "",
                                "",
                                0,
                                clanBadgeImgUrl
                        )
                ),
                TopPlayerModel.TopPlayerArena(
                        "",
                        "",
                        0,
                        0
                )
        )
    }

    fun convert(rawList: List<RawTopPlayerModel.RawTopPlayer>): List<TopPlayerModel.TopPlayer> {
        val outList = mutableListOf<TopPlayerModel.TopPlayer>()
        var i = 0
        rawList.forEach {
            outList.add(i, convert(it))
            i++
        }
        return outList.toList()
    }
}