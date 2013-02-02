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
	public void breakBlock (World par1World, int x, int y, int z, int par5, int par6)
	{
		TileEntityMachine te = (TileEntityMachine) par1World.getBlockTileEntity(x, y, z);
		Random r = new Random();
		
		if (te != null)
		{
			for (int iter = 0; iter < te.getSizeInventory(); ++iter)
			{
				ItemStack stack = te.getStackInSlot(iter);

				if (stack != null && te.canDropInventorySlot(iter))
				{
					float jumpX = r.nextFloat() * 0.8F + 0.1F;
					float jumpY = r.nextFloat() * 0.8F + 0.1F;
					float jumpZ = r.nextFloat() * 0.8F + 0.1F;

					while (stack.stackSize > 0)
					{
						int itemSize = r.nextInt(21) + 10;
						
						if (itemSize > stack.stackSize)
						{
							itemSize = stack.stackSize;
						}

						stack.stackSize -= itemSize;
						EntityItem entityitem = new EntityItem(par1World, (double) ((float) x + jumpX), (double) ((float) y + jumpY), (double) ((float) z + jumpZ),
								new ItemStack(stack.itemID, itemSize, stack.getItemDamage()));

						if (stack.hasTagCompound())
						{
							entityitem.func_92014_d().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
						}

						float offset = 0.05F;
						entityitem.motionX = (double) ((float) r.nextGaussian() * offset);
						entityitem.motionY = (double) ((float) r.nextGaussian() * offset + 0.2F);
						entityitem.motionZ = (double) ((float) r.nextGaussian() * offset);
						par1World.spawnEntityInWorld(entityitem);
					}
				}
			}
		}

		super.breakBlock(par1World, x, y, z, par5, par6);
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
