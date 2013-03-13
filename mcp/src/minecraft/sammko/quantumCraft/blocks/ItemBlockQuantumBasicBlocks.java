package sammko.quantumCraft.blocks;

import sammko.quantumCraft.core.Initializator;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockQuantumBasicBlocks extends ItemBlock {

	public ItemBlockQuantumBasicBlocks(int par1) {
		super(par1);
		setHasSubtypes(true);
		setUnlocalizedName("iBlockQuantumBasicBlocks");
		setCreativeTab(Initializator.tabQC);
	}

	private final static String[] subNames = {
		"PosFullBlock", "RadFullBlock",  "GamFullBlock", "NeuFullBlock", "DepFullBlock", "PosBrickBlock",
		"RadBrickBlock", "GamBrickBlock", "NeuBrickBlock", "DepBrickBlock", "PosSBrickBlock", "RadSBrickBlock", "GamSBrickBlock",
		"NeuSBrickBlock", "DepSBrickBlock", "PluBlock"
	};
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	
}
