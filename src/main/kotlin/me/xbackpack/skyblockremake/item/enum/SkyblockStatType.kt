package me.xbackpack.skyblockremake.item.enum

import net.kyori.adventure.text.format.NamedTextColor

enum class SkyblockStatType(
    val statName: String,
    val symbol: Char,
    val colour: NamedTextColor,
    val miniMessageColour: String,
) {
    DAMAGE("Damage", '❁', NamedTextColor.RED, "<red>"),
    STRENGTH("Strength", '❁', NamedTextColor.RED, "<red>"),
    HEALTH("Health", '❤', NamedTextColor.RED, "<red>"),
    DEFENSE("Defense", '❈', NamedTextColor.GREEN, "<green>"),
    SPEED("Speed", '✦', NamedTextColor.WHITE, "<white>"),
    INTELLIGENCE("Intelligence", '✎', NamedTextColor.AQUA, "<aqua>"),
    CRIT_CHANCE("Crit Chance", '☣', NamedTextColor.BLUE, "<blue>"),
    CRIT_DAMAGE("Crit Damage", '☠', NamedTextColor.BLUE, "<blue>"),
}
