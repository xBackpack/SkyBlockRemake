package me.xbackpack.skyblockremake.item.base

import me.xbackpack.skyblockremake.item.enum.SkyblockType
import me.xbackpack.skyblockremake.item.property.SkyblockItemAbility
import me.xbackpack.skyblockremake.item.property.SkyblockItemStat

interface SkyblockWeapon : SkyblockItem {
    val type: SkyblockType
    val stats: Set<SkyblockItemStat>
    val abilities: Set<SkyblockItemAbility>
    val reforgeable: Boolean
}
