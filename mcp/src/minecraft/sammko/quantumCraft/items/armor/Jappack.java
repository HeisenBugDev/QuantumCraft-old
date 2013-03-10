package sammko.quantumCraft.items.armor;

import ic2.api.ElectricItem;
import ic2.api.IElectricItem;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Jappack extends Jetpack implements IElectricItem {
	public Jappack(int id, int index, int armorrendering)
	  {
	    super(id, index, armorrendering);

	    setMaxDamage(27);
	    setMaxStackSize(1);
	  }

	  public int getCharge(ItemStack itemStack)
	  {
	    return ElectricItem.discharge(itemStack, 2147483647, 2147483647, true, true);
	  }

	  public void use(ItemStack itemStack, int amount)
	  {
	    ElectricItem.discharge(itemStack, amount, 2147483647, true, false);
	  }

	  public boolean canProvideEnergy()
	  {
	    return true;
	  }

	  public int getChargedItemId()
	  {
	    return this.itemID;
	  }

	  public int getEmptyItemId()
	  {
	    return this.itemID;
	  }

	  public int getMaxCharge()
	  {
	    return 30000;
	  }

	  public int getTier()
	  {
	    return 1;
	  }

	  public int getTransferLimit()
	  {
	    return 60;
	  }

	
}
