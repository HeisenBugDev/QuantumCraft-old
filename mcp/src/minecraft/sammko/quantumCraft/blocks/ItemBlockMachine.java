package sammko.quantumCraft.blocks;

import java.util.List;

import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.resources.OtherResx;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachine extends ItemBlock {
	public ItemBlockMachine(int par1) {
		super(par1);
		setHasSubtypes(true);
		setItemName("iBlockMachine");
		setCreativeTab(Initializator.tabQC);
	}

	private final static String[] subNames = {
		"quantumExtractor", "quantumInfuser"
	};
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		if (itemstack.getItemDamage() > subNames.length-1) return OtherResx.ERROR[0];
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
}
