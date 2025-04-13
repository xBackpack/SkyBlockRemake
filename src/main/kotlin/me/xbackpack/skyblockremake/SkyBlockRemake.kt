package me.xbackpack.skyblockremake

import me.xbackpack.skyblockremake.listener.AbilityClickHandler
import me.xbackpack.skyblockremake.listener.BlockBreakHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class SkyBlockRemake : JavaPlugin() {
    override fun onEnable() {
        instance = this

        registerListeners(
            AbilityClickHandler(),
            BlockBreakHandler(),
        )

        SkyblockItemRegistry.registerItems()
    }

    companion object {
        lateinit var instance: SkyBlockRemake
    }

    private fun registerListeners(vararg listeners: Listener) {
        listeners.forEach { server.pluginManager.registerEvents(it, this) }
    }
}
