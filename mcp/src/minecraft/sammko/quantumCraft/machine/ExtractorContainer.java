package sammko.quantumCraft.machine;

import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.gui.QuantumContainer;
import sammko.quantumCraft.machine.gui.SlotSpecific;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ExtractorContainer extends QuantumContainer {

    protected TileEntityExtractor tileEntity;
    public short progress = 0;
    public short fuel = 0;
    
    public ExtractorContainer (InventoryPlayer inventoryPlayer, TileEntityExtractor te){
        	super(te.getSizeInventory());
            tileEntity = te;

            addSlotToContainer(new Slot(te, 0, 18, 11));
            addSlotToContainer(new SlotSpecific(te, 1, 18, 55).addItems(Initializator.ItemEmptyEnergyPacket));
            addSlotToContainer(new Slot(te, 2, 62, 55));
            addSlotToContainer(new SlotSpecific(te, 3, 124, 52));
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
	
}
