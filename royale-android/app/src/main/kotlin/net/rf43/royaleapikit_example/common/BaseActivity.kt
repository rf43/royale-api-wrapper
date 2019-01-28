package net.rf43.royaleapikit_example.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.rf43.royaleapikit_example.BuildConfig
import net.rf43.royaleapikit.RoyaleApiKit

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    protected lateinit var royaleApiKit: RoyaleApiKit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        royaleApiKit = RoyaleApiKit(this, BuildConfig.developerKey)
    }
}