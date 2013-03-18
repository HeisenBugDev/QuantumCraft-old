package mods.quantumCraft.client;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;

public class ClientTickHandler implements ITickHandler {
	String currDamage = "";

	@Override
	public EnumSet ticks() {

		return EnumSet.of(TickType.RENDER);
	}

	public String getItemDamage(ItemStack item) {
		if (FMLCommonHandler.instance().getEffectiveSide().isClient() == true) {
			Minecraft mc = FMLClientHandler.instance().getClient();
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT
					&& mc.inGameHasFocus == true
					&& mc.thePlayer.inventory.getCurrentItem() != null
					&& mc.thePlayer.inventory.getCurrentItem()
							.isItemStackDamageable()) {
				final int damage = item.getItemDamageForDisplay();
				final int damageLeft = mc.thePlayer.inventory.getCurrentItem()
						.getMaxDamage() - damage;
				String damageString = null;
				if (damageLeft >= 300) {
					damageString = "§a"
							+ damageLeft
							+ "/"
							+ mc.thePlayer.inventory.getCurrentItem()
									.getMaxDamage();
				} else if (damageLeft >= 100) {
					damageString = "§e"
							+ damageLeft
							+ "/"
							+ mc.thePlayer.inventory.getCurrentItem()
									.getMaxDamage();
				} else if (damageLeft >= 50) {
					damageString = "§5"
							+ damageLeft
							+ "/"
							+ mc.thePlayer.inventory.getCurrentItem()
									.getMaxDamage();
				}
				return damageString;
			} else {
				return "";
			}
		} else
			return "";

	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (FMLCommonHandler.instance().getEffectiveSide().isClient() == true) {
			Minecraft mc = FMLClientHandler.instance().getClient();
			if (mc.inGameHasFocus == true
					&& FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
				ItemStack itemstack = mc.thePlayer.inventory.getCurrentItem();
				mc.fontRenderer.drawString(currDamage, 1, 1, 1);
				// mc.fontRenderer.drawString("test", 1, 1, 1);

				currDamage = getItemDamage(itemstack);

			}
		}

	}

	@Override
	public String getLabel() {
		return null;
	}

}
