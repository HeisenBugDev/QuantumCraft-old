package mods.sammko.quantumCraft.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract interface IItemTickListener {
	public abstract boolean onTick(EntityPlayer paramEntityPlayer,
			ItemStack paramItemStack);
}
