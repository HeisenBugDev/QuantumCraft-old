package mods.quantumCraft.core;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class QWorldGenMinable extends WorldGenerator {
	private int mineableBlockId;
	private int mineableBlockMeta;
	private int numberOfBlocks;
	private int replace;

	public QWorldGenMinable(int blockid, int numberOfBlocks) {
		this.mineableBlockId = blockid;
		this.mineableBlockMeta = 0;
		this.numberOfBlocks = numberOfBlocks;
		this.replace = Block.stone.blockID;
	}

	public QWorldGenMinable(int blockid, int numberOfBlocks, int replace) {
		this.mineableBlockId = blockid;
		this.mineableBlockMeta = 0;
		this.numberOfBlocks = numberOfBlocks;
		this.replace = replace;
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		boolean hasGenerated = false;

		float randomBase = random.nextFloat() * 3.141593F;
		double d = i + 8 + MathHelper.sin(randomBase) * this.numberOfBlocks
				/ 8.0F;
		double d1 = i + 8 - MathHelper.sin(randomBase) * this.numberOfBlocks
				/ 8.0F;
		double d2 = k + 8 + MathHelper.cos(randomBase) * this.numberOfBlocks
				/ 8.0F;
		double d3 = k + 8 - MathHelper.cos(randomBase) * this.numberOfBlocks
				/ 8.0F;
		double d4 = j + random.nextInt(3) - 2;
		double d5 = j + random.nextInt(3) - 2;

		for (int l = 0; l <= this.numberOfBlocks; l++) {
			double d6 = d + (d1 - d) * l / this.numberOfBlocks;
			double d7 = d4 + (d5 - d4) * l / this.numberOfBlocks;
			double d8 = d2 + (d3 - d2) * l / this.numberOfBlocks;
			double d9 = random.nextDouble() * this.numberOfBlocks / 16.0D;
			double d10 = (MathHelper.sin(l * 3.141593F / this.numberOfBlocks) + 1.0F)
					* d9 + 1.0D;
			double d11 = (MathHelper.sin(l * 3.141593F / this.numberOfBlocks) + 1.0F)
					* d9 + 1.0D;
			int xStart = MathHelper.floor_double(d6 - d10 / 2.0D);
			int yStart = MathHelper.floor_double(d7 - d11 / 2.0D);
			int zStart = MathHelper.floor_double(d8 - d10 / 2.0D);
			int xEnd = MathHelper.floor_double(d6 + d10 / 2.0D);
			int yEnd = MathHelper.floor_double(d7 + d11 / 2.0D);
			int zEnd = MathHelper.floor_double(d8 + d10 / 2.0D);

			for (int targetX = xStart; targetX <= xEnd; targetX++) {
				double d12 = (targetX + 0.5D - d6) / (d10 / 2.0D);
				if (d12 * d12 < 1.0D) {
					for (int targetY = yStart; targetY <= yEnd; targetY++) {
						double d13 = (targetY + 0.5D - d7) / (d11 / 2.0D);
						if (d12 * d12 + d13 * d13 < 1.0D) {
							for (int targetZ = zStart; targetZ <= zEnd; targetZ++) {
								double d14 = (targetZ + 0.5D - d8)
										/ (d10 / 2.0D);
								if ((d12 * d12 + d13 * d13 + d14 * d14 < 1.0D)
										&& (world.getBlockId(targetX, targetY,
												targetZ) == replace)) {
									world.setBlockAndMetadataWithNotify(
											targetX, targetY, targetZ,
											this.mineableBlockId,
											this.mineableBlockMeta, 0);
									hasGenerated = true;
								}
							}
						}
					}
				}
			}
		}
		return hasGenerated;
	}
}