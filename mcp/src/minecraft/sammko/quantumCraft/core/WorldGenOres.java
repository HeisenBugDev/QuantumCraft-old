package sammko.quantumCraft.core;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;


public class WorldGenOres implements IWorldGenerator {

	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		//TODO: check if blocks were Stone, replace only then.
		//BUG: blocks spawn in midair
		world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(32), chunkZ*16 + random.nextInt(16), QuantumCraftSettings.OrePositroniumID);
		world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(32), chunkZ*16 + random.nextInt(16), QuantumCraftSettings.OrePlutoniumID);
		world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(32), chunkZ*16 + random.nextInt(16), QuantumCraftSettings.OreRadiumID);
		world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(32), chunkZ*16 + random.nextInt(16), QuantumCraftSettings.OreGammatroniumID);
		world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(32), chunkZ*16 + random.nextInt(16), QuantumCraftSettings.OreNeutriniumID);
		
	}


}
