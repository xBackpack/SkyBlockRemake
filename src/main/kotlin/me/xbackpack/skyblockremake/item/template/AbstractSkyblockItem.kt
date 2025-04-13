package me.xbackpack.skyblockremake.item.template

import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.ItemLore
import me.xbackpack.skyblockremake.item.base.SkyblockItem
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.util.addRarityToLore
import me.xbackpack.skyblockremake.util.buildDisplayName
import me.xbackpack.skyblockremake.util.idKey
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

abstract class AbstractSkyblockItem(
    override val idLower: String,
    override val displayName: Component,
    override val material: Material,
    override val rarity: SkyblockRarity,
) : SkyblockItem {
    override fun buildItem(): ItemStack {
        val item = ItemStack(material)

        item.setData(DataComponentTypes.ITEM_NAME, buildDisplayName(displayName, rarity))

        val lore = ItemLore.lore()

        addRarityToLore(lore, rarity)

        item.setData(DataComponentTypes.LORE, lore)

        item.editMeta {
            it.persistentDataContainer.set(idKey, PersistentDataType.STRING, idLower)
        }

        return item
    }
}
