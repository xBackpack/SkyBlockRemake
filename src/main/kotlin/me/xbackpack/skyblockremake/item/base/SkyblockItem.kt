package me.xbackpack.skyblockremake.item.base

import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

interface SkyblockItem {
    val idLower: String
    val displayName: Component
    val material: Material
    val rarity: SkyblockRarity

    fun buildItem(): ItemStack
}
