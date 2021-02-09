package net.rf43.royaleapikit.adapters

import net.rf43.royaleapikit.consumer.RawPlayerModel
import net.rf43.royaleapikit.provider.PlayerModel

class PlayerModelAdapter {

    fun convert(rawPlayer: RawPlayerModel.RawPlayer?): PlayerModel.Player {

        val name = rawPlayer?.name ?: ""
        val tag = rawPlayer?.tag ?: ""
        val trophies = rawPlayer?.trophies ?: 0
        val rank = rawPlayer?.rank ?: 0
        val deckUrl = rawPlayer?.deckUrl ?: ""

        val arenaName = rawPlayer?.arena?.name ?: ""
        val arenaArena = rawPlayer?.arena?.arena ?: ""
        val arenaId = rawPlayer?.arena?.arenaId ?: 0
        val arenaTrophyLimit = rawPlayer?.arena?.trophyLimit ?: 0

        val clanTag = rawPlayer?.clan?.tag ?: ""
        val clanName = rawPlayer?.clan?.name ?: ""
        val clanRole = rawPlayer?.clan?.role ?: ""
        val clanDonations = rawPlayer?.clan?.donations ?: 0
        val clanDonationsReceived = rawPlayer?.clan?.donationsReceived ?: 0
        val clanDonationsDelta = rawPlayer?.clan?.donationsDelta ?: 0

        val clanBadgeName = rawPlayer?.clan?.badge?.name ?: ""
        val clanBadgeCategory = rawPlayer?.clan?.badge?.category ?: ""
        val clanBadgeId = rawPlayer?.clan?.badge?.id ?: 0
        val clanBadgeImageUrl = rawPlayer?.clan?.badge?.imageUrl ?: ""

        val statsClanCardsCollected = rawPlayer?.stats?.clanCardsCollected ?: 0
        val statsTournamentCardsWon = rawPlayer?.stats?.tournamentCardsWon ?: 0
        val statsMaxTrophies = rawPlayer?.stats?.maxTrophies ?: 0
        val statsThreeCrownWins = rawPlayer?.stats?.threeCrownWins ?: 0
        val statsCardsFound = rawPlayer?.stats?.cardsFound ?: 0
        val statsTotalDonations = rawPlayer?.stats?.totalDonations ?: 0
        val statsChallengeMaxWins = rawPlayer?.stats?.challengeMaxWins ?: 0
        val statsChallengeCardsWon = rawPlayer?.stats?.challengeCardsWon ?: 0
        val statsLevel = rawPlayer?.stats?.level ?: 0

        val statsFavoriteCardName = rawPlayer?.stats?.favoriteCard?.name ?: ""
        val statsFavoriteCardId = rawPlayer?.stats?.favoriteCard?.id ?: 0
        val statsFavoriteCardMaxLevel = rawPlayer?.stats?.favoriteCard?.maxLevel ?: 0
        val statsFavoriteCardMinLevel = rawPlayer?.stats?.favoriteCard?.minLevel ?: 0
        val statsFavoriteCardIconUrl = rawPlayer?.stats?.favoriteCard?.iconUrl ?: ""
        val statsFavoriteCardKey = rawPlayer?.stats?.favoriteCard?.key ?: ""
        val statsFavoriteCardElixir = rawPlayer?.stats?.favoriteCard?.elixir ?: 0
        val statsFavoriteCardType = rawPlayer?.stats?.favoriteCard?.type ?: ""
        val statsFavoriteCardRarity = rawPlayer?.stats?.favoriteCard?.rarity ?: ""
        val statsFavoriteCardArena = rawPlayer?.stats?.favoriteCard?.arena ?: 0
        val statsFavoriteCardDescription = rawPlayer?.stats?.favoriteCard?.description ?: ""

        val gamesTotal = rawPlayer?.games?.total ?: 0
        val gamesTournamentGames = rawPlayer?.games?.tournamentGames ?: 0
        val gamesWins = rawPlayer?.games?.wins ?: 0
        val gamesWarDayWins = rawPlayer?.games?.warDayWins ?: 0
        val gamesLosses = rawPlayer?.games?.losses ?: 0
        val gamesDraws = rawPlayer?.games?.draws ?: 0
        val gamesWinsPercent = rawPlayer?.games?.winsPercent ?: 0f
        val gamesLossesPercent = rawPlayer?.games?.lossesPercent ?: 0f
        val gamesDrawsPercent = rawPlayer?.games?.drawsPercent ?: 0f

        val currentDeck = convertRawCurrentDeck(rawPlayer)
        val cards = convertRawCards(rawPlayer)
        val achievements = convertAchievements(rawPlayer)

        return PlayerModel.Player(
                tag,
                name,
                trophies,
                rank,
                PlayerModel.PlayerArena(
                        arenaName,
                        arenaArena,
                        arenaId,
                        arenaTrophyLimit
                ),
                PlayerModel.PlayerClan(
                        clanTag,
                        clanName,
                        clanRole,
                        clanDonations,
                        clanDonationsReceived,
                        clanDonationsDelta,
                        PlayerModel.PlayerClanBadge(
                                clanBadgeName,
                                clanBadgeCategory,
                                clanBadgeId,
                                clanBadgeImageUrl
                        )
                ),
                PlayerModel.PlayerStats(
                        statsClanCardsCollected,
                        statsTournamentCardsWon,
                        statsMaxTrophies,
                        statsThreeCrownWins,
                        statsCardsFound,
                        PlayerModel.PlayerStatsFavoriteCard(
                                statsFavoriteCardName,
                                statsFavoriteCardId,
                                statsFavoriteCardMaxLevel,
                                statsFavoriteCardMinLevel,
                                statsFavoriteCardIconUrl,
                                statsFavoriteCardKey,
                                statsFavoriteCardElixir,
                                statsFavoriteCardType,
                                statsFavoriteCardRarity,
                                statsFavoriteCardArena,
                                statsFavoriteCardDescription
                        ),
                        statsTotalDonations,
                        statsChallengeMaxWins,
                        statsChallengeCardsWon,
                        statsLevel
                ),
                PlayerModel.PlayerGames(
                        gamesTotal,
                        gamesTournamentGames,
                        gamesWins,
                        gamesWarDayWins,
                        gamesWinsPercent,
                        gamesLosses,
                        gamesLossesPercent,
                        gamesDraws,
                        gamesDrawsPercent
                ),
                deckUrl,
                currentDeck,
                cards,
                achievements
        )
    }

    // Helpers

    private fun convertRawCurrentDeck(rawPlayer: RawPlayerModel.RawPlayer?): List<PlayerModel.PlayerCard> {
        if (rawPlayer?.currentDeck == null) { // Short-circuit
            return emptyList()
        }

        val outList = mutableListOf<PlayerModel.PlayerCard>()
        rawPlayer.currentDeck.forEach {
            outList.add(convertPlayerCard(it))
        }
        return outList.toList()
    }

    private fun convertRawCards(rawPlayer: RawPlayerModel.RawPlayer?): List<PlayerModel.PlayerCard> {
        if (rawPlayer?.cards == null) { // Short-circuit
            return emptyList()
        }

        val outList = mutableListOf<PlayerModel.PlayerCard>()
        rawPlayer.cards.forEach {
            outList.add(convertPlayerCard(it))
        }
        return outList.toList()
    }

    private fun convertAchievements(rawPlayer: RawPlayerModel.RawPlayer?): List<PlayerModel.PlayerAchievement> {
        if (rawPlayer?.achievements == null) { // Short-circuit
            return emptyList()
        }

        val outList = mutableListOf<PlayerModel.PlayerAchievement>()
        rawPlayer.achievements.forEach {
            outList.add(convertPlayerAchievment(it))
        }
        return outList.toList()
    }

    private fun convertPlayerCard(rawCard: RawPlayerModel.RawPlayerCard?): PlayerModel.PlayerCard {
        return PlayerModel.PlayerCard(
                rawCard?.name ?: "",
                rawCard?.id ?: 0,
                rawCard?.level ?: 0,
                rawCard?.maxLevel ?: 0,
                rawCard?.count ?: 0,
                rawCard?.rarity ?: "",
                rawCard?.requiredForUpgrade ?: 0,
                rawCard?.leftToUpgrade ?: 0,
                rawCard?.displayLevel ?: 0,
                rawCard?.minLevel ?: 0,
                rawCard?.iconUrl ?: "",
                rawCard?.key ?: "",
                rawCard?.elixir ?: 0,
                rawCard?.type ?: "",
                rawCard?.arena ?: 0,
                rawCard?.description ?: ""
        )
    }

    private fun convertPlayerAchievment(rawAchievment: RawPlayerModel.RawPlayerAchievment?): PlayerModel.PlayerAchievement {
        return PlayerModel.PlayerAchievement(
                rawAchievment?.name ?: "",
                rawAchievment?.stars ?: 0,
                rawAchievment?.value ?: 0,
                rawAchievment?.target ?: 0,
                rawAchievment?.info ?: ""
        )
    }
}