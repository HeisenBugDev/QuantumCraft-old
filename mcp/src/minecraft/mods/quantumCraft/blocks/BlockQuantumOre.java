package mods.quantumCraft.blocks;

import java.util.Random;

import mods.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockQuantumOre extends BlockOre {

	public BlockQuantumOre(int par1, int par2) {
		super(par1);
		GameRegistry.registerBlock(this);
	}

	// Yay, crystal now drop 3 - 6 crystals of the type

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		if (this.blockID == QuantumCraftSettings.OrePositroniumID)
			return QuantumCraftSettings.CrystalPositroniumID + 256;
		else if (this.blockID == QuantumCraftSettings.OreRadiumID)
			return QuantumCraftSettings.CrystalRadiumID + 256;
		else if (this.blockID == QuantumCraftSettings.OreGammatroniumID)
			return QuantumCraftSettings.CrystalGammatroniumID + 256;
		else if (this.blockID == QuantumCraftSettings.OreDepletedID)
			return QuantumCraftSettings.CrystalDepletedID + 256;
		else if (this.blockID == QuantumCraftSettings.OreNeutriniumID)
			return QuantumCraftSettings.CrystalNeutriniumID + 256;
		else if (this.blockID == QuantumCraftSettings.OrePlutoniumID)
			return QuantumCraftSettings.OrePlutoniumID;
		else
			return -1;

	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	
}
