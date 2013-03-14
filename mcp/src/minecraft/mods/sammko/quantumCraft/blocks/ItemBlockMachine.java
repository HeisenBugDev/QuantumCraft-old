package mods.sammko.quantumCraft.blocks;

import java.util.List;

import mods.sammko.quantumCraft.core.Initializator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachine extends ItemBlock {
	public ItemBlockMachine(int par1) {
		super(par1);
		setHasSubtypes(true);
		setUnlocalizedName("iBlockMachine");
		setCreativeTab(Initializator.tabQC);
	}

	private final static String[] subNames = { "quantumExtractor",
			"quantumInfuser" };

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}
}
