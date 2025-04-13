package me.xbackpack.skyblockremake.item.property

import me.xbackpack.skyblockremake.item.base.SkyblockProperty
import me.xbackpack.skyblockremake.item.builder.ComponentBuilder
import me.xbackpack.skyblockremake.item.enum.SkyblockStatType

data class SkyblockItemStat(
    val stat: SkyblockStatType,
    val value: Int,
) : SkyblockProperty {
    override fun convertToLoreDescriptor() =
        ComponentBuilder {
            text("<gray>${stat.statName}: <${stat.colour}>$value${stat.symbol}</${stat.colour}>")
        }.get()
}
