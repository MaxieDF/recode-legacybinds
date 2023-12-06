package io.github.homchom.recode.hypercube

import io.github.homchom.recode.event.trial.detector
import io.github.homchom.recode.event.trial.trial
import io.github.homchom.recode.hypercube.message.ActiveBoosterInfo
import io.github.homchom.recode.hypercube.message.StateMessages
import io.github.homchom.recode.hypercube.state.Node
import io.github.homchom.recode.hypercube.state.ipMatchesDF
import io.github.homchom.recode.hypercube.state.isOnDF
import io.github.homchom.recode.mc
import io.github.homchom.recode.multiplayer.DisconnectFromServerEvent
import io.github.homchom.recode.multiplayer.JoinServerEvent
import io.github.homchom.recode.multiplayer.ReceiveChatMessageEvent
import io.github.homchom.recode.multiplayer.username
import io.github.homchom.recode.ui.matchEntireUnstyled
import io.github.homchom.recode.util.Case
import io.github.homchom.recode.util.regex.regex
import kotlinx.coroutines.flow.map

private val patchRegex = regex {
    str("Current patch: ")
    val patch by any.oneOrMore()
    str(". See the patch notes with /patch!")
}

val JoinDFDetector = detector("DF join",
    trial(JoinServerEvent, Unit) { _, _ ->
        requireFalse(isOnDF) // if already on DF, this is a node switch and should not be tested
        requireTrue(mc.currentServer.ipMatchesDF)

        val messages = ReceiveChatMessageEvent.add()
        val tipMessage = ActiveBoosterInfo.detect(null).map(::Case).addOptional()

        val disconnect = DisconnectFromServerEvent.add()
        suspending {
            failOn(disconnect)

            val patch = +test(messages, unlimited) { (text) ->
                patchRegex.matchEntireUnstyled(text)?.groupValues?.get(1)
            }

            val locateMessage = StateMessages.Locate.request(mc.player!!.username, true)

            val canTip = tipMessage.any { (message) -> message?.canTip ?: false }
            JoinDFInfo(locateMessage.state.node, patch, canTip)
        }
    })

data class JoinDFInfo(val node: Node, val patch: String, val canTip: Boolean)