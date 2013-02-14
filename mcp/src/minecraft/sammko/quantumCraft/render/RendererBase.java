package sammko.quantumCraft.render;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public abstract class RendererBase implements ISimpleBlockRenderingHandler
{
	protected int rid;

	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}
	
	protected RendererBase(int renderID)
	{
		rid = renderID;
	}

	public int getRenderId()
	{
		return rid;
	}

	public boolean shouldRender3DInInventory()
	{
		return false;
	}
}