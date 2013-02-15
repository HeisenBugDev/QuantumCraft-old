package sammko.quantumCraft.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import sammko.quantumCraft.machine.BlockMachine;
import sammko.quantumCraft.machine.TileEntityMachine;
import sammko.quantumCraft.resources.BlockTextureMatrix;

public class RenderBlockMachine extends RendererBase {

	int mType = 0;
	int rot = 0;
	
	int[] tMap = new int[6];
	
	public RenderBlockMachine(int renderID) {
		super(renderID);
	}

	

	void setStuff(RenderBlocks renderer, IBlockAccess world, Block block, int x, int y, int z)
	{
		//this sets the tMap in block class.
		//BUG: hmm the following code doesnt actually work. will need to debug it.
		TileEntityMachine t =  (TileEntityMachine) world.getBlockTileEntity(x, y, z);
		
		tMap[0] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
		tMap[1] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
		
		if (t.rotation == ForgeDirection.NORTH) tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.QuantumGenerator); else tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle);
		if (t.rotation == ForgeDirection.SOUTH) tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.QuantumGenerator); else tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle);
		if (t.rotation == ForgeDirection.WEST) tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.QuantumGenerator); else tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle);
		if (t.rotation == ForgeDirection.EAST) tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.QuantumGenerator); else tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle);
		
		t.tMap = this.tMap;
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {

		BlockMachine b = (BlockMachine) block;
		setStuff(renderer, world, b, x, y, z);
		renderer.renderStandardBlock(b, x, y, z);

		renderer.uvRotateTop = 0;
		renderer.uvRotateBottom = 0;
		renderer.uvRotateWest = 0;
		renderer.uvRotateEast = 0;
		renderer.uvRotateNorth = 0;
		renderer.uvRotateSouth = 0;
		
		return true;
	}



	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		super.renderInventoryBlock(block, metadata, modelID, renderer, new int[] { BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle),
				BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle),BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle),
				BlockTextureMatrix.getIndex(BlockTextureMatrix.QuantumGenerator),BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle),
				BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockSideSingle) });
	}
}
