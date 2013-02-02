package sammko.quantumCraft.core;

import ic2.api.Ic2Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sammko.quantumCraft.items.ItemInitializator;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	public static void addCrafting()
	{
		//EmptyBlock and EP
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.EmptyBlock, 4), " x ", "xyx", " x ", 'y', new ItemStack(ItemInitializator.ItemIngotPlutonium), 'x', new ItemStack(Block.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemInitializator.ItemEmptyEnergyPacket,4), new ItemStack(ItemInitializator.ItemIngotPlutonium), new ItemStack(ItemInitializator.ItemIngotPlutonium) );
		//Tools
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalPickaxe,1),"ddd"," s "," s ",'d', ItemInitializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalSword,1), " d "," d "," s ", 'd', ItemInitializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalAxe,1),"dd ","ds "," s ",'d', ItemInitializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalAxe,1)," dd"," sd"," s ",'d', ItemInitializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.ItemCrystalShovel,1), " d "," s "," s ", 'd', new ItemStack(ItemInitializator.ItemDepletedShard), 's', Item.stick);
		//DecoBlocks
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,0), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemPositroniumCrystal), 'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,1), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemRadiumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,2), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemGammatroniumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,3), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemNeutriniumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,9,4), "xxx", "xyx", "xxx", 'y', new ItemStack(ItemInitializator.ItemDepletedCrystal),'x', new ItemStack(Block.stoneBrick));
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,5), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,6), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,1));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,7), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,2));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,8), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,3));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,9), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,4));
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,10), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,5));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,11), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,6));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,12), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,7));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,13), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,8));
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,4,14), "xx", "xx", 'x', new ItemStack(ItemInitializator.DecoBlocks,1,9));
		
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.DecoBlocks,1,15), "xxx","xxx","xxx", 'x', new ItemStack(ItemInitializator.ItemIngotPlutonium));
		
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
	
	public static void addOther()
	{
		//TODO:
		//IF YOU WANT TO TEST THE MOD IN ECLIPSE COMMENT THIS. DO NOT FORGET TO UNCOMMENT IT!!!!
		Ic2Recipes.addMaceratorRecipe(new ItemStack(ItemInitializator.ItemDepletedCrystal), new ItemStack(ItemInitializator.ItemDepletedShard));
				
	}
}
