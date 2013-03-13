package sammko.quantumCraft.core;


import ic2.api.Ic2Recipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	public static void addCrafting()
	{
		//EmptyBlock and EP
		GameRegistry.addRecipe(new ItemStack(Initializator.EmptyBlock, 4), " x ", "xyx", " x ", 'y', new ItemStack(Initializator.ItemIngotPlutonium), 'x', new ItemStack(Block.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(Initializator.ItemEmptyEnergyPacket,4), new ItemStack(Initializator.ItemIngotPlutonium), new ItemStack(Initializator.ItemIngotPlutonium) );
		//Tools
		GameRegistry.addRecipe(new ItemStack(Initializator.ItemCrystalPickaxe,1),"ddd"," s "," s ",'d', Initializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(Initializator.ItemCrystalSword,1), " d "," d "," s ", 'd', Initializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(Initializator.ItemCrystalAxe,1),"dd ","ds "," s ",'d', Initializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(Initializator.ItemCrystalAxe,1)," dd"," sd"," s ",'d', Initializator.ItemDepletedShard, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(Initializator.ItemCrystalShovel,1), " d "," s "," s ", 'd', new ItemStack(Initializator.ItemDepletedShard), 's', Item.stick);
		//DecoBlocks
		GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,8,0), "xxx", "xyx", "xxx", 'y', new ItemStack(Initializator.ItemPositroniumCrystal), 'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,8,1), "xxx", "xyx", "xxx", 'y', new ItemStack(Initializator.ItemRadiumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,8,2), "xxx", "xyx", "xxx", 'y', new ItemStack(Initializator.ItemGammatroniumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,8,3), "xxx", "xyx", "xxx", 'y', new ItemStack(Initializator.ItemNeutriniumCrystal),'x', new ItemStack(Block.stoneBrick));
		GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,8,4), "xxx", "xyx", "xxx", 'y', new ItemStack(Initializator.ItemDepletedCrystal),'x', new ItemStack(Block.stoneBrick));
		for(int i = 0; i < 10; i++)
		{
			GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,4,i+5), "xx", "xx", 'x', new ItemStack(Initializator.DecoBlocks,1,i));
		}
		
		GameRegistry.addRecipe(new ItemStack(Initializator.DecoBlocks,1,15), "xxx","xxx","xxx", 'x', new ItemStack(Initializator.ItemIngotPlutonium));
		

		GameRegistry.addRecipe(new ItemStack(Initializator.MachineBlock, 1, 0), " D ", "DBD", "CAC", 'A', new ItemStack(Initializator.EmptyBlock), 'B', new ItemStack(Initializator.ItemDepletedCrystal), 'C', new ItemStack(Block.furnaceIdle), 'D', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(Initializator.MachineBlock, 1, 1), " D ", "DBD", "CAC", 'A', new ItemStack(Initializator.EmptyBlock), 'B', new ItemStack(Initializator.ItemGammatroniumCrystal), 'C', new ItemStack(Block.furnaceIdle), 'D', new ItemStack(Item.ingotIron));

		//new ItemStack(ItemInitializator.EmptyBlock, 4) means the result are 4 EMpty Blocks
		//" x ", "xyx", " x " is the crafting matrix
		//'y', new ItemStack(ItemInitializator.ItemIngotPlutonium) means that y, in the crafting matrix should be Plutonium ingot
		
	}

	public static void addSmelting()
	{
		GameRegistry.addSmelting(QuantumCraftSettings.OrePlutoniumID, new ItemStack(Initializator.ItemIngotPlutonium), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OrePositroniumID, new ItemStack(Initializator.ItemPositroniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreRadiumID, new ItemStack(Initializator.ItemRadiumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreGammatroniumID, new ItemStack(Initializator.ItemGammatroniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreNeutriniumID, new ItemStack(Initializator.ItemNeutriniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.PlutoniumDustID+256,  new ItemStack(Initializator.ItemIngotPlutonium), 4F);
		//QuantumCraftSettings.OrePlutoniumID is the input item
		//new ItemStack(ItemInitializator.ItemIngotPlutonium) is output
	}
	
	public static void addMod()
	{
		//addIC2();
		//addTEX();
	}
	
	public static void addIC2()
	{
		//Ic2Recipes.addMaceratorRecipe(new ItemStack(Initializator.OrePlutonium), new ItemStack(Initializator.ItemPlutoniumDust, 2));
		//Ic2Recipes.addMaceratorRecipe(new ItemStack(Initializator.ItemDepletedCrystal), new ItemStack(Initializator.ItemDepletedShard));
	}
	
//	public static void addTEX()
//	{
//		CraftingManagers.pulverizerManager.addRecipe(20,new ItemStack(Initializator.ItemDepletedCrystal), new ItemStack(Initializator.ItemDepletedShard), false);
//	}
}
