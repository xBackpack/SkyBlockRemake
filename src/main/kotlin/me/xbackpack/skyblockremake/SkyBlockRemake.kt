package me.xbackpack.skyblockremake

import me.xbackpack.skyblockremake.listener.AbilityClickHandler
import me.xbackpack.skyblockremake.listener.BlockBreakHandler
import me.xbackpack.skyblockremake.listener.PlayerJoinHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class SkyBlockRemake : JavaPlugin() {
    override fun onEnable() {
        instance = this
        scheduler = server.scheduler

        registerListeners(
            AbilityClickHandler(),
            BlockBreakHandler(),
            PlayerJoinHandler(),
        )

        SkyblockItemRegistry.registerItems()
    }

    companion object {
        lateinit var instance: SkyBlockRemake
        lateinit var scheduler: BukkitScheduler
    }

    private fun registerListeners(vararg listeners: Listener) {
        listeners.forEach { server.pluginManager.registerEvents(it, this) }
    }
}
