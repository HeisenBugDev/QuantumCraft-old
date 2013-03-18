package mods.quantumCraft.render;

import mods.quantumCraft.blocks.BlockEmpty;
import mods.quantumCraft.core.Initializator;
import mods.quantumCraft.resources.BlockTextureMatrix;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEmpty extends RendererBase {

	public int tileRules = -1; // a variable that will be mayb

	public RenderBlockEmpty(int renderID, int tRules) {
		super(renderID);
		tileRules = tRules;
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		int tMap[] = new int[6];

		BlockEmpty b = (BlockEmpty) block;

		renderer.aoType = 1;

		if (tileRules == 0) // based on tileRules change the texture connection
							// rules. 0 = UP-DOWN
		{
			tMap[0] = BlockTextureMatrix.EBlockBackSingle.getINT();
			tMap[1] = BlockTextureMatrix.EBlockBackSingle.getINT();

			int tempt = 0;

			if (world.getBlockId(x, y + 1, z) == Initializator.EmptyBlock.blockID)
				tempt = BlockTextureMatrix.EBlockBackBot.getINT();
			if (world.getBlockId(x, y - 1, z) == Initializator.EmptyBlock.blockID)
				tempt = BlockTextureMatrix.EBlockBackTop.getINT();
			if (world.getBlockId(x, y + 1, z) == Initializator.EmptyBlock.blockID
					&& world.getBlockId(x, y - 1, z) == Initializator.EmptyBlock.blockID)
				tempt = BlockTextureMatrix.EBlockBackMid.getINT();
			for (int i = 2; i < 6; i++) {
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
		// TODO Auto-generated method stub

	}

	// @Override
	// public void renderInventoryBlock(Block block, int metadata, int modelID,
	// RenderBlocks renderer) {
	// super.renderInventoryBlock(block, metadata, modelID, renderer,
	// BlockTextureMatrix.EBlockBackSingle.getINT());
	//
	// }

}
