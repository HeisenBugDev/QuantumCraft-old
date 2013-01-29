package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class CrystalAxe extends ItemAxe {

	public CrystalAxe(int i, EnumToolMaterial EnumToolMaterial) {
		super(i, EnumToolMaterial);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}

}
