package sammko.quantumCraft.render;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public abstract class RendererBase implements ISimpleBlockRenderingHandler
{
	protected int rid;

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