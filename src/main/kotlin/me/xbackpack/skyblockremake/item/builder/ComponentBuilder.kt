package me.xbackpack.skyblockremake.item.builder

import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage

class ComponentBuilder(
    block: ComponentBuilder.() -> Unit,
) {
    private var result = Component.empty() as Component

    init {
        apply(block)
    }

    fun text(
        content: String,
        colour: NamedTextColor = NamedTextColor.WHITE,
        vararg decorations: TextDecoration,
    ) {
        result =
            result.append(
                MiniMessage
                    .miniMessage()
                    .deserialize(content)
                    .color(colour)
                    .decorate(*decorations),
            )
    }

    fun replace(
        literal: String,
        replacement: String,
    ) {
        result =
            result.replaceText {
                it.matchLiteral(literal).replacement(replacement)
            }
    }

    fun append(content: Component) {
        result = result.append(content)
    }

    fun getStat(
        stat: SkyblockStatType,
        amount: Int,
    ) = "<${stat.miniMessageColour}>$amount${stat.symbol} ${stat.statName}</${stat.miniMessageColour}"

    fun getTime(time: Int) = "<green>${time}s</green>"

    fun getManaCost(cost: Int) = "<dark_gray>Mana Cost:</dark_gray> <dark_aqua>$cost</dark_aqua>"

    fun getCooldown(time: Int) = "<dark_gray>Cooldown:</dark_gray> $time"

    fun newline() {
        result = result.appendNewline()
    }

    fun get() = result
}
