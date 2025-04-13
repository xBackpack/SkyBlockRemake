package me.xbackpack.skyblockremake

import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import me.xbackpack.skyblockremake.item.enum.SkyblockType
import me.xbackpack.skyblockremake.item.property.SkyblockItemAbility
import me.xbackpack.skyblockremake.item.property.SkyblockItemStat
import me.xbackpack.skyblockremake.util.buildComponent
import me.xbackpack.skyblockremake.util.createSkyblockWeapon
import me.xbackpack.skyblockremake.util.generateStatDescriptor
import me.xbackpack.skyblockremake.util.generateTimeDescriptor
import org.bukkit.Material
import kotlin.time.Duration.Companion.seconds

object SkyblockItemRegistry {
    fun registerItems() {
        createSkyblockWeapon("rogue_sword") {
            displayName = "Rogue Sword"
            material = Material.GOLDEN_SWORD
            rarity = SkyblockRarity.COMMON
            type = SkyblockType.SWORD
            reforgeable = true

            addStat(SkyblockItemStat(SkyblockStatType.DAMAGE, 20))

            addAbility(
                SkyblockItemAbility(
                    "Speed Boost",
                    buildComponent(
                        "<gray>Grants <1> for <2>.</gray>",
                        generateStatDescriptor(SkyblockStatType.SPEED, 200),
                        generateTimeDescriptor(30),
                    ),
                    50,
                    5.seconds,
                ) { player -> player.sendMessage("Clicked!") },
            )
        }
    }
}
