package sammko.quantumCraft.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import sammko.quantumCraft.blocks.BlockEmpty;
import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.QuantumCraft;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.resources.BlockTextureMatrix;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockEmpty extends RendererBase {

	public int tileRules = -1; // a variable that will be mayb
	
	public RenderBlockEmpty(int renderID, int tRules) {
		super(renderID);
		tileRules = tRules;
	}

	

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int tMap[] = new int[6];
		
		BlockEmpty b = (BlockEmpty) block;
		
		renderer.aoType = 1;
		
		if (tileRules == 0) //based on tileRules change the texture connection rules. 0 = UP-DOWN
		{
			tMap[0] = BlockTextureMatrix.EBlockBackSingle.getINT();
			tMap[1] = BlockTextureMatrix.EBlockBackSingle.getINT();
			
			int tempt = 0;
			
			if (world.getBlockId(x, y+1, z) == Initializator.EmptyBlock.blockID) tempt = BlockTextureMatrix.EBlockBackBot.getINT();
			if (world.getBlockId(x, y-1, z) == Initializator.EmptyBlock.blockID) tempt = BlockTextureMatrix.EBlockBackTop.getINT();
			if (world.getBlockId(x, y+1, z) == Initializator.EmptyBlock.blockID
			 && world.getBlockId(x, y-1, z) == Initializator.EmptyBlock.blockID) tempt = BlockTextureMatrix.EBlockBackMid.getINT();
			for (int i = 2; i < 6; i++)
			{
				tMap[i] = tempt;
			}
			b.tMap = tMap;
		}
		

		renderer.renderStandardBlock(b, x, y, z);
		
		// TODO: add tileRules 1 = horizontal tiling
		
		return true;
	}



	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		super.renderInventoryBlock(block, metadata, modelID, renderer, BlockTextureMatrix.EBlockBackSingle.getINT());
		
	}


}
