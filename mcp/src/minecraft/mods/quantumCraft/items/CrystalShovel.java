package mods.quantumCraft.items;

import mods.quantumCraft.core.QuantumCraftSettings;
import mods.quantumCraft.core.utils.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class CrystalShovel extends ItemSpade {

	public CrystalShovel(int i, EnumToolMaterial enumToolMaterial) {
		super(i, enumToolMaterial);

	}

	@Override
	public EnumRarity getRarity(ItemStack is) {
		if (!Utils.isGamma(is.itemID)) {
			return EnumRarity.common;
		} else {
			return EnumRarity.epic;
		}
	}

	@Override
	public boolean hasEffect(ItemStack itemStack) {
		return Utils.isGamma(itemStack.itemID);
	}

	@Override
	public boolean hitEntity(ItemStack item, EntityLiving target,
			EntityLiving player) {
		super.hitEntity(item, target, player);
		if (Utils.isGamma(item.itemID)) {
			target.addPotionEffect(new PotionEffect(Potion.wither.id,
					QuantumCraftSettings.witheringTimeout));
		}
		return true;
	}
}
