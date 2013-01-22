package sammko.quantumCraft.machine;

import sammko.quantumCraft.machine.gui.GuiGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityGenerator extends TileEntityMachine implements ISidedInventory {


	public TileEntityGenerator(World w, int rot) {
		super(w, rot);
		// TODO Auto-generated constructor stub
	}

	ItemStack[] items = new ItemStack[5];
	

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return items[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		items[var1].stackSize -= var2;
		return items[var1];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return items[var1];
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		items[var1] = var2;
		
	}

	@Override
	public String getInvName() {
		return "Generator";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openChest() {
		
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStartInventorySide(ForgeDirection side) {
		if (side == side.UP) { return 0; }
		if (side == side.DOWN) { return 1; }
		if (side == side.SOUTH && rotation == 0) { return 3; }
		if (side == side.NORTH && rotation == 0) { return 4; }
		if (side == side.WEST && rotation == 1) { return 3; }
		if (side == side.EAST && rotation == 1) { return 4; }
		if (side == side.NORTH && rotation == 2) { return 3; }
		if (side == side.SOUTH && rotation == 2) { return 4; }
		if (side == side.EAST && rotation == 3) { return 3; }
		if (side == side.WEST && rotation == 3) { return 4; }
		else { return -1; }
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side) {
		if (side == side.UP) { return 2; }
		if (side == side.DOWN) { return 1; }
		if (side == side.SOUTH && rotation == 0) { return 1; }
		if (side == side.NORTH && rotation == 0) { return 1; }
		if (side == side.WEST && rotation == 1) { return 1; }
		if (side == side.EAST && rotation == 1) { return 1; }
		if (side == side.NORTH && rotation == 2) { return 1; }
		if (side == side.SOUTH && rotation == 2) { return 1; }
		if (side == side.EAST && rotation == 3) { return 1; }
		if (side == side.WEST && rotation == 3) { return 1; }
		else { return -1; }
	}

}
