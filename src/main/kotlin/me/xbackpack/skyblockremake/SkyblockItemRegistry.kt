package me.xbackpack.skyblockremake

import me.xbackpack.skyblockremake.item.base.SkyblockWeapon
import me.xbackpack.skyblockremake.item.builder.ComponentBuilder
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import me.xbackpack.skyblockremake.item.enum.SkyblockType
import me.xbackpack.skyblockremake.item.property.SkyblockItemAbility
import me.xbackpack.skyblockremake.item.property.SkyblockItemStat
import me.xbackpack.skyblockremake.util.createSkyblockWeapon
import org.bukkit.Material
import kotlin.time.Duration.Companion.seconds

object SkyblockItemRegistry {
    private val items = mutableMapOf<String, SkyblockWeapon>()

    fun registerItems() {
        items["rogue_sword"] =
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
                        ComponentBuilder {
                            text("<gray>Grants <stat> for <time>.</gray>")
                            replace("<stat>", getStat(SkyblockStatType.SPEED, 200))
                            replace("<time>", getTime(5))
                        }.getRaw(),
                        50,
                        5.seconds,
                    ) { player ->
                        player.walkSpeed += 100

                        SkyBlockRemake.scheduler.runTaskLater(SkyBlockRemake.instance, Runnable { player.walkSpeed -= 100 }, 30 * 20)
                    },
                )
            }
    }

    fun getById(id: String): SkyblockWeapon? = items[id]
}
