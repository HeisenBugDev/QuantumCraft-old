package sammko.quantumCraft.machine;

import java.util.List;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sammko.quantumCraft.blocks.ItemBlockMachine;
import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.QuantumCraft;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.core.utils.Utils;
import sammko.quantumCraft.machine.gui.GuiExtractor;
import sammko.quantumCraft.resources.BlockTextureMatrix;

public class BlockMachine extends BlockContainer {

	int RenderID; // renderer id for custom renderer

	public BlockMachine(int par1, int rid) {
		super(par1, Material.rock);
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
		GameRegistry
				.registerBlock(this, ItemBlockMachine.class, "machineBlock");
		setCreativeTab(Initializator.tabQC);
		RenderID = rid;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;

	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < Initializator.GuiExtractorID; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k,
			EntityLiving entityliving) {
		super.onBlockPlacedBy(world, i, j, k, entityliving);

		ForgeDirection orientation = Utils.get2dOrientation(new Position(
				entityliving.posX, entityliving.posY, entityliving.posZ),
				new Position(i, j, k));
		TileEntityMachine t = (TileEntityMachine) world.getBlockTileEntity(i,
				j, k);
		t.rotation = orientation.getOpposite();
	}

	@Override
	public void breakBlock(World par1World, int x, int y, int z, int par5,
			int par6) {
		Utils.preDestroyBlock(par1World, x, y, z);
		super.breakBlock(par1World, x, y, z, par5, par6);
	}

	public Integer integer = null;

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int idk, float what, float these, float are) {
		Integer integer = getGui(world, x, y, z, player);
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (player.isSneaking()) {
			return false;
		}

		if (integer == null || integer == -1) {
			return false;
		} else {
			player.openGui(QuantumCraft.instance, integer, world, x, y, z);
			return true;
		}

	}

	public Integer getGui(World world, int x, int y, int z, EntityPlayer player)
	{
		switch (world.getBlockMetadata(x, y, z))
		{
		case 0:
			return Initializator.GuiExtractorID;
		case 1:
			return Initializator.GuiReactorID;
		default:
			return -1;
		}
	}

	@Override
	public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		return ((TileEntityMachine) par1IBlockAccess.getBlockTileEntity(par2,
				par3, par4)).tMap[par5];

	}

	@Override
	public int getRenderType() {
		return RenderID;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int metadata) {
		switch (metadata)
		{
		case 0:
			return new TileEntityExtractor(ForgeDirection.NORTH);
		case 1:
			return new TileEntityInfuser(ForgeDirection.NORTH);
		default:
			return null;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return null;
	}

}
