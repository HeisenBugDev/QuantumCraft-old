package sammko.quantumCraft.machine;

import java.util.Random;
import java.util.ArrayList;

import buildcraft.api.core.Position;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sammko.quantumCraft.core.Utils;
import sammko.quantumCraft.core.QuantumCraft;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.items.ItemInitializator;
import sammko.quantumCraft.machine.gui.GuiExtractor;
import sammko.quantumCraft.resources.BlockTextureMatrix;

public class BlockMachine extends BlockContainer {

	int RenderID; // renderer id for custom renderer
	
	public BlockMachine(int par1, int rid) {
		super(par1, Material.rock);
		this.setCreativeTab(ItemInitializator.tabQC);
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
		GameRegistry.registerBlock(this, "machineBlock");
		LanguageRegistry.addName(this, "Machine Block");
		RenderID = rid;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
		
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		super.onBlockPlacedBy(world, i, j, k, entityliving);

		ForgeDirection orientation = Utils.get2dOrientation(new Position(entityliving.posX, entityliving.posY, entityliving.posZ), new Position(i, j, k));
		TileEntityMachine t = (TileEntityMachine) world.getBlockTileEntity(i, j, k);
		t.rotation = orientation.getOpposite();
	}

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are) {
    	 TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
         if (tileEntity == null || player.isSneaking()) {
                 return false;
         }
         player.openGui(QuantumCraft.instance, ItemInitializator.GuiExtractorID, world, x, y, z);
         return true;
    }
	
	@Override
	public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
		return ((TileEntityMachine) par1IBlockAccess.getBlockTileEntity(par2, par3, par4)).tMap[par5];
       
    }
	
	@Override
	public int getRenderType()
	{
		return RenderID;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityExtractor(var1,ForgeDirection.NORTH);
		//TODO: change this based on the metadata of this block.
	}
	
}
