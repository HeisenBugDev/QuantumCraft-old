package mods.sammko.quantumCraft.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public abstract class RendererBase implements ISimpleBlockRenderingHandler {
	protected int rid;

	// public void renderInventoryBlock(Block block, int metadata, int modelID,
	// RenderBlocks renderer, int[] tMap)
	// {
	// // copied vanilla render code....
	//
	// Tessellator tessellator = Tessellator.instance;
	//
	// block.setBlockBoundsForItemRender();
	// GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	// tessellator.startDrawingQuads();
	// tessellator.setNormal(0.0F, -1F, 0.0F);
	// renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, tMap[0]);
	// tessellator.draw();
	// tessellator.startDrawingQuads();
	// tessellator.setNormal(0.0F, 1.0F, 0.0F);
	// renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, tMap[1]);
	// tessellator.draw();
	// tessellator.startDrawingQuads();
	// tessellator.setNormal(0.0F, 0.0F, -1F);
	// renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, tMap[2]);
	// tessellator.draw();
	// tessellator.startDrawingQuads();
	// tessellator.setNormal(0.0F, 0.0F, 1.0F);
	// renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, tMap[3]);
	// tessellator.draw();
	// tessellator.startDrawingQuads();
	// tessellator.setNormal(-1F, 0.0F, 0.0F);
	// renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, tMap[4]);
	// tessellator.draw();
	// tessellator.startDrawingQuads();
	// tessellator.setNormal(1.0F, 0.0F, 0.0F);
	// renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, tMap[5]);
	// tessellator.draw();
	// GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	// }

	// public void renderInventoryBlock(Block block, int metadata, int modelID,
	// RenderBlocks renderer, int tMap)
	// {
	// this.renderInventoryBlock(block, metadata, modelID, renderer, new int[] {
	// tMap, tMap, tMap, tMap, tMap, tMap });
	// }

	protected RendererBase(int renderID) {
		rid = renderID;
	}

	@Override
	public int getRenderId() {
		return rid;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}
}