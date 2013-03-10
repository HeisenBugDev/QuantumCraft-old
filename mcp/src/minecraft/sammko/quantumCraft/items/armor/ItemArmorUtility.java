package sammko.quantumCraft.items.armor;

import sammko.quantumCraft.core.Initializator;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;

public class ItemArmorUtility extends ItemArmor
implements ISpecialArmor
{
public ItemArmorUtility(int id, int spriteIndex, int renderIndex, int type)
{
  super(id, EnumArmorMaterial.DIAMOND, renderIndex, type);

  this.iconIndex = spriteIndex;
  setCreativeTab(Initializator.tabQC);
}

public int getItemEnchantability()
{
  return 0;
}

public boolean isRepairable()
{
  return false;
}

public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
{
  return false;
}

public String getTextureFile()
{
  return "/ic2/sprites/item_0.png";
}

public ISpecialArmor.ArmorProperties getProperties(EntityLiving player, ItemStack armor, DamageSource source, double damage, int slot)
{
  return new ISpecialArmor.ArmorProperties(0, 0.0D, 0);
}

public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
{
  return 0;
}

public void damageArmor(EntityLiving entity, ItemStack stack, DamageSource source, int damage, int slot)
{
}
}
