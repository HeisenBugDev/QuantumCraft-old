package sammko.quantumCraft.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import sammko.quantumCraft.core.OwnAchievement;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		
		if(item.itemID == QuantumCraftSettings.CrystalSwordID) {
			player.addStat(OwnAchievement.Danger, 1);
		}
		if(item.itemID == QuantumCraftSettings.CrystalPickaxeID) {
			player.addStat(OwnAchievement.Hurry, 1);
		}
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}
	

}
