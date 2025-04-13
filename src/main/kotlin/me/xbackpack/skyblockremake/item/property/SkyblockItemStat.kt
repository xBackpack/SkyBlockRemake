package me.xbackpack.skyblockremake.item.property

import me.xbackpack.skyblockremake.item.base.SkyblockProperty
import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

data class SkyblockItemStat(
    val stat: SkyblockStatType,
    val value: Int,
) : SkyblockProperty {
    override fun convertToLoreDescriptor() =
        Component
            .text("${stat.statName}:", NamedTextColor.GRAY)
            .appendSpace()
            .append(Component.text("$value ${stat.symbol}", stat.colour))
}
