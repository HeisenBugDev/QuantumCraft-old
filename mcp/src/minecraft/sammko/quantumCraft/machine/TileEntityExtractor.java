
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
	
	public TileEntityExtractor(World w, int rot) {
		super(w, rot);
		inv = new ItemStack[9];
	}

	private ItemStack[] inv;
	

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inv[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		inv[var1].stackSize -= var2;
		return inv[var1];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return inv[var1];
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		
        if (var2 != null && var2.stackSize > getInventoryStackLimit()) {
            var2.stackSize = getInventoryStackLimit(); }
            else inv[var1] = var2;
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
	
	@Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
           
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < inv.length) {
                            inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);
                           
            NBTTagList itemList = new NBTTagList();
            for (int i = 0; i < inv.length; i++) {
                    ItemStack stack = inv[i];
                    if (stack != null) {
                            NBTTagCompound tag = new NBTTagCompound();
                            tag.setByte("Slot", (byte) i);
                            stack.writeToNBT(tag);
                            itemList.appendTag(tag);
                    }
            }
            tagCompound.setTag("Inventory", itemList);
    }


}
