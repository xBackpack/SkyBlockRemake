package me.xbackpack.skyblockremake

import me.xbackpack.skyblockremake.item.base.SkyblockWeapon
import me.xbackpack.skyblockremake.item.builder.ComponentBuilder
import me.xbackpack.skyblockremake.item.enum.SkyblockRarity
import me.xbackpack.skyblockremake.item.enum.SkyblockStatType
import me.xbackpack.skyblockremake.item.enum.SkyblockType
import me.xbackpack.skyblockremake.item.property.SkyblockItemAbility
import me.xbackpack.skyblockremake.item.property.SkyblockItemStat
import me.xbackpack.skyblockremake.util.createSkyblockWeapon
import net.kyori.adventure.text.format.NamedTextColor
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
                            text("Grants <stat> for <time>.", NamedTextColor.GRAY)
                            replace("<stat>", getStat(SkyblockStatType.SPEED, 200))
                            replace("<time>", getTime(5))
                        }.get(),
                        50,
                        5.seconds,
                    ) { player -> player.sendMessage("Clicked!") },
                )
            }
    }

    fun getById(id: String): SkyblockWeapon? = items[id]
}
