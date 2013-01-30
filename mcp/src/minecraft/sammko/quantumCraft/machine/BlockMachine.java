package sammko.quantumCraft.machine;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sammko.quantumCraft.core.QuantumCraft;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.items.ItemInitializator;
import sammko.quantumCraft.machine.gui.GuiExtractor;
import sammko.quantumCraft.resources.BlockTextureMatrix;

public class BlockMachine extends BlockContainer {

	int RenderID; // renderer id for custom renderer
	
	public BlockMachine(int par1, int rid) {
		super(par1, Material.rock);
		this.setBlockName("machineBlock");
		this.setCreativeTab(ItemInitializator.tabQC);
		this.setTextureFile(QuantumCraftSettings.BLOCK_PNG);
		GameRegistry.registerBlock(this);
		LanguageRegistry.addName(this, "Machine Block");
		RenderID = rid;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
		
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
		return new TileEntityExtractor(var1,2);
		//TODO: change this based on the metadata of this block.
	}

	@Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
            dropItems(world, x, y, z);
            super.breakBlock(world, x, y, z, par5, par6);
    }
	
	private void dropItems(World world, int x, int y, int z){
         Random rand = new Random();

         TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
         if (!(tileEntity instanceof IInventory)) {
                 return;
         }
         IInventory inventory = (IInventory) tileEntity;

         for (int i = 0; i < inventory.getSizeInventory(); i++) {
                 ItemStack item = inventory.getStackInSlot(i);

                 if (item != null && item.stackSize > 0) {
                         float rx = rand.nextFloat() * 0.8F + 0.1F;
                         float ry = rand.nextFloat() * 0.8F + 0.1F;
                         float rz = rand.nextFloat() * 0.8F + 0.1F;

                         EntityItem entityItem = new EntityItem(world,
                                         x + rx, y + ry, z + rz,
                                         new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                         if (item.hasTagCompound()) {
                                 entityItem.func_92014_d().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                         }

                         float factor = 0.05F;
                         entityItem.motionX = rand.nextGaussian() * factor;
                         entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                         entityItem.motionZ = rand.nextGaussian() * factor;
                         world.spawnEntityInWorld(entityItem);
                         item.stackSize = 0;
                }
        }
 }
	
}
