package me.xbackpack.skyblockremake.item.enum

import net.kyori.adventure.text.format.NamedTextColor

enum class SkyblockStatType(
    val statName: String,
    val symbol: Char,
    val colour: NamedTextColor,
) {
    DAMAGE("Damage", '❁', NamedTextColor.RED),
    STRENGTH("Strength", '❁', NamedTextColor.RED),
    HEALTH("Health", '❤', NamedTextColor.RED),
    DEFENSE("Defense", '❈', NamedTextColor.GREEN),
    SPEED("Speed", '✦', NamedTextColor.WHITE),
    INTELLIGENCE("Intelligence", '✎', NamedTextColor.AQUA),
    CRIT_CHANCE("Crit Chance", '☣', NamedTextColor.BLUE),
    CRIT_DAMAGE("Crit Damage", '☠', NamedTextColor.BLUE),
}
