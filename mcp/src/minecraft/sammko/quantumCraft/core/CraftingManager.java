package sammko.quantumCraft.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sammko.quantumCraft.items.ItemInitializator;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	public static void addCrafting()
	{
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.EmptyBlock, 4), " x ", "xyx", " x ", 'y', new ItemStack(ItemInitializator.ItemIngotPlutonium), 'x', new ItemStack(Block.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemInitializator.ItemEmptyEnergyPacket,4), new ItemStack(ItemInitializator.ItemIngotPlutonium), new ItemStack(ItemInitializator.ItemIngotPlutonium) );
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalPickaxe,1),"ddd"," s "," s ",'d', ItemInitializator.ItemDepletedCrystal, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalSword,1), " d "," d "," s ", 'd', new ItemStack(ItemInitializator.ItemDepletedCrystal), 's', Item.stick);
		//new ItemStack(ItemInitializator.EmptyBlock, 4) means the result are 4 EMpty Blocks
		//" x ", "xyx", " x " is the crafting matrix
		//'y', new ItemStack(ItemInitializator.ItemIngotPlutonium) means that y, in the crafting matrix should be Plutonium ingot
	}

	public static void addSmelting()
	{
		GameRegistry.addSmelting(QuantumCraftSettings.OrePlutoniumID, new ItemStack(ItemInitializator.ItemIngotPlutonium), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OrePositroniumID, new ItemStack(ItemInitializator.ItemPositroniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreRadiumID, new ItemStack(ItemInitializator.ItemRadiumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreGammatroniumID, new ItemStack(ItemInitializator.ItemGammatroniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreNeutriniumID, new ItemStack(ItemInitializator.ItemNeutriniumCrystal), 4F);
	
		
		
		//QuantumCraftSettings.OrePlutoniumID is the input item
		//new ItemStack(ItemInitializator.ItemIngotPlutonium) is output
	}
}
