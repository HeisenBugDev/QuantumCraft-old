package mods.quantumCraft.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabQuantumCraft extends CreativeTabs {

	public TabQuantumCraft() {
		super(CreativeTabs.getNextID(), "QuantumCraft");
	}

	@Override
	public String getTranslatedTabLabel() {
		return "Quantum Craft"; // That fixes the ingame name on our tab ^^
	}

	@Override
	public String getTabLabel() {
		return "Quantum Craft";
	}

	@Override
	public Item getTabIconItem() {
		return Initializator.ItemGammatroniumCrystal;
	}

}
