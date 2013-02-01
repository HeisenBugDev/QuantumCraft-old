package sammko.quantumCraft.core.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class QuantumContainer extends Container {

	private int inventorySize;

	public QuantumContainer(int inventorySize)
	{
		this.inventorySize = inventorySize;
	}
	
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
            for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                            addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                            (8 + j * 18 ), (84 + i * 18 )));
                    }
            }

            for (int i = 0; i < 9; i++) {
                    addSlotToContainer(new Slot(inventoryPlayer, i, (8 + i * 18 ), 142));
            }
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer pl, int i)
	{
			ItemStack itemstack = null;
			Slot slot = (Slot) inventorySlots.get(i);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (i < inventorySize) {
					if (!mergeItemStack(itemstack1, inventorySize, inventorySlots.size(), true))
						return null;
				} else if (!mergeItemStack(itemstack1, 0, inventorySize, false))
					return null;
				if (itemstack1.stackSize == 0) {
					slot.putStack(null);
				} else {
					slot.onSlotChanged();
				}
			}
			return itemstack;
	}

	public int getInventorySize()
	{
		return inventorySize;
	}
}
