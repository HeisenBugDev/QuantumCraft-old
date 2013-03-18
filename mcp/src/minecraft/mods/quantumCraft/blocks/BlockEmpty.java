package mods.quantumCraft.blocks;

import mods.quantumCraft.core.Initializator;
import mods.quantumCraft.resources.BlockTextureMatrix;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockEmpty extends Block {

	public int RenderID; // Renderer ID for the custom renderer

	public int[] tMap = new int[6]; // Texture array for all sides

	public BlockEmpty(int par1, int par2, int rid) {

		super(par1, Material.rock);
		this.setCreativeTab(Initializator.tabQC);
		this.RenderID = rid;
		GameRegistry.registerBlock(this, "emptyBlock");
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false; // To use custom renderer

	}

	// @Override
	// public int getBlockTextureFromSide(int par1)
	// {
	// return tMap[par1]; // return values from the tMap
	// }

	@Override
	public int getRenderType() {
		return RenderID; // return the RendererID for the game engine
	}

}
