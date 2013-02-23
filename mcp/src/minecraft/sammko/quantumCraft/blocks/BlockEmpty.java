package sammko.quantumCraft.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.resources.BlockTextureMatrix;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class BlockEmpty extends Block {

	public int RenderID; // Renderer ID for the custom renderer
	
	public int[] tMap = new int[6]; // Texture array for all sides
	
	public BlockEmpty(int par1, int par2, int rid) {
		
		super(par1, par2, Material.rock);
		this.setCreativeTab(Initializator.tabQC);
		this.RenderID = rid;
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
		GameRegistry.registerBlock(this, "emptyBlock");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false; // To use custom renderer
		
	}
	
	@Override
    public int getBlockTextureFromSide(int par1)
    {
        return tMap[par1]; // return values from the tMap
    }
	
	@Override
	public int getRenderType()
	{
		return RenderID; // return the RendererID for the game engine
	}
	
	
	
}
