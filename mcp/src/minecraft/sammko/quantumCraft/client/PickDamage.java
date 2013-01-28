package sammko.quantumCraft.client;

import sammko.quantumCraft.items.ItemInitializator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.entity.player.EntityPlayer;
public class PickDamage {
	 public static Minecraft mc = ModLoader.getMinecraftInstance();
	 public static void sendPlayerMessage(EntityPlayer player, String message) {
		    if (!mc.theWorld.isRemote)
		      player.addChatMessage(message);
		  }
	 
	public String getItemDamage(EntityPlayer e,ItemStack item){
		final int damage = item.getItemDamageForDisplay();
		String damageString = damage + "";
		return damageString;
	}
}
