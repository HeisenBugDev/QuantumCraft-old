package mods.sammko.quantumCraft.core;

import net.minecraft.stats.Achievement;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class OwnAchievement {

	static final Achievement Danger = new Achievement(100, "Danger", 1, -2,
			Initializator.ItemCrystalSword, null).setIndependent()
			.registerAchievement();
	static final Achievement Hurry = new Achievement(101, "Hurry", 2, -4,
			Initializator.ItemCrystalPickaxe, OwnAchievement.Danger)
			.registerAchievement();

	private static void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach,
				"en_US", name);

	}

	private static void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + ach + ".desc", "en_US", desc);
	}

	static void addAchievementLocalization() {
		addAchievementName("Danger", "Danger ahead");
		addAchievementDesc("Danger", "Use with caution!!!"); // for achievement
																// Danger

		addAchievementName("Hurry", "Speed Mining"); // for achievement Hurry
		addAchievementDesc("Hurry", "Quicker mining due to Ratiation");
	}

}
