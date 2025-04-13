package me.xbackpack.skyblockremake.listener

import me.xbackpack.skyblockremake.SkyblockItemRegistry
import me.xbackpack.skyblockremake.util.getSkyblockId
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

class AbilityClickHandler : Listener {
    @EventHandler
    fun onClick(event: PlayerInteractEvent) {
        if (event.hand != EquipmentSlot.HAND) return

        if (event.action in listOf(Action.RIGHT_CLICK_BLOCK, Action.RIGHT_CLICK_AIR)) {
            val player = event.player

            val heldItem = player.inventory.itemInMainHand

            val skyblockId = heldItem.getSkyblockId() ?: return

            SkyblockItemRegistry.getById(skyblockId)?.let {
                it.abilities.forEach { ability ->
                    ability.use(player)
                }
            }
        }
    }
}
