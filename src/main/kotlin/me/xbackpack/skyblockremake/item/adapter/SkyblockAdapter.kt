package me.xbackpack.skyblockremake.item.adapter

import io.papermc.paper.datacomponent.DataComponentTypes
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.util.createSkyblockItem
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack

object SkyblockAdapter {
    fun adaptItemStack(itemStack: ItemStack) =
        createSkyblockItem(itemStack.type.key.key) {
            setDisplayName(itemStack.getData(DataComponentTypes.ITEM_NAME) ?: Component.text("null"))
            setMaterial(itemStack.type)
            setRarity(SkyblockRarity.COMMON)
        }
}
