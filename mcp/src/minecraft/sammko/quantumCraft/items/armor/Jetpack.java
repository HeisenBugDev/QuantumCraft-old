package sammko.quantumCraft.items.armor;
import java.util.List;

import sammko.quantumCraft.core.IItemTickListener;
import sammko.quantumCraft.core.Initializator;
import sammko.quantumCraft.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Jetpack extends ItemArmorUtility implements IItemTickListener {

	private static boolean lastJetpackUsed = false;

	public Jetpack(int id, int spriteIndex, int armorrendering) {
		super(id, spriteIndex, armorrendering, 1);

		setMaxDamage(18002);
	}

	public int getCharge(ItemStack itemStack) {
		int ret = getMaxCharge(itemStack) - itemStack.getItemDamage() - 1;

		return ret > 0 ? ret : 0;
	}

	public int getMaxCharge(ItemStack itemStack) {
		return itemStack.getMaxDamage() - 2;
	}

	public void use(ItemStack itemStack, int amount) {
		int newCharge = getCharge(itemStack) - amount;
		if (newCharge < 0)
			newCharge = 0;

		itemStack.setItemDamage(1 + itemStack.getMaxDamage() - newCharge);
	}

	public boolean useJetpack(EntityPlayer player, boolean hoverMode) {
		ItemStack jetpack = player.inventory.armorInventory[2];

		if (getCharge(jetpack) == 0)
			return false;

		boolean electric = jetpack.itemID != 0;

		float power = 1.0F;
		float dropPercentage = 0.2F;

		if (electric) {
			power = 0.7F;
			dropPercentage = 0.05F;
		}

		if (getCharge(jetpack) / getMaxCharge(jetpack) <= dropPercentage) {
			power *= getCharge(jetpack)
					/ (getMaxCharge(jetpack) * dropPercentage);
		}

		if (Utils.keyboard.isForwardKeyDown(player)) {
			float retruster = 0.15F;

			if (hoverMode)
				retruster = 0.5F;
			if (electric)
				retruster += 0.15F;

			float forwardpower = power * retruster * 2.0F;

			if (forwardpower > 0.0F) {
				player.moveFlying(0.0F, 0.4F * forwardpower, 0.02F);
			}

		}

		int worldHeight = Utils.getWorldHeight(player.worldObj);
		int maxFlightHeight = electric ? (int) (worldHeight / 1.28F)
				: worldHeight;

		double y = player.posY;

		if (y > maxFlightHeight - 25) {
			if (y > maxFlightHeight)
				y = maxFlightHeight;

			power = (float) (power * ((maxFlightHeight - y) / 25.0D));
		}

		double prevmotion = player.motionY;
		player.motionY = Math.min(player.motionY + power * 0.2F,
				0.6000000238418579D);

		if (hoverMode) {
			float maxHoverY = -0.1F;

			if ((electric) && (Utils.keyboard.isJumpKeyDown(player))) {
				maxHoverY = 0.1F;
			}

			if (player.motionY > maxHoverY) {
				player.motionY = maxHoverY;

				if (prevmotion > player.motionY)
					player.motionY = prevmotion;
			}
		}

		int consume = 9;

		if (hoverMode)
			consume = 6;
		if (electric)
			consume -= 2;

		use(jetpack, consume);

		player.fallDistance = 0.0F;
		player.distanceWalkedModified = 0.0F;

		Utils.platform.resetPlayerInAirTime(player);

		return true;
	}

	public boolean onTick(EntityPlayer player, ItemStack itemStack) {
		NBTTagCompound nbtData = Utils.getOrCreateNbtData(itemStack);
		boolean hoverMode = nbtData.getBoolean("hoverMode");
		byte toggleTimer = nbtData.getByte("toggleTimer");
		boolean jetpackUsed = false;

		if ((Utils.keyboard.isJumpKeyDown(player))
				&& (Utils.keyboard.isModeSwitchKeyDown(player))
				&& (toggleTimer == 0)) {
			toggleTimer = 10;
			hoverMode = !hoverMode;

			if (Utils.platform.isSimulating()) {
				nbtData.setBoolean("hoverMode", hoverMode);

				if (hoverMode)
					Utils.platform.messagePlayer(player, "Hover Mode enabled.");
				else {
					Utils.platform.messagePlayer(player, "Hover Mode disabled.");
				}
			}
		}

		if ((Utils.keyboard.isJumpKeyDown(player))
				|| ((hoverMode) && (player.motionY < -0.3499999940395355D))) {
			jetpackUsed = useJetpack(player, hoverMode);
		}

		if ((Utils.platform.isSimulating()) && (toggleTimer > 0)) {
			toggleTimer = (byte) (toggleTimer - 1);

			nbtData.setByte("toggleTimer", toggleTimer);
		}

		if ((Utils.platform.isRendering())
				&& (player == Utils.platform.getPlayerInstance())) {
			if (lastJetpackUsed != jetpackUsed) {

				lastJetpackUsed = jetpackUsed;
			}

	
		}

		return jetpackUsed;
	}

	public void getSubItems(int i, CreativeTabs tabs, List itemList) {
		itemList.add(new ItemStack(this, 1, 1));
	}
}
