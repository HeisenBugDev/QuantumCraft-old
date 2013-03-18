package mods.quantumCraft.render;

import mods.quantumCraft.machine.BlockMachine;
import mods.quantumCraft.machine.TileEntityMachine;
import mods.quantumCraft.resources.BlockTextureMatrix;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class RenderBlockMachine extends RendererBase {

	int mType = 0;
	int rot = 0;

	int[] tMap = new int[6];

	public RenderBlockMachine(int renderID) {
		super(renderID);
	}

	void setStuff(RenderBlocks renderer, IBlockAccess world, Block block,
			int x, int y, int z) {
		TileEntityMachine t = (TileEntityMachine) world.getBlockTileEntity(x,
				y, z);

		int meta = world.getBlockMetadata(x, y, z);

		tMap[0] = BlockTextureMatrix.EBlockBackSingle.getINT();
		tMap[1] = BlockTextureMatrix.MachineTop[meta].getINT();

		if (t.rotation == ForgeDirection.NORTH)
			tMap[2] = BlockTextureMatrix.MachineFront[meta].getINT();
		else
			tMap[2] = BlockTextureMatrix.EBlockSideSingle.getINT();
		if (t.rotation == ForgeDirection.SOUTH)
			tMap[3] = BlockTextureMatrix.MachineFront[meta].getINT();
		else
			tMap[3] = BlockTextureMatrix.EBlockSideSingle.getINT();
		if (t.rotation == ForgeDirection.WEST)
			tMap[4] = BlockTextureMatrix.MachineFront[meta].getINT();
		else
			tMap[4] = BlockTextureMatrix.EBlockSideSingle.getINT();
		if (t.rotation == ForgeDirection.EAST)
			tMap[5] = BlockTextureMatrix.MachineFront[meta].getINT();
		else
			tMap[5] = BlockTextureMatrix.EBlockSideSingle.getINT();

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
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public void renderInventoryBlock(Block block, int metadata, int modelID,
	// RenderBlocks renderer) {
	// super.renderInventoryBlock(block, metadata, modelID, renderer, new int[]
	// { BlockTextureMatrix.EBlockBackSingle.getINT(),
	// BlockTextureMatrix.MachineTop[metadata].getINT(),BlockTextureMatrix.EBlockSideSingle.getINT(),
	// BlockTextureMatrix.MachineFront[metadata].getINT(),BlockTextureMatrix.EBlockSideSingle.getINT(),
	// BlockTextureMatrix.EBlockSideSingle.getINT() });
	// }
}
