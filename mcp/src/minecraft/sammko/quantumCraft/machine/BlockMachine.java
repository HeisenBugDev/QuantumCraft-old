package sammko.quantumCraft.machine;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sammko.quantumCraft.core.QuantumCraft;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.items.ItemInitializator;
import sammko.quantumCraft.resources.BlockTextureMatrix;

public class BlockMachine extends BlockContainer {

	int RenderID; // renderer id for custom renderer
	
	public BlockMachine(int par1, int rid) {
		super(par1, Material.rock);
		this.setBlockName("machineBlock");
		this.setCreativeTab(CreativeTabs.tabGems);
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
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z); // for getting the TE and opening the GUI.
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            } else { player.openGui(QuantumCraft.instance, ItemInitializator.GuiGeneratorID, world, x, y, z); }
            //TODO: register gui in ItemInitializator
            //BUG: crash on rightclick
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

}
