package me.xbackpack.skyblockremake.item.builder

import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage

class ComponentBuilder(
    block: ComponentBuilder.() -> Unit,
) {
    private var result = StringBuilder()

    init {
        apply(block)
    }

    fun text(content: String) {
        result = result.append(content)
    }

    fun replace(
        literal: String,
        replacement: String,
    ) {
        result = StringBuilder(result.replace(Regex.fromLiteral(literal), replacement))
    }

    fun getStat(
        stat: SkyblockStatType,
        amount: Int,
    ) = "<${stat.colour}>$amount${stat.symbol} ${stat.statName}</${stat.colour}>"

    fun getTime(time: Int) = "<green>${time}s</green>"

    fun getManaCost(cost: Int) = "<dark_gray>Mana Cost:</dark_gray> <dark_aqua>$cost</dark_aqua>"

    fun getCooldown(time: Int) = "<dark_gray>Cooldown:</dark_gray> ${getTime(time)}"

    fun newline() {
        text("<newline>")
    }

    fun getRaw() = String(result)

    fun get() =
        MiniMessage
            .miniMessage()
            .deserialize(getRaw())
            .decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE)
}
