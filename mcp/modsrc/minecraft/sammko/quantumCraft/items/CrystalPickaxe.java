package sammko.quantumCraft.items;

import sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class CrystalPickaxe extends ItemPickaxe{
	public CrystalPickaxe(int i, EnumToolMaterial enumToolMaterial){
		super(i, enumToolMaterial);
		this.setTextureFile(QuantumCraftSettings.ITEMS_PNG);
	}
	
}
