package sammko.quantumCraft.blocks;

import net.minecraft.block.BlockOre;
import cpw.mods.fml.common.registry.GameRegistry;
import sammko.quantumCraft.core.QuantumCraftSettings;
public class BlockQuantumOre extends BlockOre {

	public BlockQuantumOre(int par1, int par2) {
		super(par1, par2);
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
		GameRegistry.registerBlock(this);
		// TODO Auto-generated constructor stub
	}


}
