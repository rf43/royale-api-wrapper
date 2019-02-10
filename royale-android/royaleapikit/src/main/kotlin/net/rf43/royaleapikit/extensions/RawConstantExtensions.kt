package net.rf43.royaleapikit.extensions

import net.rf43.royaleapikit.consumer.RawConstantsModel

fun RawConstantsModel.RawConstant?.isValid(): Boolean {

    var isValid = false

    if (this == null) {
        return false
    }

    if (this.cards != null) {
        isValid = true
    }

    if (this.arenas != null) {
        isValid = true
    }

    if (this.allianceBadges != null) {
        isValid = true
    }

    if (this.cardsStats != null) {
        isValid = true
    }

    if (this.challenges != null) {
        isValid = true
    }

    if (this.chestOrder != null) {
        isValid = true
    }

    if (this.clan_chest != null) {
        isValid = true
    }

    if (this.game_modes != null) {
        isValid = true
    }

    if (this.regions != null) {
        isValid = true
    }

    if (this.rarities != null) {
        isValid = true
    }

    if (this.tournaments != null) {
        isValid = true
    }

    return isValid
}
