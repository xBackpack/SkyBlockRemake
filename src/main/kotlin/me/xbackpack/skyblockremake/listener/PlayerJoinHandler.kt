package me.xbackpack.skyblockremake.listener

import me.xbackpack.skyblockremake.SkyblockItemRegistry
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinHandler : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val sword = SkyblockItemRegistry.getById("rogue_sword") ?: return

        event.player.inventory.addItem(sword.buildItem())
    }
}
