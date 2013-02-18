package sammko.quantumCraft.machine;

import sammko.quantumCraft.items.ItemInitializator;
import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityInfuser extends TileEntityMachine implements IInventory,
		ISidedInventory, IEnergySource {

	public int progress;

	public TileEntityInfuser(ForgeDirection rot) {
		super(rot, 5, "Reactor");
	}

	public TileEntityInfuser() {
		super(ForgeDirection.NORTH, 5, "Reactor");
	}

	private void init() {
		internalStorage = 0;
		progress = 0;
	}

	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		return true;
	}

	@Override
	public int getMaxEnergyOutput() {
		return Integer.MAX_VALUE;
	}

	public void updateEntity() {
		super.updateEntity();
		if (!this.isAddedToEnergyNet()) {
			MinecraftForge.EVENT_BUS.post(new EnergyTileSourceEvent(this, internalStorage));
			this.addedToEnergyNet = true;
		}

		boolean gf = this.internalStorage > 0;
		boolean nu = false;
		if (internalStorage > 0) {

		}
		if (!this.worldObj.isRemote) {
			if (inventory[1] != null && inventory[0] != null) // Use
			// up
			// a
			// fuel
			// item
			{

				if (this.internalStorage < 0) // If we got fuel get rid of the
												// item
				{
					nu = true;

					if (this.inventory[2] != null) {
						--this.inventory[2].stackSize;

						if (this.inventory[2].stackSize == 0) {
							this.inventory[2] = this.inventory[2].getItem()
									.getContainerItemStack(inventory[2]);
						}
					}
				}
			}

			if (internalStorage <= 16000 && this.canReact()) // Smelt stuff
			{
				++this.progress;

				if (this.progress == 20) {
					this.progress = 0;
					this.ReactItem();
					nu = true;
				}
			} else {
				this.progress = 0;
			}

			if (gf != this.internalStorage > 0) {
				nu = true;
			}
		}

		if (nu) {
			this.onInventoryChanged();
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		internalStorage = par1nbtTagCompound.getInteger("powerLevel");
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("powerLevel", internalStorage);
	}

	private boolean canReact() {
		if (this.inventory[0] == null) {
			return false;
		}
		if (this.inventory[1] == null) {
			return false;
		} else {
			if (inventory[0].itemID != ic2.api.Items.getItem("waterCell").itemID)
				return false;
			if (inventory[1].itemID == ItemInitializator.ItemIngotPlutonium.itemID) {
				return true;
			}
			return false;
		}
	}

	public ItemStack getResult(ItemStack inp) {
		return new ItemStack(ItemInitializator.ItemEmptyEnergyPacket, 1);

	}

	public void ReactItem() {
		if (this.canReact()) {

			internalStorage += 100;

			ItemStack var1 = this.getResult(this.inventory[0]);

			if (this.inventory[4] == null) {
				this.inventory[4] = var1.copy();
			} else if (this.inventory[4].isItemEqual(var1)) {
				inventory[4].stackSize += var1.stackSize;
			}
			--this.inventory[0].stackSize;

			if (this.inventory[0].stackSize <= 0) {
				this.inventory[0] = null;
			}

			--this.inventory[1].stackSize;

			if (this.inventory[1].stackSize <= 0) {
				this.inventory[1] = null;
			}
		}
	}

	public int getChargeState() {
		return internalStorage * 100 / MAX_STORAGE;
	}
}
