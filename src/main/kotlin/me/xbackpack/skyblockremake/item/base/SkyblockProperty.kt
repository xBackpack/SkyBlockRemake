package me.xbackpack.skyblockremake.item.base

import net.kyori.adventure.text.Component

interface SkyblockProperty {
    fun convertToLoreDescriptor(): Component
}
