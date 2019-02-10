package net.rf43.royaleapikit_example.player

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.rf43.royaleapikit.Logger
import net.rf43.royaleapikit.provider.PlayerModel
import net.rf43.royaleapikit_example.R
import net.rf43.royaleapikit_example.common.BaseActivity
import kotlin.math.log

class ActivityPlayer : BaseActivity() {

    private val logger = Logger(ActivityPlayer::class.java.simpleName)

    private lateinit var playerLoadingGroup: Group
    private lateinit var playerLoadedUiGroup: Group
    private lateinit var playerName: TextView
    private lateinit var playerTag: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_player)

        playerLoadingGroup = findViewById(R.id.player_loading_group)
        playerLoadingGroup.visibility = View.VISIBLE

        playerLoadedUiGroup = findViewById(R.id.player_loaded_ui_group)
        playerLoadedUiGroup.visibility = View.GONE

        playerName = findViewById(R.id.player_name)
        playerTag = findViewById(R.id.player_tag)

        GlobalScope.launch(Dispatchers.Main) {
            initPlayerLayout(royaleApiKit.getPlayer("POU9QYPYU"))
            playerLoadingGroup.visibility = View.GONE
            playerLoadedUiGroup.visibility = View.VISIBLE
        }
    }

    private fun initPlayerLayout(player: PlayerModel.Player) {
        logger.w(methodName = "initPlayerLayout", message = "initializing player...")
        logger.i(methodName = "initPlayerLayout", message = player.toString())

        playerName.text = player.name.takeIf { it.isNotBlank() } ?: "UNKNOWN"
        playerTag.text = player.tag.takeIf { it.isNotBlank() } ?: "UNKNOWN"
    }
}