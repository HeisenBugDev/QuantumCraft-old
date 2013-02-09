package sammko.quantumCraft.machine.gui;

import sammko.quantumCraft.items.ItemEnergyPacket;
import sammko.quantumCraft.items.ItemInitializator;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotEEP extends Slot {

	public SlotEEP(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public boolean isItemValid(ItemStack is)
    {
        return is.itemID == ItemInitializator.ItemEmptyEnergyPacket.itemID;
    }


}
