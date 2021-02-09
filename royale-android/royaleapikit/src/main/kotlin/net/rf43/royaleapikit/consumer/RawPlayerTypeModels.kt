package net.rf43.royaleapikit.consumer

import com.google.gson.annotations.SerializedName

object RawPlayerModel {
    data class RawPlayer(
            @SerializedName("tag") val tag: String? = null,
            @SerializedName("name") val name: String? = null,
            @SerializedName("trophies") val trophies: Int? = null,
            @SerializedName("rank") val rank: Int? = null,
            @SerializedName("arena") val arena: RawPlayerArena? = null,
            @SerializedName("clan") val clan: RawPlayerClan? = null,
            @SerializedName("stats") val stats: RawPlayerStats? = null,
            @SerializedName("games") val games: RawPlayerGames? = null,
            @SerializedName("deckLink") val deckUrl: String? = null,
            @SerializedName("currentDeck") val currentDeck: List<RawPlayerCard>? = null,
            @SerializedName("cards") val cards: List<RawPlayerCard>? = null,
            @SerializedName("achievements") val achievements: List<RawPlayerAchievment>? = null
    )

    data class RawPlayerArena(
            @SerializedName("name") val name: String? = null,
            @SerializedName("arena") val arena: String? = null,
            @SerializedName("arenaID") val arenaId: Int? = null,
            @SerializedName("trophyLimit") val trophyLimit: Int? = null
    )

    data class RawPlayerClan(
            @SerializedName("tag") val tag: String? = null,
            @SerializedName("name") val name: String? = null,
            @SerializedName("role") val role: String? = null,
            @SerializedName("donations") val donations: Int? = null,
            @SerializedName("donationsReceived") val donationsReceived: Int? = null,
            @SerializedName("donationsDelta") val donationsDelta: Int? = null,
            @SerializedName("badge") val badge: RawPlayerModel.RawPlayerClanBadge? = null
    )

    data class RawPlayerClanBadge(
            @SerializedName("name") val name: String? = null,
            @SerializedName("category") val category: String? = null,
            @SerializedName("id") val id: Int? = null,
            @SerializedName("image") val imageUrl: String? = null
    )

    data class RawPlayerStats(
            @SerializedName("clanCardsCollected") val clanCardsCollected: Int? = null,
            @SerializedName("tournamentCardsWon") val tournamentCardsWon: Int? = null,
            @SerializedName("maxTrophies") val maxTrophies: Int? = null,
            @SerializedName("threeCrownWins") val threeCrownWins: Int? = null,
            @SerializedName("cardsFound") val cardsFound: Int? = null,
            @SerializedName("favoriteCard") val favoriteCard: RawPlayerStatsFavoriteCard? = null,
            @SerializedName("totalDonations") val totalDonations: Int? = null,
            @SerializedName("challengeMaxWins") val challengeMaxWins: Int? = null,
            @SerializedName("challengeCardsWon") val challengeCardsWon: Int? = null,
            @SerializedName("level") val level: Int? = null
    )

    data class RawPlayerStatsFavoriteCard(
            @SerializedName("name") val name: String? = null,
            @SerializedName("id") val id: Int? = null,
            @SerializedName("maxLevel") val maxLevel: Int? = null,
            @SerializedName("minLevel") val minLevel: Int? = null,
            @SerializedName("icon") val iconUrl: String? = null,
            @SerializedName("key") val key: String? = null,
            @SerializedName("elixir") val elixir: Int? = null,
            @SerializedName("type") val type: String? = null,
            @SerializedName("rarity") val rarity: String? = null,
            @SerializedName("arena") val arena: Int? = null,
            @SerializedName("description") val description: String? = null
    )

    data class RawPlayerGames(
            @SerializedName("total") val total: Int? = null,
            @SerializedName("tournamentGames") val tournamentGames: Int? = null,
            @SerializedName("wins") val wins: Int? = null,
            @SerializedName("warDayWins") val warDayWins: Int? = null,
            @SerializedName("winsPercent") val winsPercent: Float? = null,
            @SerializedName("losses") val losses: Int? = null,
            @SerializedName("lossesPercent") val lossesPercent: Float? = null,
            @SerializedName("draws") val draws: Int? = null,
            @SerializedName("drawsPercent") val drawsPercent: Float? = null
    )

    data class RawPlayerCard(
            @SerializedName("name") val name: String? = null,
            @SerializedName("id") val id: Int? = null,
            @SerializedName("level") val level: Int? = null,
            @SerializedName("maxLevel") val maxLevel: Int? = null,
            @SerializedName("count") val count: Int? = null,
            @SerializedName("rarity") val rarity: String? = null,
            @SerializedName("requiredForUpgrade") val requiredForUpgrade: Int? = null,
            @SerializedName("leftToUpgrade") val leftToUpgrade: Int? = null,
            @SerializedName("displayLevel") val displayLevel: Int? = null,
            @SerializedName("minLevel") val minLevel: Int? = null,
            @SerializedName("icon") val iconUrl: String? = null,
            @SerializedName("key") val key: String? = null,
            @SerializedName("elixir") val elixir: Int? = null,
            @SerializedName("type") val type: String? = null,
            @SerializedName("arena") val arena: Int? = null,
            @SerializedName("description") val description: String? = null
    )

    data class RawPlayerAchievment(
            @SerializedName("name") val name: String? = null,
            @SerializedName("stars") val stars: Int? = null,
            @SerializedName("value") val value: Int? = null,
            @SerializedName("target") val target: Int? = null,
            @SerializedName("info") val info: String? = null
    )
}

object RawPopularPlayerModel {
    data class RawPopularPlayer(val tag: String?, val name: String?, val trophies: Int?, val rank: Int?)
}

object RawTopPlayerModel {
    data class RawTopPlayer(
            @SerializedName("name") val name: String? = null,
            @SerializedName("tag") val tag: String? = null,
            @SerializedName("rank") val rank: Int? = null,
            @SerializedName("previousRank") val previousRank: Int? = null,
            @SerializedName("expLevel") val expLevel: Int? = null,
            @SerializedName("trophies") val trophies: Int? = null,
            @SerializedName("donationsDelta") val donationsDelta: Any? = null,
            @SerializedName("clan") val clan: RawTopPlayerClan? = null,
            @SerializedName("arena") val arena: RawTopPlayerArena? = null
    )

    data class RawTopPlayerClan(
            @SerializedName("tag") val tag: String? = null,
            @SerializedName("name") val name: String? = null,
            @SerializedName("badge") val badge: RawTopPlayerClanBadge? = null
    )

    data class RawTopPlayerClanBadge(
            @SerializedName("name") val name: String? = null,
            @SerializedName("category") val category: String? = null,
            @SerializedName("id") val id: Int? = null,
            @SerializedName("image") val imageUrl: String? = null
    )

    data class RawTopPlayerArena(
            @SerializedName("name") val name: String? = null,
            @SerializedName("arena") val arena: String? = null,
            @SerializedName("arenaID") val arenaID: Int? = null,
            @SerializedName("trophyLimit") val trophyLimit: Int? = null
    )
}