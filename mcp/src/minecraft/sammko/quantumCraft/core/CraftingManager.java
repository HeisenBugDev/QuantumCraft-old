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
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalSword,1), " d "," d "," s ", 'd', ItemInitializator.ItemDepletedCrystal, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalAxe,1),"dd ","ds "," s ",'d', ItemInitializator.ItemDepletedCrystal, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalAxe,1)," dd"," sd"," s ",'d', ItemInitializator.ItemDepletedCrystal, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalShovel,1), " d "," s "," s ", 'd', new ItemStack(ItemInitializator.ItemDepletedCrystal), 's', Item.stick);
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,0), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemPositroniumCrystal), 'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,1), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemRadiumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,2), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemGammatroniumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,3), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemNeutriniumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,4), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemDepletedCrystal),'x', new ItemStack(Block.stoneBrick));
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,5), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,0));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,6), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,7), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,2));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,8), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,3));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,9), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,4));
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,9), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,5));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,10), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,6));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,11), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,7));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,12), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,8));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,13), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,9));
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,1,14), "xxx","xxx","xxx", 'x', new ItemStack(ItemInitializator.ItemIngotPlutonium));
		
		//new ItemStack(ItemInitializator.EmptyBlock, 4) means the result are 4 EMpty Blocks
		//" x ", "xyx", " x " is the crafting matrix
		//'y', new ItemStack(ItemInitializator.ItemIngotPlutonium) means that y, in the crafting matrix should be Plutonium ingot
		//TODO: ADD CRAFTINGS FOR DECO BLOCKS :D
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
