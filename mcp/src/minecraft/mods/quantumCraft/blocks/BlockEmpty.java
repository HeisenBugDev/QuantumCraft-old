package mods.quantumCraft.blocks;

import mods.quantumCraft.core.Initializator;
import mods.quantumCraft.resources.BlockTextureMatrix;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockEmpty extends Block {

	public BlockEmpty(int par1, String name) {
		super(par1, Material.rock);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
	}
}
