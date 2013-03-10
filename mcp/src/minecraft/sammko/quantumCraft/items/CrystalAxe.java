package sammko.quantumCraft.items;

import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.core.utils.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumRarity;
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
    public EnumRarity getRarity(ItemStack is)
    {
        if ( !Utils.isGamma(is.itemID) ) { return EnumRarity.common; } else { return EnumRarity.epic; }
    }
	
	@Override
	public boolean hasEffect(ItemStack itemStack) {
		return Utils.isGamma(itemStack.itemID);
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLiving target,
			EntityLiving player) {
		if (Utils.isGamma(item.itemID)) {
			target.addPotionEffect(new PotionEffect(Potion.wither.id, 20));
		}
		return true;
	}

}
