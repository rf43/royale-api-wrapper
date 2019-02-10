package net.rf43.royaleapikit

import android.content.Context
import net.rf43.royaleapikit.consumer.ApiDataService
import net.rf43.royaleapikit.consumer.RawConstantsModel
import net.rf43.royaleapikit.extensions.*
import retrofit2.HttpException

class RoyaleConstants(private val context: Context, private val royaleApiDataService: ApiDataService) {

    private val royaleLog: Logger = Logger(RoyaleConstants::class.java.simpleName)

    // 1 days in milliseconds
    private val constantsRefreshRateInMillis = 1L * 24L * 60L * 60L * 1000L
    // Last updated time in millis
    private val lastRefreshInMillis = 0L

    private lateinit var royalApiKitConstants: RawConstantsModel.RawConstant


    suspend fun getConstants(): RawConstantsModel.RawConstant {
        // Check if constants are initialized and valid
        if (this::royalApiKitConstants.isInitialized && royalApiKitConstants.isValid()) {
            return royalApiKitConstants
        } else {
            // It's not initialized or it's not valid
            // Let's check to see if it's valid first.
            // We'll do this because if it's not valid then we need to hit the API and refresh whatever we
            // may currently have.
            if (this::royalApiKitConstants.isInitialized) {
                // It's initialized so that means it's not valid and we need to refresh from the API
                val apiConsts = buildConstantsFromApi()
                if (apiConsts.isValid()) {
                    // Now that we have valid consts, let's persist them so that we'll
                    // have them next time we need them
                    apiConsts.persist(context)
                    // Initialize royalApiKitConstants
                    royalApiKitConstants = apiConsts
                    // Now we can return them
                    return royalApiKitConstants
                } else {
                    // They're not valid for some reason.
                    royaleLog.e(
                        message = "ERROR: The constants from the API were not valid for some reason",
                        methodName = "getConstants",
                        throwable = IllegalStateException("apiConsts: $apiConsts.toString()")
                    )
                }
            } else {
                // it is not initialized
                // Try to build from file
                var consts = buildConstantsFromFile()
                // Are they valid?
                if (consts.isValid()) {
                    // Initialize royalApiKitConstants
                    royalApiKitConstants = consts
                    // Yeah, so return them
                    return royalApiKitConstants
                } else {
                    royaleLog.w(
                        message = "The constants from the filesystem were not valid. Attempting to build them from the API",
                        methodName = "getConstants"
                    )
                    // No! So, let's try building them from the API
                    consts = buildConstantsFromApi()
                    // Are they valid?
                    if (consts.isValid()) {
                        // They're valid, let's persist them so that they are
                        // ready to use next time
                        consts.persist(context)
                        // Initialize royalApiKitConstants
                        royalApiKitConstants = consts
                        // and now, let's return them
                        return royalApiKitConstants
                    } else {
                        royaleLog.e(
                            message = "ERROR: The constants from the API were not valid for some reason",
                            methodName = "getConstants",
                            throwable = IllegalStateException("consts: $consts.toString()")
                        )
                    }
                }
            }
        }

        // There is something irrecoverably wrong and we cannot create the constants
        // so, for now we'll just create an empty one and then we'll have an extension function
        // to be able to check to see if the object is valid (obj.isValid() will return false)
        royaleLog.e(
            message = "Unable to instantiate a new RawConstant from file or external API",
            methodName = "getConstants",
            throwable = InstantiationException()
        )

        // Initialize royalApiKitConstants with empty constants
        royalApiKitConstants = RawConstantsModel.RawConstant()

        return royalApiKitConstants
    }

    private fun buildConstantsFromFile(): RawConstantsModel.RawConstant {
        // Check to see if there is a file
        if (context.fileList().contains(RawConstantsModel.RawConstant().getPersistFilename())) {
            // Since there's a file, let's get the json as a string
            val jsonFromFile = getJsonFromFile<RawConstantsModel.RawConstant>(context)
            // Now we make sure it's not blank
            if (jsonFromFile.isNotBlank()) {
                // Create a new RawConstant
                return jsonFromFile.fromJson()
            } else {
                royaleLog.w(message = "The json from the file is blank!", methodName = "buildConstantsFromFile")
            }
        } else {
            royaleLog.w(message = "There is no file to read from", methodName = "buildConstantsFromFile")
        }

        return RawConstantsModel.RawConstant()
    }

    private suspend fun buildConstantsFromApi(): RawConstantsModel.RawConstant {
        val apiJson = getJsonAsStringFromApi()

        return if (apiJson.isNotBlank()) {
            apiJson.fromJson()
        } else {
            royaleLog.w(
                message = "Could not build the constants from the string returned from the API",
                methodName = "buildConstantsFromApi"
            )
            RawConstantsModel.RawConstant()
        }
    }

    private suspend fun getJsonAsStringFromApi(): String {
        val constantsResponseAsync = royaleApiDataService.constantsAsync()

        try {
            val response = constantsResponseAsync.await()
            if (response.body() != null && response.isSuccessful) {
                response.body()?.let { responseBody ->
                    return responseBody.string()
                }
            } else {
                royaleLog.w(
                    message = "response body is null or was not successful",
                    methodName = "getJsonAsStringFromApi"
                )
            }
        } catch (e: HttpException) {
            royaleLog.e(
                message = "There was an HttpException error",
                methodName = "getConstantsJsonFromApi",
                throwable = e
            )
        } catch (e: Throwable) {
            royaleLog.e(message = "There was a Throwable error", methodName = "getConstantsJsonFromApi", throwable = e)
        }

        return ""
    }
}