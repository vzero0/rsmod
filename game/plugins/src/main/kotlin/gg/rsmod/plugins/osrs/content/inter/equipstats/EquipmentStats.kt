package gg.rsmod.plugins.osrs.content.inter.equipstats

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.osrs.api.BonusSlot
import gg.rsmod.plugins.osrs.api.helper.getBonus
import gg.rsmod.plugins.osrs.api.helper.setInterfaceText

/**
 * @author Tom <rspsmods@gmail.com>
 */
object EquipmentStats {

    const val INTERFACE_ID = 84
    const val TAB_INTERFACE_ID = 85

    private fun getBonusPercentage(p: Player, slot: BonusSlot): String {
        val bonus = p.getBonus(slot)
        return if (bonus < 0) bonus.toString() else "+$bonus"
    }

    fun sendBonuses(p: Player) {
        var undeadBonus = 0.0
        var slayerBonus = 0.0

        var index: Int

        index = 23
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Stab: ${getBonusPercentage(p, BonusSlot.ATTACK_STAB)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Slash: ${getBonusPercentage(p, BonusSlot.ATTACK_SLASH)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Crush: ${getBonusPercentage(p, BonusSlot.ATTACK_CRUSH)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Magic: ${getBonusPercentage(p, BonusSlot.ATTACK_MAGIC)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index, text = "Range: ${getBonusPercentage(p, BonusSlot.ATTACK_RANGED)}")

        index = 29
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Stab: ${getBonusPercentage(p, BonusSlot.DEFENCE_STAB)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Slash: ${getBonusPercentage(p, BonusSlot.DEFENCE_SLASH)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Crush: ${getBonusPercentage(p, BonusSlot.DEFENCE_CRUSH)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Range: ${getBonusPercentage(p, BonusSlot.DEFENCE_RANGED)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index, text = "Magic: ${getBonusPercentage(p, BonusSlot.DEFENCE_MAGIC)}")

        index = 35
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Melee strength: ${getBonusPercentage(p, BonusSlot.STRENGTH)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index++, text = "Ranged strength: ${getBonusPercentage(p, BonusSlot.RANGED_STRENGTH)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = index, text = "Magic damage: ${getBonusPercentage(p, BonusSlot.MAGIC_DAMAGE)}")

        val undead = if (undeadBonus == 0.0) "0" else String.format("%.2f", undeadBonus)
        val slayer = if (slayerBonus == 0.0) "0" else String.format("%.2f", slayerBonus)

        p.setInterfaceText(parent = INTERFACE_ID, child = 38, text = "Prayer: ${getBonusPercentage(p, BonusSlot.PRAYER)}")
        p.setInterfaceText(parent = INTERFACE_ID, child = 40, text = "Undead: $undead%")
        p.setInterfaceText(parent = INTERFACE_ID, child = 41, text = "Slayer: $slayer%")
    }
}