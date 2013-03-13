package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.core.utils.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class CrystalSword extends ItemSword{
	private int weaponDamage;

	public CrystalSword(int i, EnumToolMaterial enumToolMaterial){
		super(i, enumToolMaterial);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
		if (Utils.isGamma(i)) { this.weaponDamage = 2 + enumToolMaterial.getDamageVsEntity(); }
		else { this.weaponDamage = 1 + enumToolMaterial.getDamageVsEntity(); }
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
		super.hitEntity(item, target, player);
		if (Utils.isGamma(item.itemID)) {
			target.addPotionEffect(new PotionEffect(Potion.wither.id, QuantumCraftSettings.witheringTimeout, 1));
		}
		return true;
	}
	
}