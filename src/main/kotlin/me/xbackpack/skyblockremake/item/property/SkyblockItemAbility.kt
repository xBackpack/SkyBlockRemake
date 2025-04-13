package me.xbackpack.skyblockremake.item.property

import me.xbackpack.skyblockremake.item.base.SkyblockProperty
import me.xbackpack.skyblockremake.item.builder.ComponentBuilder
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import kotlin.time.Duration
import kotlin.time.TimeMark

data class SkyblockItemAbility(
    val name: String,
    val message: String,
    val cost: Int,
    val cooldown: Duration,
    val function: (Player) -> Unit,
) : SkyblockProperty {
    private var lastUsed: TimeMark? = null

    override fun convertToLoreDescriptor() =
        ComponentBuilder {
            text("<gold>Ability: $name</gold> <yellow><bold>RIGHT CLICK</bold></yellow>")
            newline()
            text(message)
            newline()
            if (cost > 0) text(getManaCost(50))
            newline()
            if (cooldown.isPositive()) text(getCooldown(cooldown.inWholeSeconds.toInt()))
        }.get()

    fun use(player: Player) {
        lastUsed?.let {
            val timeElapsed = it.elapsedNow()
            if (timeElapsed < cooldown) {
                player.playSound(player.location, Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1.0F, 0.5F)
                val timeRemaining = (cooldown - timeElapsed).inWholeSeconds.toInt()
                player.sendMessage(
                    ComponentBuilder {
                        text("<red>This ability is on cooldown for <time>.</red>")
                        replace("<time>", "$timeRemaining")
                    }.get(),
                )
                return
            }
        }

        function(player)
    }
}
