package me.xbackpack.skyblockremake.item.enum

enum class SkyblockStatType(
    val statName: String,
    val symbol: Char,
    val colour: String,
) {
    DAMAGE("Damage", '❁', "red"),
    STRENGTH("Strength", '❁', "red"),
    HEALTH("Health", '❤', "red"),
    DEFENSE("Defense", '❈', "green"),
    SPEED("Speed", '✦', "white"),
    INTELLIGENCE("Intelligence", '✎', "aqua"),
    CRIT_CHANCE("Crit Chance", '☣', "blue"),
    CRIT_DAMAGE("Crit Damage", '☠', "blue"),
}
