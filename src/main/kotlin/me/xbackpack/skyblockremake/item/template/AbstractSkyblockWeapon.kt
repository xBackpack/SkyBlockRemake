package me.xbackpack.skyblockremake.item.template

import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.ItemLore
import me.xbackpack.skyblockremake.item.base.SkyblockWeapon
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.enum.SkyblockType
import me.xbackpack.skyblockremake.item.property.SkyblockItemAbility
import me.xbackpack.skyblockremake.item.property.SkyblockItemStat
import me.xbackpack.skyblockremake.util.addRarityToLore
import me.xbackpack.skyblockremake.util.addSeparator
import me.xbackpack.skyblockremake.util.appendReforgeableDescriptor
import me.xbackpack.skyblockremake.util.buildDisplayName
import me.xbackpack.skyblockremake.util.idKey
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

abstract class AbstractSkyblockWeapon(
    override val idLower: String,
    override val displayName: Component,
    override val material: Material,
    override val rarity: SkyblockRarity,
    override val type: SkyblockType,
    override val stats: MutableSet<SkyblockItemStat>,
    override val abilities: MutableSet<SkyblockItemAbility>,
    override val reforgeable: Boolean,
) : SkyblockWeapon {
    override fun buildItem(): ItemStack {
        val item = ItemStack(material)

        item.setData(DataComponentTypes.ITEM_NAME, buildDisplayName(displayName, rarity))

        val lore = ItemLore.lore()

        if (stats.isNotEmpty()) addStatsToLore(lore)

        if (abilities.isNotEmpty()) addAbilitiesToLore(lore)

        if (reforgeable) addReforgeableToLore(lore)

        addRarityToLore(lore, rarity)

        item.setData(DataComponentTypes.LORE, lore)

        item.editMeta {
            it.persistentDataContainer.set(idKey, PersistentDataType.STRING, idLower)
        }

        return item
    }

    private fun addStatsToLore(lore: ItemLore.Builder) {
        stats
            .map(SkyblockItemStat::convertToLoreDescriptor)
            .forEach(lore::addLine)

        lore.addSeparator()
    }

    private fun addAbilitiesToLore(lore: ItemLore.Builder) {
        abilities
            .map(SkyblockItemAbility::convertToLoreDescriptor)
            .forEach(lore::addLine)

        lore.addSeparator()
    }

    private fun addReforgeableToLore(lore: ItemLore.Builder) {
        lore.addLine(Component.empty().appendReforgeableDescriptor())
    }
}
