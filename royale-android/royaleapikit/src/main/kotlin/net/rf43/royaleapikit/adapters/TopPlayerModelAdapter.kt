package net.rf43.royaleapikit.adapters

import net.rf43.royaleapikit.consumer.RawTopPlayerModel
import net.rf43.royaleapikit.provider.TopPlayerModel

class TopPlayerModelAdapter {

    private fun convert(rawTopPlayer: RawTopPlayerModel.RawTopPlayer?): TopPlayerModel.TopPlayer {
        val name = rawTopPlayer?.name ?: "UNKNOWN"
        val tag = rawTopPlayer?.tag ?: "UNKNOWN"
        val rank = rawTopPlayer?.rank ?: 0
        val prevRank = rawTopPlayer?.previousRank ?: 0
        val expLevel = rawTopPlayer?.expLevel ?: 0
        val trophies = rawTopPlayer?.trophies ?: 0

        val clanTag = rawTopPlayer?.clan?.tag ?: ""
        val clanName = rawTopPlayer?.clan?.name ?: "NO CLAN"

        val clanBadgeName = rawTopPlayer?.clan?.badge?.name ?: ""
        val clanBadgeCategory = rawTopPlayer?.clan?.badge?.category ?: ""
        val clanBadgeId = rawTopPlayer?.clan?.badge?.id ?: 0
        val clanBadgeImgUrl = rawTopPlayer?.clan?.badge?.imageUrl ?: ""

        val arenaName = rawTopPlayer?.arena?.name ?: ""
        val arenaArena = rawTopPlayer?.arena?.arena ?: ""
        val arenaId = rawTopPlayer?.arena?.arenaID ?: 0
        val arenaTrophyLimit = rawTopPlayer?.arena?.trophyLimit ?: 0

        return TopPlayerModel.TopPlayer(
                name,
                tag,
                rank,
                prevRank,
                expLevel,
                trophies,
                TopPlayerModel.TopPlayerClan(
                        clanTag,
                        clanName,
                        TopPlayerModel.TopPlayerClanBadge(
                                clanBadgeName,
                                clanBadgeCategory,
                                clanBadgeId,
                                clanBadgeImgUrl
                        )
                ),
                TopPlayerModel.TopPlayerArena(
                        arenaName,
                        arenaArena,
                        arenaId,
                        arenaTrophyLimit
                )
        )
    }

    fun convert(rawList: List<RawTopPlayerModel.RawTopPlayer>): List<TopPlayerModel.TopPlayer> {
        val outList = mutableListOf<TopPlayerModel.TopPlayer>()

        rawList.forEach {
            outList.add(convert(it))
        }

        return outList.toList()
    }
}