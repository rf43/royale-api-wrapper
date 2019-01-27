package net.rf43.royaleapikit

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import net.rf43.royaleapikit.consumer.ApiDataService
import net.rf43.royaleapikit.consumer.RawConstantsModel
import net.rf43.royaleapikit.consumer.areValid
import retrofit2.HttpException
import java.io.FileNotFoundException
import java.nio.charset.Charset

//data class RoyaleConstant(
//    val allianceBadge: RoyalConstantAllianceBadge
//)
//
//data class RoyalConstantAllianceBadge(
//    val name: String?,
//    val category: String?,
//    val id: Int?
//)

class RoyaleConstants(
    private val context: Context,
    private val royaleApiDataService: ApiDataService
) {
    private lateinit var royalApiKitConstants: RawConstantsModel.RawConstant
    private val constantsFilename: String = "royale_constants.json"

    suspend fun getConstants(): RawConstantsModel.RawConstant {
        // Check if constants are initialized
        if (this::royalApiKitConstants.isInitialized) {
            return royalApiKitConstants
        } else {
            // It's not initialized, let's check to see if there's a file
            if (context.fileList().contains(constantsFilename)) {
                // There's a file, let's try to read it
                val constsFromFile = readConstantsFromFile()
                if (constsFromFile.areValid()) {
                    Log.i("RoyaleApiKit", "Constants from the file system ARE valid! 01")
                    return constsFromFile!!
                } else {
                    Log.w("RoyaleApiKit", "Constants from the file system ARE NOT valid! 01")
                    Log.w("RoyaleApiKit", "Attempting to obtain them via the API...")
                    // Try to get them from the API
                    val constsStrFromApi = getConstantsFromApi()
                    val constsFromApi = convertToObject(constsStrFromApi)
                    if (constsFromApi.areValid()) {
                        Log.i("RoyaleApiKit", "Constants from the API are valid! 01")
                        writeConstantsToFile(constsFromApi!!)
                        return constsFromApi
                    } else {
                        // There's a problem...
                        Log.w("RoyaleApiKit", "Constants from the API ARE NOT valid! 01")
                        Log.e(
                            "RoyaleApiKit",
                            "There was a problem obtaining the API constants from both the API and file system 01"
                        )
                    }
                }
            } else {
                // There is no file, let's create one
                Log.d("RoyaleApiKit", "There is no file, create one... 02")
                val constsStrFromApi = getConstantsFromApi()
                if (constsStrFromApi != null && !constsStrFromApi.isEmpty()) {
                    writeConstantsToFile(constsStrFromApi)
                }
                val constsFromApi = convertToObject(constsStrFromApi)
                if (constsFromApi.areValid()) {
                    Log.i("RoyaleApiKit", "Constants ARE valid! 02")
                    return constsFromApi!!
                } else {
                    Log.w("RoyaleApiKit", "Constants from the API ARE NOT valid! 02")
                }
            }
        }
        // There is something wrong and we cannot create the constants
        Log.e(
            "RoyaleApiKit",
            "getConstants => Unable to instantiate a new RawConstant from file or external API 03",
            InstantiationException()
        )
        return RawConstantsModel.RawConstant(null, null, null, null)
    }

    private fun convertToObject(string: String?): RawConstantsModel.RawConstant? {
        val obj = Gson().fromJson(string, RawConstantsModel.RawConstant::class.java)
        return if (obj != null && obj is RawConstantsModel.RawConstant) {
            obj
        } else {
            null
        }
    }

    private suspend fun getConstantsFromApi(): String? {
        val constantsResponseAsync = royaleApiDataService.constantsAsync()

        try {
            val response = constantsResponseAsync.await()
            if (response.body() != null && response.isSuccessful) {
                var responseBodyString: String
                response.body()?.let { responseBody ->
                    responseBodyString = responseBody.string()
                    if (!responseBodyString.isEmpty()) {
                        return responseBodyString
                    }
                }
            }
        } catch (e: HttpException) {
            Log.e("RoyaleApiKit", "getConstants -> There was an HttpException error", e)
        } catch (e: Throwable) {
            Log.e("RoyaleApiKit", "getConstants -> There was a Throwable error", e)
        }

        return null
    }

    private fun writeConstantsToFile(constants: RawConstantsModel.RawConstant) {
        context.openFileOutput(constantsFilename, Context.MODE_PRIVATE).use { stream ->
            val json = Gson().toJson(constants, RawConstantsModel.RawConstant::class.java)
            stream.write(json.toByteArray())
        }
    }

    private fun writeConstantsToFile(string: String) {
        context.openFileOutput(constantsFilename, Context.MODE_PRIVATE).use { stream ->
            stream.write(string.toByteArray())
        }
    }

    @Throws(FileNotFoundException::class)
    private fun readConstantsFromFile(): RawConstantsModel.RawConstant? {
        val fromFile = context.openFileInput(constantsFilename)
        val txt = fromFile.bufferedReader(Charset.defaultCharset()).use { it.readText() }
        return if (txt.isEmpty()) {
            null
        } else {
            Gson().fromJson(
                txt,
                RawConstantsModel.RawConstant::class.java
            )
        }
    }
}