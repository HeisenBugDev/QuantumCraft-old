package sammko.quantumCraft.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.items.ItemInitializator;

public class BlockMachineNA extends BlockMachine{
	public BlockMachineNA(int par1, int rid) {
		super(par1, rid);

	}

	@Override
	public Integer getGui(World world, int x, int y, int z,
			EntityPlayer entityplayer) {

		return integer;
	}




}
