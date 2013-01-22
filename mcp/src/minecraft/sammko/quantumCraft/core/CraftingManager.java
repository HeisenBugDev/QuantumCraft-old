package sammko.quantumCraft.core;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import sammko.quantumCraft.items.ItemInitializator;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	public static void addCrafting()
	{
		GameRegistry.addRecipe(new ItemStack(ItemInitializator.EmptyBlock, 1), " x ", "xyx", " x ", 'x', new ItemStack(ItemInitializator.ItemIngotPlutonium), 'y', new ItemStack(Block.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemInitializator.ItemEmptyEnergyPacket,4), new ItemStack(ItemInitializator.ItemIngotPlutonium), new ItemStack(ItemInitializator.ItemIngotPlutonium) );
	
	}

	public static void addSmelting()
	{
		GameRegistry.addSmelting(QuantumCraftSettings.OrePlutoniumID, new ItemStack(ItemInitializator.ItemIngotPlutonium), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OrePositroniumID, new ItemStack(ItemInitializator.ItemPositroniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreRadiumID, new ItemStack(ItemInitializator.ItemRadiumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreGammatroniumID, new ItemStack(ItemInitializator.ItemGammatroniumCrystal), 4F);
		GameRegistry.addSmelting(QuantumCraftSettings.OreNeutriniumID, new ItemStack(ItemInitializator.ItemNeutriniumCrystal), 4F);
	
	}
}
