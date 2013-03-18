package mods.quantumCraft.blocks;

import java.util.List;

import mods.quantumCraft.core.Initializator;
import mods.quantumCraft.resources.BlockTextureMatrix;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockQuantumBasicBlocks extends InventoryBlockMetadata {
	public BlockQuantumBasicBlocks(int id, int texture) {
		super(id, Material.rock);
		GameRegistry.registerBlock(this, ItemBlockQuantumBasicBlocks.class,
				"BlockDecoBlocks");
		setCreativeTab(Initializator.tabQC);
	}

	@Override
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {

		if (meta < 2) {
			int sideTex = side == 3 ? 1 : 0;
			return icons[sideTex + meta * 3];
		} else {
			return icons[6];
		}

	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 16; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getTextureNames() {
		String[] textureNames = { 
				BlockTextureMatrix.Deco[0].getString(),
				BlockTextureMatrix.Deco[1].getString(),
				BlockTextureMatrix.Deco[2].getString(),
				BlockTextureMatrix.Deco[3].getString(),
				BlockTextureMatrix.Deco[4].getString(),
				BlockTextureMatrix.Deco[5].getString(),
				BlockTextureMatrix.Deco[6].getString(),	
			};

			return textureNames;
	}

}
