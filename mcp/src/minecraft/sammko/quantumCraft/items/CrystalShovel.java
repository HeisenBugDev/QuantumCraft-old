package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.core.utils.Utils;
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
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}
	
	@Override
    public EnumRarity getRarity(ItemStack is)
    {
        if ( Utils.isGamma(is.itemID) ) { return EnumRarity.common; } else { return EnumRarity.epic; }
    }
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLiving target,
			EntityLiving player) {
		if (item.itemID == QuantumCraftSettings.InfusedCrystalShovelID + 256) {
			target.addPotionEffect(new PotionEffect(Potion.wither.id, 20));
		}
		return true;
	}
}
