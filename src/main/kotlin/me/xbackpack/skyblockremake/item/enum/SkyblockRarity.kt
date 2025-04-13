package me.xbackpack.skyblockremake.item.enum

import net.kyori.adventure.text.format.NamedTextColor

enum class SkyblockRarity(
    val colour: NamedTextColor,
) {
    COMMON(NamedTextColor.WHITE),
    UNCOMMON(NamedTextColor.GREEN),
    RARE(NamedTextColor.BLUE),
    EPIC(NamedTextColor.DARK_PURPLE),
    LEGENDARY(NamedTextColor.GOLD),
    MYTHIC(NamedTextColor.LIGHT_PURPLE),
    DIVINE(NamedTextColor.AQUA),
    SPECIAL(NamedTextColor.RED),
    VERY_SPECIAL(NamedTextColor.DARK_RED),
}
