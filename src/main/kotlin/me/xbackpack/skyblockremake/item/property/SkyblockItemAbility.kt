package me.xbackpack.skyblockremake.item.property

import me.xbackpack.skyblockremake.item.base.SkyblockProperty
import me.xbackpack.skyblockremake.util.buildComponent
import me.xbackpack.skyblockremake.util.generateCooldownDescriptor
import me.xbackpack.skyblockremake.util.generateManaCostDescriptor
import me.xbackpack.skyblockremake.util.toComponent
import net.kyori.adventure.text.Component
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import kotlin.time.Duration
import kotlin.time.TimeMark

data class SkyblockItemAbility(
    val name: String,
    val message: Component,
    val cost: Int,
    val cooldown: Duration,
    val function: (Player) -> Unit,
) : SkyblockProperty {
    private var lastUsed: TimeMark? = null

    override fun convertToLoreDescriptor() =
        buildComponent(
            """
            <gold>Ability: $name</gold> <yellow><bold>RIGHT CLICK</bold></yellow><newline>
            $message<newline>
            <1>
            <2><newline>
            """.trimIndent(),
            if (cost > 0) generateManaCostDescriptor(50).appendNewline() else Component.empty(),
            if (cooldown.isPositive()) generateCooldownDescriptor(cooldown.inWholeSeconds.toInt()) else Component.empty(),
        )

    fun use(player: Player) {
        lastUsed?.let {
            val timeElapsed = it.elapsedNow()
            if (timeElapsed < cooldown) {
                player.playSound(player.location, Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1.0F, 0.5F)
                val timeRemaining = cooldown - timeElapsed
                player.sendMessage(
                    buildComponent("<red>This ability is on cooldown for <1>s.</red>", timeRemaining.inWholeSeconds.toComponent()),
                )
                return
            }
        }

        function(player)
    }
}
