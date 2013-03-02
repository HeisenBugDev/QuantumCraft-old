package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.item.ItemFood;

public class RadioactiveMeat extends ItemFood {
	public RadioactiveMeat(int id, int hunger, float saturation,
			boolean wolfFavorite) {
		super(id, hunger, saturation, wolfFavorite);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}
}
