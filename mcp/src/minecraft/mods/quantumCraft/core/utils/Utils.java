package mods.quantumCraft.core.utils;

import mods.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class Utils { // Thank you buildcraft :)

	public static int Scale(int pixels, int val, int maxval) {
		return val / maxval * pixels;
	}

	public static float EU_to_MJ(int EU) {
		return EU / 6;
	}

	public static int MJ_to_EU(float MJ) {
		return (int) (MJ * 6);
	}

	public static boolean isGamma(int id) {
		if (id == QuantumCraftSettings.InfusedCrystalPickaxeID + 256
				|| id == QuantumCraftSettings.InfusedCrystalAxeID + 256
				|| id == QuantumCraftSettings.InfusedCrystalSwordID + 256
				|| id == QuantumCraftSettings.InfusedCrystalShovelID + 256) {
			return true;
		} else {
			return false;
		}
	}

	public static ForgeDirection get2dOrientation(EntityLiving pos1) {
		double Dx = pos1.rotationYaw;
		double Dz = pos1.rotationPitch;
		double angle = Math.atan2(Dz, Dx) / Math.PI * 180 + 180;

		if (angle < 45 || angle > 315)
			return ForgeDirection.EAST;
		else if (angle < 135)
			return ForgeDirection.SOUTH;
		else if (angle < 225)
			return ForgeDirection.WEST;
		else
			return ForgeDirection.NORTH;
	}

	public static void preDestroyBlock(World world, int i, int j, int k) {
		TileEntity tile = world.getBlockTileEntity(i, j, k);
		if (tile instanceof IInventory)
			dropItems(world, (IInventory) tile, i, j, k);
	}

	public static void dropItems(World world, ItemStack stack, int i, int j,
			int k) {
		if (stack.stackSize <= 0)
			return;

		float f1 = 0.7F;
		double d = (world.rand.nextFloat() * f1) + (1.0F - f1) * 0.5D;
		double d1 = (world.rand.nextFloat() * f1) + (1.0F - f1) * 0.5D;
		double d2 = (world.rand.nextFloat() * f1) + (1.0F - f1) * 0.5D;
		EntityItem entityitem = new EntityItem(world, i + d, j + d1, k + d2,
				stack);
		entityitem.delayBeforeCanPickup = 10;

		world.spawnEntityInWorld(entityitem);
	}

	public static void dropItems(World world, IInventory inventory, int i,
			int j, int k) {
		for (int l = 0; l < inventory.getSizeInventory(); ++l) {
			ItemStack items = inventory.getStackInSlot(l);

			if (items != null && items.stackSize > 0) {
				dropItems(world, inventory.getStackInSlot(l).copy(), i, j, k);
			}
		}
	}

	public static int getWorldHeight(World world) {
		return world.getHeight();
	}

	public static NBTTagCompound getOrCreateNbtData(ItemStack itemStack) {
		NBTTagCompound ret = itemStack.getTagCompound();

		if (ret == null) {
			ret = new NBTTagCompound();

			itemStack.setTagCompound(ret);
		}

		return ret;
	}

}
