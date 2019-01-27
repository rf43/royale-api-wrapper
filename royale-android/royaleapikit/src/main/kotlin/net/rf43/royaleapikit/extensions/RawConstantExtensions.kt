package net.rf43.royaleapikit.extensions

import android.content.Context
import com.google.gson.Gson
import net.rf43.royaleapikit.consumer.RawConstantsModel

fun RawConstantsModel.RawConstant?.isValid(): Boolean {
    if (this == null) {
        return false
    }

    if (this.allianceBadges == null) {
        return false
    }

    if (this.arenas == null) {
        return false
    }

    if (this.cards == null) {
        return false
    }

    if (this.cardsStats == null || this.cardsStats.troops == null) {
        return false
    }

    return true
}

fun RawConstantsModel.RawConstant?.persist(context: Context) {
    val str = this.convertToJson()
    if (str != null && str.isNotEmpty()) {
        val constantsFilename = "royale_constants.json"
        context.openFileOutput(constantsFilename, Context.MODE_PRIVATE).use { stream ->
            stream.write(str.toByteArray())
        }
    }
}

fun RawConstantsModel.RawConstant?.convertToJson(): String? {
    if (this != null) {
        val str = Gson().toJson(this, RawConstantsModel.RawConstant::class.java)
        if (str != null && str.isNotEmpty()) {
            return str
        }
    }
    return null
}