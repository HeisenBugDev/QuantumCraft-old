package sammko.quantumCraft.machine;

import sammko.quantumCraft.core.gui.QuantumContainer;
import sammko.quantumCraft.machine.gui.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ExtractorContainer extends QuantumContainer {

    protected TileEntityExtractor tileEntity;
    
    public ExtractorContainer (InventoryPlayer inventoryPlayer, TileEntityExtractor te){
        	super(te.getSizeInventory());
            tileEntity = te;

            //TODO: add the slots
            addSlotToContainer(new Slot(te, 0, 18, 11));
            addSlotToContainer(new Slot(te, 1, 18, 55));
            addSlotToContainer(new Slot(te, 2, 62, 55));
            addSlotToContainer(new SlotOutput(te, 3, 124, 52));
            addSlotToContainer(new SlotOutput(te, 4, 128, 28));

            bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
    }
	
}
