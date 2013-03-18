package mods.quantumCraft.core;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator {

	byte heightTreshold = 45;

	private QWorldGenMinable PosGen;
	private QWorldGenMinable RadGen;
	private QWorldGenMinable GamGen;
	private QWorldGenMinable NeuGen;
	private QWorldGenMinable DepGen;
	private QWorldGenMinable PluGen;

	@Override
	public void generate(Random random, int xo, int zo, World w,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		this.PosGen = new QWorldGenMinable(
				Initializator.OrePositronium.blockID, 6);
		this.RadGen = new QWorldGenMinable(Initializator.OreRadium.blockID, 6);
		this.GamGen = new QWorldGenMinable(
				Initializator.OreGammatronium.blockID, 6);
		this.NeuGen = new QWorldGenMinable(Initializator.OreNeutrinium.blockID,
				6);
		this.DepGen = new QWorldGenMinable(Initializator.OreDepleted.blockID, 6);
		this.PluGen = new QWorldGenMinable(Initializator.OrePlutonium.blockID,
				6);

		xo <<= 4;
		zo <<= 4;

		if (QuantumCraftSettings.WGenPos) {
			for (int i = 0; i < 10; i++) {
				int randPosX = xo + random.nextInt(16);
				int randPosY = random.nextInt(heightTreshold);
				int randPosZ = zo + random.nextInt(16);
				this.PosGen.generate(w, random, randPosX, randPosY, randPosZ);
				if (QuantumCraftSettings.debug)
					System.out.println("[QuantumCraft][WGEN]POS@x=" + randPosX
							+ ";y=" + randPosY + ";z=" + randPosZ);
			}
		}
		if (QuantumCraftSettings.WGenRad) {
			for (int i = 0; i < 10; i++) {
				int randPosX = xo + random.nextInt(16);
				int randPosY = random.nextInt(heightTreshold);
				int randPosZ = zo + random.nextInt(16);
				this.RadGen.generate(w, random, randPosX, randPosY, randPosZ);
				if (QuantumCraftSettings.debug)
					System.out.println("[QuantumCraft][WGEN]RAD@ x=" + randPosX
							+ ";y=" + randPosY + ";z=" + randPosZ);
			}
		}
		if (QuantumCraftSettings.WGenGam) {
			for (int i = 0; i < 10; i++) {
				int randPosX = xo + random.nextInt(16);
				int randPosY = random.nextInt(heightTreshold);
				int randPosZ = zo + random.nextInt(16);
				this.GamGen.generate(w, random, randPosX, randPosY, randPosZ);
				if (QuantumCraftSettings.debug)
					System.out.println("[QuantumCraft][WGEN]GAM@ x=" + randPosX
							+ ";y=" + randPosY + ";z=" + randPosZ);
			}
		}
		if (QuantumCraftSettings.WGenNeu) {
			for (int i = 0; i < 10; i++) {
				int randPosX = xo + random.nextInt(16);
				int randPosY = random.nextInt(heightTreshold);
				int randPosZ = zo + random.nextInt(16);
				this.NeuGen.generate(w, random, randPosX, randPosY, randPosZ);
				if (QuantumCraftSettings.debug)
					System.out.println("[QuantumCraft][WGEN]NEU@ x=" + randPosX
							+ ";y=" + randPosY + ";z=" + randPosZ);
			}
		}
		if (QuantumCraftSettings.WGenDep) {
			for (int i = 0; i < 2; i++) {
				int randPosX = xo + random.nextInt(16);
				int randPosY = random.nextInt(heightTreshold);
				int randPosZ = zo + random.nextInt(16);
				this.DepGen.generate(w, random, randPosX, randPosY, randPosZ);
				if (QuantumCraftSettings.debug)
					System.out.println("[QuantumCraft][WGEN]DEP@ x=" + randPosX
							+ ";y=" + randPosY + ";z=" + randPosZ);
			}
		}
		if (QuantumCraftSettings.WGenPlu) {
			for (int i = 0; i < 10; i++) {
				int randPosX = xo + random.nextInt(16);
				int randPosY = random.nextInt(heightTreshold);
				int randPosZ = zo + random.nextInt(16);
				this.PluGen.generate(w, random, randPosX, randPosY, randPosZ);
				if (QuantumCraftSettings.debug)
					System.out.println("[QuantumCraft][WGEN]PLU@ x=" + randPosX
							+ ";y=" + randPosY + ";z=" + randPosZ);
			}
		}

	}
}
