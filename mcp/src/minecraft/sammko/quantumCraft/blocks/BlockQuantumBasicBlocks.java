package sammko.quantumCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import sammko.quantumCraft.core.QuantumCraftSettings;

public class BlockQuantumBasicBlocks extends Block {
	public BlockQuantumBasicBlocks(int id, int texture, Material material) {
		super(id, texture, material);
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
	}
	
	 public String getTextureFile () {
         return QuantumCraftSettings.BLOCK_PNG;
 }
}
