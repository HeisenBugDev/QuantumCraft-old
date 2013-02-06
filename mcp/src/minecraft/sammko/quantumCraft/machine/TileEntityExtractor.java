package sammko.quantumCraft.machine; //Comments are awsome ^^

import ic2.api.Direction;
import ic2.api.energy.tile.IEnergySink;
import sammko.quantumCraft.items.ItemInitializator;
import sammko.quantumCraft.resources.NBTTags;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityExtractor extends TileEntityMachine implements
		IInventory, ISidedInventory {

	// TODO: finish this

	public int fuel;
	public int itemFuel;
	public int progress;

	public TileEntityExtractor(ForgeDirection rot) {
		super(rot, 5, "Extractor");
	}

	public TileEntityExtractor() {
		super(ForgeDirection.NORTH, 5, "Extractor");
	}

	private void init() {
		fuel = 0;
		progress = 0;
	}

	public void updateEntity() {
		boolean gf = this.fuel > 0;
		boolean nu = false;

		if (!this.worldObj.isRemote) {
			if (inventory[2] != null
					&& fuel <= 16000 - getItemBurnTime(this.inventory[2]))
			{
				this.itemFuel = getItemBurnTime(this.inventory[2]);
				this.fuel += itemFuel;

				if (this.fuel > 0) // If we got fuel get rid of the item
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

			if (fuel >= 100 && this.canExtract()) // Do stuff
			{
				++this.progress;

				if (this.progress == 20) {
					this.progress = 0;
					this.extractItem();
					nu = true;
				}
			} else {
				this.progress = 0;
			}

			if (gf != this.fuel > 0) {
				nu = true;
			}
		}

		if (nu) {
			this.onInventoryChanged();
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tags) {
		super.readFromNBT(tags);
		fuel = tags.getInteger("MFuel");
	}

	@Override
	public void writeToNBT(NBTTagCompound tags) {
		super.writeToNBT(tags);
		tags.setInteger(NBTTags.MachineFuelLevel, fuel);
	}

	private boolean canExtract() {
		if (this.inventory[0] == null) {
			return false;
		}
		if (this.inventory[1] == null) {
			return false;
		} else {
			if (inventory[1].itemID != ItemInitializator.ItemEmptyEnergyPacket.itemID)
				return false;
			if (inventory[0].itemID == ItemInitializator.ItemPositroniumCrystal.itemID
					|| inventory[0].itemID == ItemInitializator.ItemRadiumCrystal.itemID
					|| inventory[0].itemID == ItemInitializator.ItemGammatroniumCrystal.itemID
					|| inventory[0].itemID == ItemInitializator.ItemNeutriniumCrystal.itemID) {
				return true;
			}
			return false;
		}
	}

	public ItemStack getResult(ItemStack inp) {
		if (inp.itemID == ItemInitializator.ItemPositroniumCrystal.itemID) {
			return new ItemStack(ItemInitializator.ItemPositroniumEnergyPacket,
					1);
		}
		if (inp.itemID == ItemInitializator.ItemRadiumCrystal.itemID) {
			return new ItemStack(ItemInitializator.ItemRadiumEnergyPacket, 1);
		}
		if (inp.itemID == ItemInitializator.ItemGammatroniumCrystal.itemID) {
			return new ItemStack(
					ItemInitializator.ItemGammatroniumEnergyPacket, 1);
		}
		if (inp.itemID == ItemInitializator.ItemNeutriniumCrystal.itemID) {
			return new ItemStack(ItemInitializator.ItemNeutriniumEnergyPacket,
					1);
		}
		return null;

	}

	public void extractItem() {
		if (this.canExtract()) {

			fuel -= 100;

			ItemStack var1 = this.getResult(this.inventory[0]);

			if (this.inventory[4] == null) {
				this.inventory[4] = var1.copy();
			} else if (this.inventory[4].isItemEqual(var1)) {
				inventory[4].stackSize += var1.stackSize;
			}
			if (this.inventory[3] == null) {
				this.inventory[3] = new ItemStack(
						ItemInitializator.ItemDepletedCrystal, 1);
			} else if (this.inventory[3].isItemEqual(new ItemStack(
					ItemInitializator.ItemDepletedCrystal, 1))) {
				inventory[3].stackSize += var1.stackSize;
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

	public static int getItemBurnTime(ItemStack par0ItemStack) {
		if (par0ItemStack == null) {
			return 0;
		} else {
			int var1 = par0ItemStack.getItem().itemID;
			Item var2 = par0ItemStack.getItem();

			if (par0ItemStack.getItem() instanceof ItemBlock
					&& Block.blocksList[var1] != null) {
				Block var3 = Block.blocksList[var1];

				if (var3 == Block.woodSingleSlab) {
					return 150;
				}

				if (var3.blockMaterial == Material.wood) {
					return 300;
				}
			}

			if (var1 == Item.stick.itemID)
				return 100;
			if (var1 == Item.coal.itemID)
				return 1600;
			if (var1 == Item.bucketLava.itemID)
				return 20000;
			if (var1 == Block.sapling.blockID)
				return 100;
			if (var1 == Item.blazeRod.itemID)
				return 2400;
			return GameRegistry.getFuelValue(par0ItemStack);
		}
	}

	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}
}
