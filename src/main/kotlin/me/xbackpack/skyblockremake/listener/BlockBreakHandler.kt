package me.xbackpack.skyblockremake.listener

import me.xbackpack.skyblockremake.item.adapter.SkyblockAdapter
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockBreakHandler : Listener {
    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        event.isDropItems = false

        val block = event.block

        block.drops.forEach {
            val item = SkyblockAdapter.adaptItemStack(it)
            block.world.dropItemNaturally(block.location, item.buildItem())
        }
    }
}
