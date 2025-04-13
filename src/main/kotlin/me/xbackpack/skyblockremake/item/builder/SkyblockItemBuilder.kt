package me.xbackpack.skyblockremake.item.builder

import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.template.AbstractSkyblockItem
import net.kyori.adventure.text.Component
import org.bukkit.Material

class SkyblockItemBuilder(
    val idLower: String,
) {
    private lateinit var displayName: Component
    private lateinit var material: Material
    private lateinit var rarity: SkyblockRarity

    fun setDisplayName(displayName: Component) = apply { this.displayName = displayName }

    fun setMaterial(material: Material) = apply { this.material = material }

    fun setRarity(rarity: SkyblockRarity) = apply { this.rarity = rarity }

    fun build() = object : AbstractSkyblockItem(idLower, displayName, material, rarity) {}
}
