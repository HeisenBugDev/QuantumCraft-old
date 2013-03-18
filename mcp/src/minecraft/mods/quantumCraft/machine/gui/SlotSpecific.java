package mods.quantumCraft.machine.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotSpecific extends Slot {

	public SlotSpecific(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		// TODO Auto-generated constructor stub
	}

	List<ItemStack> allowed = new ArrayList<ItemStack>();

	public SlotSpecific addItems(ItemStack items) {
		allowed.add(items);
		return this;
	}

	public SlotSpecific addItems(ItemStack[] items) {
		for (ItemStack is : items) {
			allowed.add(is);
		}
		return this;
	}

	public SlotSpecific addItems(Item items) {
		allowed.add(new ItemStack(items));
		return this;
	}

	public SlotSpecific addItems(Item[] items) {
		for (Item i : items) {
			allowed.add(new ItemStack(i));
		}
		return this;
	}

	@Override
	public boolean isItemValid(ItemStack is) {
		boolean t = false;
		for (ItemStack is1 : allowed) {
			if (is.itemID == is1.itemID) {
				t = true;
			}
		}
		return t;
	}

}
