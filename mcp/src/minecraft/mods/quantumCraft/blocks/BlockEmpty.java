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
	public void func_94332_a(IconRegister par1IconRegister)
	{
	         this.field_94336_cN = par1IconRegister.func_94245_a("sammko:0x" + BlockTextureMatrix.EBlockBackSingle.getString());
	         //THIS SHOULD WORK. my mod folder is sammko. (/mods/sammko/textures/blocks/). I am trying to adress blocks/0x00.png.
	         //doesnt work
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
