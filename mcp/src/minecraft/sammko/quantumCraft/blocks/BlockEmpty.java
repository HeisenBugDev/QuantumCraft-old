package sammko.quantumCraft.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.resources.BlockTextureMatrix;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class BlockEmpty extends Block {

	public int RenderID;
	
	public int[] tMap = new int[6];
	
	public BlockEmpty(int par1, int par2, int rid) {
		
		super(par1, par2, Material.rock);
		this.setBlockName("emptyBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.RenderID = rid;
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
		GameRegistry.registerBlock(this);
		LanguageRegistry.addName(this, "Empty Block");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
		
	}
	
	@Override
    public int getBlockTextureFromSide(int par1)
    {
        return tMap[par1];
    }
	
	@Override
	public int getRenderType()
	{
		return RenderID;
	}
	
	
	
}
