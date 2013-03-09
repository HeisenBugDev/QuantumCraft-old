package sammko.quantumCraft.machine;

import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.QuantumCraftSettings;
import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityInfuser extends TileEntityMachine implements IInventory,
		ISidedInventory, IEnergySink {

	public int progress;

	public TileEntityInfuser(ForgeDirection rot) {
		super(rot, 5, "infuseor");
	}

	public TileEntityInfuser() {
		super(ForgeDirection.NORTH, 5, "infuseor");
	}

	private void init() {
		internalStorage = 16000;
		progress = 0;
	}

	public int gaugeProgressScaled(int scale) {
		return (progress * scale) / 16000;
	}

	public int gaugeFuelScaled(int scale) {
		int itemFuel = internalStorage;
		if (itemFuel == 0) {
			itemFuel = internalStorage;
			if (itemFuel == 0) {
				itemFuel = 1000;
			}
		}
		return (internalStorage * scale) / itemFuel;
	}

	public void updateEntity() {
		super.updateEntity();
		if (!this.isAddedToEnergyNet()) {
			MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
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

			if (internalStorage <= 16000 && this.caninfuse()) // Smelt stuff
			{
				++this.progress;

				if (this.progress == 16000) {
					this.progress = 0;
					this.InfuseItem();
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

	private boolean caninfuse() {
		if (this.inventory[0] == null) {
			return false;
		}
		if (this.inventory[1] == null) {
			return false;
		} else {
			if (inventory[0].itemID != Initializator.ItemCrystalAxe.itemID
					|| inventory[0].itemID != Initializator.ItemCrystalPickaxe.itemID
					|| inventory[0].itemID != Initializator.ItemCrystalSword.itemID
					|| inventory[0].itemID != Initializator.ItemCrystalShovel.itemID)
				return false;
			if (inventory[1].itemID == Initializator.ItemGammatroniumCrystal.itemID) {
				return true;
			}
			return false;
		}
	}

	public ItemStack getResult(ItemStack inp) {
		if (inp.itemID == Initializator.ItemCrystalAxe.itemID) {
			return new ItemStack(Initializator.ItemInfusedCrystalAxe, 1);
		}
		if (inp.itemID == Initializator.ItemCrystalPickaxe.itemID) {
			return new ItemStack(Initializator.ItemInfusedCrystalPickaxe, 1);
		}
		if (inp.itemID == Initializator.ItemCrystalShovel.itemID) {
			return new ItemStack(Initializator.ItemInfusedCrystalShovel, 1);
		}
		if (inp.itemID == Initializator.ItemCrystalSword.itemID) {
			return new ItemStack(Initializator.ItemInfusedCrystalSword, 1);
		}
		return null;

	}

	public void InfuseItem() {
		if (this.caninfuse()) {

			internalStorage += 16000;

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
