package net.rf43.royaleapikit.provider

object PlayerModel {

    data class Player(
            val tag: String,
            val name: String,
            val trophies: Int,
            val rank: Int,
            val arena: PlayerArena,
            val clan: PlayerClan,
            val stats: PlayerStats,
            val games: PlayerGames,
            val deckUrl: String,
            val currentDeck: List<PlayerCard>,
            val cards: List<PlayerCard>,
            val achievements: List<PlayerAchievement>
    )

    data class PlayerArena(
            val name: String,
            val arena: String,
            val arenaId: Int,
            val trophyLimit: Int
    )

    data class PlayerClan(
            val tag: String,
            val name: String,
            val role: String,
            val donations: Int,
            val donationsReceived: Int,
            val donationsDelta: Int,
            val badge: PlayerModel.PlayerClanBadge
    )

    data class PlayerClanBadge(
            val name: String,
            val category: String,
            val id: Int,
            val imageUrl: String
    )

    data class PlayerStats(
            val clanCardsCollected: Int,
            val tournamentCardsWon: Int,
            val maxTrophies: Int,
            val threeCrownWins: Int,
            val cardsFound: Int,
            val favoriteCard: PlayerStatsFavoriteCard,
            val totalDonations: Int,
            val challengeMaxWins: Int,
            val challengeCardsWon: Int,
            val level: Int
    )

    data class PlayerStatsFavoriteCard(
            val name: String,
            val id: Int,
            val maxLevel: Int,
            val minLevel: Int,
            val iconUrl: String,
            val key: String,
            val elixir: Int,
            val type: String,
            val rarity: String,
            val arena: Int,
            val description: String
    )

    data class PlayerGames(
            val total: Int,
            val tournamentGames: Int,
            val wins: Int,
            val warDayWins: Int,
            val winsPercent: Float,
            val losses: Int,
            val lossesPercent: Float,
            val draws: Int,
            val drawsPercent: Float
    )

    data class PlayerCard(
            val name: String,
            val id: Int,
            val level: Int,
            val maxLevel: Int,
            val count: Int,
            val rarity: String,
            val requiredForUpgrade: Int,
            val leftToUpgrade: Int,
            val displayLevel: Int,
            val minLevel: Int,
            val iconUrl: String,
            val key: String,
            val elixir: Int,
            val type: String,
            val arena: Int,
            val description: String
    )

    data class PlayerAchievement(
            val name: String,
            val stars: Int,
            val value: Int,
            val target: Int,
            val info: String
    )

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