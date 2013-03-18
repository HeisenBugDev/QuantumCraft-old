package mods.quantumCraft.items;

import java.util.List;

import mods.quantumCraft.core.Initializator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

public class RadioactiveMeat extends ItemFood {
	public RadioactiveMeat(int id, int hunger, float saturation,
			boolean wolfFavorite) {
		super(id, hunger, saturation, wolfFavorite);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List list, boolean flag) {
		// Add special tooltip in tribute to DireWolf
		if (itemstack != null
				&& itemstack.itemID == Initializator.ItemRadioactiveMeat.itemID) {
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)
					|| Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
				list.add("You shall die");
			}
		}
		list.add("(Hold Shift)");

		super.addInformation(itemstack, player, list, flag);
	}
}
