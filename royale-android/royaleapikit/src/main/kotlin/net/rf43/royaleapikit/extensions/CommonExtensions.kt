package net.rf43.royaleapikit.extensions

import android.content.Context
import com.google.gson.Gson
import net.rf43.royaleapikit.consumer.RawConstantsModel
import net.rf43.royaleapikit.consumer.RawTopPlayerModel
import java.nio.charset.Charset

inline fun <reified T : Any> T.toJson(): String = Gson().toJson(this, T::class.java)
inline fun <reified T : Any> String.fromJson(): T = Gson().fromJson(this, T::class.java)

inline fun <reified T : Any> T.persist(context: Context) {
    val json = this.toJson()
    if (json.isNotBlank()) {
        context.openFileOutput(this.getPersistFilename(), Context.MODE_PRIVATE).use { stream ->
            stream.write(json.toByteArray())
        }
    }
}

inline fun <reified T : Any> getJsonFromFile(context: Context): String {
    var fn = ""

    if (RawConstantsModel.RawConstant() is T) {
        fn = "royale_constants.json"
    } else
        if (RawTopPlayerModel.RawTopPlayer() is T) {
            fn =  "royale_top_players.json"
        }

    val fromFile = context.openFileInput(fn)
    return fromFile.bufferedReader(Charset.defaultCharset()).use { it.readLine() }
}

inline fun <reified T : Any> T.getPersistFilename(): String {
    if (this is RawConstantsModel.RawConstant) {
        return "royale_constants.json"
    }

    if (this is RawTopPlayerModel.RawTopPlayer) {
        return "royale_top_players.json"
    }

    return ""
}