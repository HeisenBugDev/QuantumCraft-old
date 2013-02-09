package sammko.quantumCraft.blocks;

import sammko.quantumCraft.items.ItemInitializator;
import sammko.quantumCraft.resources.OtherResx;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachine extends ItemBlock {
	public ItemBlockMachine(int par1) {
		super(par1);
		setHasSubtypes(true);
		setItemName("iBlockMachine");
		setCreativeTab(ItemInitializator.tabQC);
	}

	private final static String[] subNames = {
		"quantumExtractor"
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
}
