package net.rf43.royaleapikit.consumer

import com.google.gson.annotations.SerializedName

object RawPlayerModel {
    data class RawPlayer(val tag: String? = null, val name: String? = null, val trophies: Int?, val rank: Int?)
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
        @SerializedName("image") val image: String? = null
    )

    data class RawTopPlayerArena(
        @SerializedName("name") val name: String? = null,
        @SerializedName("arena") val arena: String? = null,
        @SerializedName("arenaID") val arenaID: Int? = null,
        @SerializedName("trophyLimit") val trophyLimit: Int? = null
    )
}