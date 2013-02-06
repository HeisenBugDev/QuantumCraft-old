package sammko.quantumCraft.core;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import sammko.quantumCraft.items.ItemInitializator;

public class OwnAchievement {
	
	static final Achievement Danger = new Achievement(100, "Danger", 1, -2, ItemInitializator.ItemCrystalSword, null).setIndependent().registerAchievement();
	static final Achievement Hurry = new Achievement(101, "Hurry", 2, -4, ItemInitializator.ItemCrystalPickaxe, OwnAchievement.Danger).registerAchievement();
	
	
	private static void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
		
	}
	private static void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
	
	static void addAchievementLocalization() {
		addAchievementName("Danger", "Danger ahead");
		addAchievementDesc("Danger", "Use with caution!!!");	//for achievement Danger
		
		addAchievementName("Hurry", "Speed Mining");			//for achievement Hurry
		addAchievementDesc("Hurry", "Quicker mining due to Ratiation");
	}
	
	
}
