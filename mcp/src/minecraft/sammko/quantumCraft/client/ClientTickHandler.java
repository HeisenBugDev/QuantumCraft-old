package sammko.quantumCraft.client;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import sammko.quantumCraft.core.QuantumCraftSettings;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientTickHandler implements ITickHandler {
	@SideOnly(Side.CLIENT)
	public static Minecraft mc = ModLoader.getMinecraftInstance();
	

	public EnumSet ticks() {
		
		return EnumSet.of(TickType.CLIENT);
	}
	
	public String getItemDamage(ItemStack item) {
	
		if (mc.inGameHasFocus == true && mc.thePlayer.inventory.getCurrentItem() != null && mc.thePlayer.inventory.getCurrentItem().itemID == QuantumCraftSettings.CrystalPickaxeID + 256 ) {
			final int damage = item.getItemDamageForDisplay();
			final int damageLeft = 500-damage;
			String damageString = null;
			if (damageLeft >= 300){
				damageString = "Â§a" + damageLeft + "/500";
			}
			else if (damageLeft >= 100){
				damageString = "Â§e" + damageLeft + "/500";
			}
			else if (damageLeft >= 50){
				damageString = "Â§5" + damageLeft + "/500";
			}
			return damageString;
		}else{
			return "";
		}
		
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
	

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if((type.contains(TickType.CLIENT))&& (mc.theWorld != null)) {
		if (mc.inGameHasFocus == true) {
			ItemStack itemstack = mc.thePlayer.inventory.getCurrentItem();
			mc.fontRenderer.drawString(getItemDamage(itemstack), 1, 1, 1);
			//mc.fontRenderer.drawString("test", 1, 1, 1);
		}
		}
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
