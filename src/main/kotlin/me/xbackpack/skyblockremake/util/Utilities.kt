package me.xbackpack.skyblockremake.util

import io.papermc.paper.datacomponent.item.ItemLore
import me.xbackpack.skyblockremake.SkyBlockRemake
import me.xbackpack.skyblockremake.item.builder.SkyblockItemBuilder
import me.xbackpack.skyblockremake.item.builder.SkyblockWeaponBuilder
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
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

// Lore Stuff
fun String.toComponent() = Component.text(this)

fun Long.toComponent() = Component.text(this)

fun buildComponent(
    miniMessage: String,
    vararg replacements: Component,
): Component {
    val msg = MiniMessage.miniMessage().deserialize(miniMessage)

    replacements.forEachIndexed { idx, replacement ->
        msg.replaceText { it.matchLiteral("<$idx>").replacement(replacement) }
    }

    return msg
}

fun generateDarkDescriptor(message: String) = buildComponent("<dark_gray>$message</dark_gray>")

fun generateStatDescriptor(
    stat: SkyblockStatType,
    amount: Int,
) = buildComponent("$amount${stat.symbol} ${stat.statName}").color(stat.colour)

fun generateTimeDescriptor(time: Int) = buildComponent("<green>${time}s</green>")

fun generateManaCostDescriptor(amount: Int) = buildComponent("<dark_gray>Mana Cost:</dark_gray> <dark_aqua>$amount</dark_aqua>")

fun generateCooldownDescriptor(time: Int) = buildComponent("<dark_gray>Cooldown:</dark_gray> <1>", generateTimeDescriptor(time))

fun generateReforgeableDescriptor() = generateDarkDescriptor("This item can be reforged!")

// Template Stuff
fun buildDisplayName(
    name: Component,
    rarity: SkyblockRarity,
) = name.color(rarity.colour)

fun addRarityToLore(
    lore: ItemLore.Builder,
    rarity: SkyblockRarity,
) {
    lore.addLine(buildComponent("<bold>$rarity</bold>").color(rarity.colour))
}

fun ItemLore.Builder.addSeparator() = addLine(Component.empty())

val idKey = NamespacedKey(SkyBlockRemake.instance, "id")

fun ItemStack.getSkyblockId() =
    if (!this.type.isAir && persistentDataContainer.has(idKey)) {
        persistentDataContainer.get(idKey, PersistentDataType.STRING)
    } else {
        null
    }
