package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
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
		this.weaponDamage = 4 + enumToolMaterial.getDamageVsEntity();
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLiving target,
			EntityLiving player) {
		if (item.itemID == QuantumCraftSettings.InfusedCrystalSwordID + 256) {
			target.addPotionEffect(new PotionEffect(Potion.wither.id, 20));
		}
		return true;
	}
	
}
