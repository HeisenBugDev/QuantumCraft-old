package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class CrystalShovel extends ItemSpade {

	public CrystalShovel(int i, EnumToolMaterial enumToolMaterial) {
		super(i, enumToolMaterial);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}

}
