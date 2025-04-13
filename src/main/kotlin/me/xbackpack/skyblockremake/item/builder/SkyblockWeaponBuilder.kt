package me.xbackpack.skyblockremake.item.builder

import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.enum.SkyblockType
import me.xbackpack.skyblockremake.item.property.SkyblockItemAbility
import me.xbackpack.skyblockremake.item.property.SkyblockItemStat
import me.xbackpack.skyblockremake.item.template.AbstractSkyblockWeapon
import net.kyori.adventure.text.Component
import org.bukkit.Material

class SkyblockWeaponBuilder(
    val idLower: String,
) {
    lateinit var displayName: String
    lateinit var material: Material
    lateinit var rarity: SkyblockRarity
    lateinit var type: SkyblockType
    var reforgeable = false
    private val stats = mutableSetOf<SkyblockItemStat>()
    private val abilities = mutableSetOf<SkyblockItemAbility>()

    fun addStat(stat: SkyblockItemStat) = apply { stats.add(stat) }

    fun addAbility(ability: SkyblockItemAbility) = apply { abilities.add(ability) }

    fun build() =
        object : AbstractSkyblockWeapon(idLower, Component.text(displayName), material, rarity, type, stats, abilities, reforgeable) {}
}
