package net.rf43.royaleapikit.provider

object PlayerModel {
    data class Player(val tag: String, val name: String, val trophies: Int, val rank: Int)
}

object PopularPlayerModel {
    data class PopularPlayer(val tag: String, val name: String, val trophies: Int, val rank: Int)
}

object TopPlayerModel {
    data class TopPlayer(
            val name: String,
            val tag: String,
            val rank: Int,
            val previousRank: Int,
            val expLevel: Int,
            val trophies: Int,
            val clan: TopPlayerClan,
            val arena: TopPlayerArena
    )

    data class TopPlayerClan(
            val tag: String,
            val name: String,
            val badge: TopPlayerClanBadge
    )

    data class TopPlayerClanBadge(
            val name: String,
            val category: String,
            val id: Int,
            val image: String
    )

    data class TopPlayerArena(
            val name: String,
            val arena: String,
            val arenaID: Int,
            val trophyLimit: Int
    )
}