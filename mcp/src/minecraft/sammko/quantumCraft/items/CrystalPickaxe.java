package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CrystalPickaxe extends ItemPickaxe{

	public CrystalPickaxe(int i, EnumToolMaterial enumToolMaterial){
		super(i, enumToolMaterial);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}
	
	
	
}
