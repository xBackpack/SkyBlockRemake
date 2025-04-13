package me.xbackpack.skyblockremake.util

import io.papermc.paper.datacomponent.item.ItemLore
import me.xbackpack.skyblockremake.SkyBlockRemake
import me.xbackpack.skyblockremake.item.builder.ComponentBuilder
import me.xbackpack.skyblockremake.item.builder.SkyblockItemBuilder
import me.xbackpack.skyblockremake.item.builder.SkyblockWeaponBuilder
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

// Making it look nicer

typealias SkyblockItemSettings = SkyblockItemBuilder.() -> Unit
typealias SkyblockWeaponSettings = SkyblockWeaponBuilder.() -> Unit

// Item Creation Stuff

fun createSkyblockItem(
    idLower: String,
    block: SkyblockItemSettings,
) = SkyblockItemBuilder(idLower).apply(block).build()

fun createSkyblockWeapon(
    idLower: String,
    block: SkyblockWeaponSettings,
) = SkyblockWeaponBuilder(idLower).apply(block).build()

// Item Stuff
fun buildDisplayName(
    name: Component,
    rarity: SkyblockRarity,
) = name.color(rarity.colour)

fun addRarityToLore(
    lore: ItemLore.Builder,
    rarity: SkyblockRarity,
) {
    lore.addLine(ComponentBuilder { text("$rarity", rarity.colour, TextDecoration.BOLD) }.get())
}

fun ItemLore.Builder.addSeparator() = addLine(Component.empty())

val idKey = NamespacedKey(SkyBlockRemake.instance, "id")

fun ItemStack.getSkyblockId() =
    if (!this.type.isAir && persistentDataContainer.has(idKey)) {
        persistentDataContainer.get(idKey, PersistentDataType.STRING)
    } else {
        null
    }
