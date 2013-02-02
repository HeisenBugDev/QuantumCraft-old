
package sammko.quantumCraft.machine; //Comments are awsome ^^

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityExtractor extends TileEntityMachine implements ISidedInventory {

	//TODO: finish this
	
	public TileEntityExtractor(World w, ForgeDirection rot) {
		super(w, rot, 5, "Extractor");
	}


}
