package sammko.quantumCraft.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import sammko.quantumCraft.core.gui.QuantumContainer;
import sammko.quantumCraft.machine.gui.SlotEEP;
import sammko.quantumCraft.machine.gui.SlotOutput;

public class ReactorContainer extends QuantumContainer {

protected TileEntityReactor tileEntity;
    
    public ReactorContainer (InventoryPlayer inventoryPlayer, TileEntityReactor te){
        	super(te.getSizeInventory());
            tileEntity = te;

            addSlotToContainer(new Slot(te, 0, 18, 11));
            addSlotToContainer(new Slot(te, 1, 18, 55));
            addSlotToContainer(new SlotOutput(te, 4, 128, 28));

            bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
    }
	
}
