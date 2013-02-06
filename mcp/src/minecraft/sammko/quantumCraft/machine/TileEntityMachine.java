package sammko.quantumCraft.machine;

import ic2.api.Direction;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;


public class TileEntityMachine extends TileEntity implements ISidedInventory, IEnergySink {

	public int mtype = 0;
	public ForgeDirection rotation;
	public int[] tMap = new int[6];
	public ItemStack[] inventory;
	public String name;
	
	public TileEntityMachine(ForgeDirection rot, int slotCnt, String n) {
		rotation = rot;
		inventory = new ItemStack[slotCnt];
		name = n;
	}
	
	public void setMType()
	{
		mtype = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
	}
	
	@Override
	public ItemStack getStackInSlot(int slot)
    {
        return inventory[slot];
    }
    
    public boolean isStackInSlot(int slot)
    {
    	return inventory[slot] != null;
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public int getInventoryStackLimit()
    {
    	return 64;
    }

    public boolean canDropInventorySlot(int slot)
    {
    	return true;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack)
    {
        inventory[slot] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

	@Override
	public ItemStack decrStackSize(int slot, int quantity)
    {
        if (inventory[slot] != null)
        {
            if (inventory[slot].stackSize <= quantity)
            {
                ItemStack stack = inventory[slot];
                inventory[slot] = null;
                return stack;
            }
            ItemStack split = inventory[slot].splitStack(quantity);
            if (inventory[slot].stackSize == 0)
            {
                inventory[slot] = null;
            }
            return split;
        }
        else
        {
            return null;
        }
    }

	/* Supporting methods */
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
            return false;
        
        else
            return entityplayer.getDistance((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }
	/* NBT */
	@Override
    public void readFromNBT(NBTTagCompound tags)
    {
        super.readFromNBT(tags);
        NBTTagList nbttaglist = tags.getTagList("Items");
        inventory = new ItemStack[getSizeInventory()];
        for (int iter = 0; iter < nbttaglist.tagCount(); iter++)
        {
            NBTTagCompound tagList = (NBTTagCompound)nbttaglist.tagAt(iter);
            byte slotID = tagList.getByte("Slot");
            if (slotID >= 0 && slotID < inventory.length)
            {
                inventory[slotID] = ItemStack.loadItemStackFromNBT(tagList);
            }
        }
    }

	@Override
    public void writeToNBT(NBTTagCompound tags)
    {
        super.writeToNBT(tags);
        NBTTagList nbttaglist = new NBTTagList();
        for (int iter = 0; iter < inventory.length; iter++)
        {
            if (inventory[iter] != null)
            {
                NBTTagCompound tagList = new NBTTagCompound();
                tagList.setByte("Slot", (byte)iter);
                inventory[iter].writeToNBT(tagList);
                nbttaglist.appendTag(tagList);
            }
        }

        tags.setTag("Items", nbttaglist);
    }
    
	/* I dont think i will ever use this */
	public ItemStack getStackInSlotOnClosing (int slot) { return null; }
	public void openChest () {}
	public void closeChest () {}

	@Override
	public String getInvName() {
		return name;
	}

	@Override
	public int getStartInventorySide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return 0;
	}

	//IC2 PWR stuffs
	
	int IC2PWR_capacitor = 0;
	int IC2PWR_capacitorSize = 0;
	int IC2PWR_maxInput = 0;
	int IC2PWR_free = 0;
	boolean IC2PWR_wantPwr = false;	
	boolean IC2PWR_isPwrUser = false;
	boolean IC2PWR_isInENet = false;
	
	public void initIC2power(int capSize, int maxPacketSize)
	{
		this.IC2PWR_capacitorSize = capSize;
		this.IC2PWR_maxInput = maxPacketSize;
		this.IC2PWR_isPwrUser = true;
		this.IC2PWR_isInENet = true; //Hmm?
	}
	
	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, Direction direction) {
		return true;
	}

	@Override
	public boolean isAddedToEnergyNet() {
		return this.IC2PWR_isInENet;
	}

	@Override
	public int demandsEnergy() {
		return this.IC2PWR_free;
	}

	public int freeSpace() {
		return this.IC2PWR_free;
	}
	
	public void addEnergy(float amount) {
		IC2PWR_capacitor += amount;
		if (IC2PWR_capacitor > IC2PWR_capacitorSize) {
			IC2PWR_capacitor = IC2PWR_capacitorSize;
		}
		if (IC2PWR_capacitor == IC2PWR_capacitorSize)
			IC2PWR_wantPwr = false;
	}
	
	@Override
	public int injectEnergy(Direction directionFrom, int amount) {
		int addAmount = Math.min(amount, freeSpace());
		if (freeSpace() > 0 && addAmount == 0) {
			addAmount = 1;
		}
		addEnergy(addAmount);
		if (addAmount == 0 && directionFrom != null) {
			IC2PWR_capacitor += amount;
			return 0;
		}
		return amount - addAmount;
	}

	@Override
	public int getMaxSafeInput() {
		return this.IC2PWR_maxInput;
	}
	
	public int useUpEnergy(int amount) {
		if (IC2PWR_capacitor >= amount) { IC2PWR_capacitor -= amount; return amount; }
		if (IC2PWR_capacitor < amount) { IC2PWR_capacitor = 0; return IC2PWR_capacitor; }
		return 0;
	}

}
