package sammko.quantumCraft.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import sammko.quantumCraft.blocks.BlockEmpty;
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
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		// TODO: do somthing here (no idea what)
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int bid = QuantumCraftSettings.EmptyBlockID;
		int mid = QuantumCraftSettings.MachineBlockID;
		
		int tMap[] = new int[6];
		
		BlockEmpty b = (BlockEmpty) block;
		
		renderer.aoType = 1;
		
		if (tileRules == 0) //based on tileRules, change the texture connection rules. 0 = UP-DOWN
		{
			if (/* bottom layer, bottom row */  world.getBlockId(x-1, y-1, z) == bid && world.getBlockId(x, y-1, z) == bid && world.getBlockId(x+1, y-1, z) == bid &&
				/* bottom layer, middle row */  world.getBlockId(x-1, y-1, z-1) == bid && world.getBlockId(x, y-1, z-1) == bid && world.getBlockId(x+1, y-1, z-1) == bid &&
				/* bottom layer, top row */		world.getBlockId(x-1, y-1, z-2) == bid && world.getBlockId(x, y-1, z-2) == bid && world.getBlockId(x+1, y-1, z-2) == bid &&
				/* middle layer, bottom row */	world.getBlockId(x-1, y, z) == bid && world.getBlockId(x+1, y, z) == bid &&
				/* middle layer, middle row */	world.getBlockId(x-1, y, z-1) == bid && world.getBlockId(x, y, z-1) == mid && world.getBlockId(x+1, y, z-1) == bid &&
				/* middle layer, top row */		world.getBlockId(x-1, y, z-2) == bid && world.getBlockId(x, y, z-2) == bid && world.getBlockId(x+1, y, z-2) == bid &&
				/* top layer, bottom row */ 	world.getBlockId(x-1, y+1, z) == bid && world.getBlockId(x, y+1, z) == bid && world.getBlockId(x+1, y+1, z) == bid &&
				/* top layer, middle row */ 	world.getBlockId(x-1, y+1, z-1) == bid && world.getBlockId(x, y+1, z-1) == bid && world.getBlockId(x+1, y+1, z-1) == bid &&
				/* top layer, top row */		world.getBlockId(x-1, y+1, z-2) == bid && world.getBlockId(x, y+1, z-2) == bid && world.getBlockId(x+1, y+1, z-2) == bid ||
				/* opposite side */
				/* bottom layer, bottom row */  world.getBlockId(x-1, y-1, z) == bid && world.getBlockId(x, y-1, z) == bid && world.getBlockId(x+1, y-1, z) == bid &&
				/* bottom layer, middle row */  world.getBlockId(x-1, y-1, z+1) == bid && world.getBlockId(x, y-1, z+1) == bid && world.getBlockId(x+1, y-1, z+1) == bid &&
				/* bottom layer, top row */		world.getBlockId(x-1, y-1, z+2) == bid && world.getBlockId(x, y-1, z+2) == bid && world.getBlockId(x+1, y-1, z+2) == bid &&
				/* middle layer, bottom row */	world.getBlockId(x-1, y, z) == bid && world.getBlockId(x+1, y, z) == bid &&
				/* middle layer, middle row */	world.getBlockId(x-1, y, z+1) == bid && world.getBlockId(x, y, z+1) == mid && world.getBlockId(x+1, y, z+1) == bid &&
				/* middle layer, top row */		world.getBlockId(x-1, y, z+2) == bid && world.getBlockId(x, y, z+2) == bid && world.getBlockId(x+1, y, z+2) == bid &&
				/* top layer, bottom row */ 	world.getBlockId(x-1, y+1, z) == bid && world.getBlockId(x, y+1, z) == bid && world.getBlockId(x+1, y+1, z) == bid &&
				/* top layer, middle row */ 	world.getBlockId(x-1, y+1, z+1) == bid && world.getBlockId(x, y+1, z+1) == bid && world.getBlockId(x+1, y+1, z+1) == bid &&
				/* top layer, top row */		world.getBlockId(x-1, y+1, z+2) == bid && world.getBlockId(x, y+1, z+2) == bid && world.getBlockId(x+1, y+1, z+2) == bid ||
				
				/* other side */
				
				/* bottom layer, bottom row */  world.getBlockId(x, y-1, z-1) == bid && world.getBlockId(x, y-1, z) == bid && world.getBlockId(x, y-1, z+1) == bid &&
				/* bottom layer, middle row */  world.getBlockId(x-1, y-1, z-1) == bid && world.getBlockId(x-1, y-1, z) == bid && world.getBlockId(x-1, y-1, z+1) == bid &&
				/* bottom layer, top row */		world.getBlockId(x-2, y-1, z-1) == bid && world.getBlockId(x-2, y-1, z) == bid && world.getBlockId(x-2, y-1, z+1) == bid &&
				/* middle layer, bottom row */	world.getBlockId(x, y, z-1) == bid && world.getBlockId(x, y, z+1) == bid &&
				/* middle layer, middle row */	world.getBlockId(x-1, y, z-1) == bid && world.getBlockId(x-1, y, z) == mid && world.getBlockId(x-1, y, z+1) == bid &&
				/* middle layer, top row */		world.getBlockId(x-2, y, z-1) == bid && world.getBlockId(x-2, y, z) == bid && world.getBlockId(x-2, y, z+1) == bid &&
				/* top layer, bottom row */ 	world.getBlockId(x, y+1, z-1) == bid && world.getBlockId(x, y+1, z) == bid && world.getBlockId(x, y+1, z+1) == bid &&
				/* top layer, middle row */ 	world.getBlockId(x-1, y+1, z-1) == bid && world.getBlockId(x-1, y+1, z) == bid && world.getBlockId(x-1, y+1, z+1) == bid &&
				/* top layer, top row */		world.getBlockId(x-2, y+1, z-1) == bid && world.getBlockId(x-2, y+1, z) == bid && world.getBlockId(x-2, y+1, z+1) == bid ||
				/* opposite side */
				/* bottom layer, bottom row */  world.getBlockId(x, y-1, z-1) == bid && world.getBlockId(x, y-1, z) == bid && world.getBlockId(x, y-1, z+1) == bid &&
				/* bottom layer, middle row */  world.getBlockId(x+1, y-1, z-1) == bid && world.getBlockId(x+1, y-1, z) == bid && world.getBlockId(x+1, y-1, z+1) == bid &&
				/* bottom layer, top row */		world.getBlockId(x+2, y-1, z-1) == bid && world.getBlockId(x+2, y-1, z) == bid && world.getBlockId(x+2, y-1, z+1) == bid &&
				/* middle layer, bottom row */	world.getBlockId(x, y, z-1) == bid && world.getBlockId(x, y, z+1) == bid &&
				/* middle layer, middle row */	world.getBlockId(x+1, y, z-1) == bid && world.getBlockId(x+1, y, z) == mid && world.getBlockId(x+1, y, z+1) == bid &&
				/* middle layer, top row */		world.getBlockId(x+2, y, z-1) == bid && world.getBlockId(x+2, y, z) == bid && world.getBlockId(x+2, y, z+1) == bid &&
				/* top layer, bottom row */ 	world.getBlockId(x, y+1, z-1) == bid && world.getBlockId(x, y+1, z) == bid && world.getBlockId(x, y+1, z+1) == bid &&
				/* top layer, middle row */ 	world.getBlockId(x+1, y+1, z-1) == bid && world.getBlockId(x+1, y+1, z) == bid && world.getBlockId(x+1, y+1, z+1) == bid &&
				/* top layer, top row */		world.getBlockId(x+2, y+1, z-1) == bid && world.getBlockId(x+2, y+1, z) == bid && world.getBlockId(x+2, y+1, z+1) == bid
				){
				tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.NeutrinoGenerator);			// neutrineGenerator = random texture ... change it if you want 
				tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.NeutrinoGenerator);
				tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.NeutrinoGenerator);
				tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.NeutrinoGenerator);}
			else if (world.getBlockId(x, y-1, z) == bid && world.getBlockId(x, y+1, z) == bid) { 		//original renderer
				tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackMid);
				tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackMid);
				tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackMid);
				tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackMid);}
			else if (world.getBlockId(x, y+1, z) == bid) { 
				tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackBot);
				tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackBot);
				tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackBot);
				tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackBot);}
			else if (world.getBlockId(x, y-1, z) == bid) { 
				tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackTop);
				tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackTop);
				tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackTop);
				tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackTop);}
			else {
				tMap[2] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
				tMap[3] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
				tMap[4] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
				tMap[5] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);}
			tMap[1] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
			tMap[0] = BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle);
			
			b.tMap = tMap;
			renderer.renderStandardBlock(b, x, y, z);
			
		}
		
		// TODO: add tileRules 1 = horizontal tiling
		
		return true;
	}


}
