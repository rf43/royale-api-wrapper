package net.rf43.royaleapikit

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import net.rf43.royaleapikit.consumer.ApiDataService
import net.rf43.royaleapikit.consumer.RawConstantsModel
import net.rf43.royaleapikit.extensions.isValid
import net.rf43.royaleapikit.extensions.persist
import retrofit2.HttpException
import java.io.FileNotFoundException
import java.nio.charset.Charset

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
                return generateConstantsFromFile()
            } else {
                // Get the string from the api...
                val stringFromApi = getConstantsFromApi()
                if (stringFromApi != null && stringFromApi.isNotEmpty()) {
                    // There is no file, let's create one
                    Log.d("RoyaleApiKit", "There is no file, create one... [01]")
                    createAndWriteJsonToFile(stringFromApi)
                    val rawConsts = convertStringToRawConstant(stringFromApi)
                    if (rawConsts.isValid()) {
                        return rawConsts!!
                    } else {
                        // rawConsts isn't valid for some reason...
                        Log.w("RoyaleApiKit", "rawConsts isn't valid for some reason... [01]")
                    }
                } else {
                    // Something is wrong with the string
                    Log.w("RoyaleApiKit", "Something is wrong with the string... [01]")
                }
            }
        }

        // There is something irrecoverably wrong and we cannot create the constants
        // so, for now we'll just create an empty one and then we'll have an extension function
        // to be able to check to see if the object is valid (obj.isValid() will return false)
        Log.e(
            "RoyaleApiKit",
            "getConstants => Unable to instantiate a new RawConstant from file or external API 03",
            InstantiationException()
        )
        return RawConstantsModel.RawConstant(null, null, null, null)
    }

    private suspend fun createAndWriteJsonToFile(jsonString: String?) {
        if (jsonString != null && jsonString.isNotEmpty()) {

        }
    }

    private suspend fun generateConstantsFromFile(): RawConstantsModel.RawConstant {
        // There's a file, let's try to read it
        val constsFromFile = readConstantsFromFile()
        if (constsFromFile != null && constsFromFile.isNotEmpty()) {
            Log.i("RoyaleApiKit", "Constants from the file system ARE valid! 01")
            val obj = convertStringToRawConstant(constsFromFile)
            if (obj.isValid()) {
                return obj!!
            }
        } else {
            Log.w("RoyaleApiKit", "Constants from the file system ARE NOT valid! 01")
            Log.w("RoyaleApiKit", "Attempting to obtain them via the API...")
            // Try to get them from the API
            val apiString = getConstantsFromApi()
            if (apiString != null && apiString.isNotEmpty()) {
                val constsFromApi = convertStringToRawConstant(apiString)
                if (constsFromApi.isValid()) {
                    Log.i("RoyaleApiKit", "Constants from the API are valid! 01")
                    constsFromApi.persist(context)
                    return constsFromApi!!
                } else {
                    // There's a problem...
                    Log.w("RoyaleApiKit", "Constants from the API ARE NOT valid! 01")
                    Log.e(
                        "RoyaleApiKit",
                        "There was a problem obtaining the API constants from both the API and file system 01"
                    )
                }
            } else {
                // There's a problem...
                Log.w("RoyaleApiKit", "Constants from the API ARE NOT valid! 01")
                Log.e(
                    "RoyaleApiKit",
                    "There was a problem obtaining the string from the API"
                )
                Log.w("RoyaleApiKit", "apiString is null => ${apiString == null}")
                if (apiString != null) {
                    Log.w("RoyaleApiKit", "apiString isNotEmpty => ${apiString.isNotEmpty()}")
                }
            }
        }

        return RawConstantsModel.RawConstant(null, null, null, null)
    }

    private fun convertStringToRawConstant(string: String?): RawConstantsModel.RawConstant? {
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
                    if (responseBodyString.isNotEmpty()) {
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

    @Throws(FileNotFoundException::class)
    private fun readConstantsFromFile(): String? {
        val fromFile = context.openFileInput(constantsFilename)
        val txt = fromFile.bufferedReader(Charset.defaultCharset()).use { it.readText() }
        return if (txt.isEmpty()) {
            null
        } else {
            txt
        }
    }
}