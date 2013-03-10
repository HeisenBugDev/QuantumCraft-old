package sammko.quantumCraft.items;

import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class CrystalAxe extends ItemAxe {

	public CrystalAxe(int i, EnumToolMaterial EnumToolMaterial) {
		super(i, EnumToolMaterial);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}

	@Override
	public boolean hitEntity(ItemStack item, EntityLiving target,
			EntityLiving player) {
		if (item.itemID == QuantumCraftSettings.InfusedCrystalAxeID + 256) {
			target.addPotionEffect(new PotionEffect(Potion.wither.id, 20));
		}
		return true;
	}

}
