package sammko.quantumCraft.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import sammko.quantumCraft.core.gui.QuantumContainer;
import sammko.quantumCraft.machine.gui.SlotSpecific;

public class InfuserContainer extends QuantumContainer {

	 protected TileEntityInfuser tileEntity;
	    public short progress = 0;
	    public short fuel = 0;
    
    public InfuserContainer (InventoryPlayer inventoryPlayer, TileEntityInfuser te){
        	super(te.getSizeInventory());
            tileEntity = te;

            addSlotToContainer(new Slot(te, 0, 18, 11));
            addSlotToContainer(new Slot(te, 1, 18, 55));
            addSlotToContainer(new SlotSpecific(te, 4, 128, 28));

            bindPlayerInventory(inventoryPlayer);
    }
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        for (int i = 0; i < crafters.size(); i++)
        {
            ICrafting icrafting = (ICrafting)crafters.get(i);
            if (progress != tileEntity.progress)
            {
                icrafting.sendProgressBarUpdate(this, 0, tileEntity.progress);
            }
            if (fuel != tileEntity.internalStorage)
            {
                icrafting.sendProgressBarUpdate(this, 1, tileEntity.internalStorage);
            }
        }

        progress = (short) tileEntity.progress;
        fuel = (short) tileEntity.internalStorage;
    }

    public void updateProgressBar(int i, int j)
    {
        if (i == 0)
        {
            tileEntity.progress = (short)j;
        }
        if (i == 1)
        {
            tileEntity.internalStorage = (short)j;
        }
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
    	
    	// TODO fix so that it works properly
        /* ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
                ItemStack stackInSlot = slotObject.getStack();
                stack = stackInSlot.copy();

                //merges the item into player inventory since its in the tileEntity
                if (slot < 9) {
                        if (!this.mergeItemStack(stackInSlot, 9, 45, true)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                        return null;
                }

                if (stackInSlot.stackSize == 0) {
                        slotObject.putStack(null);
                } else {
                        slotObject.onSlotChanged();
                }

                if (stackInSlot.stackSize == stack.stackSize) {
                        return null;
                }
                slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
        */
    	return null;
    }
	
}
