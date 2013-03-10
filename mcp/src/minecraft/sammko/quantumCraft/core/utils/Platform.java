package sammko.quantumCraft.core.utils;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.world.IBlockAccess;

public class Platform
{
  static final LanguageRegistry languageRegistry = LanguageRegistry.instance();

  public boolean isSimulating() {
    return !FMLCommonHandler.instance().getEffectiveSide().isClient();
  }

  public boolean isRendering() {
    return !isSimulating();
  }

  public void displayError(String error) {
    throw new RuntimeException(("QC Error\n\n=== QC Error ===\n\n" + error + "\n\n===============================\n").replace("\n", System.getProperty("line.separator")));
  }

  public EntityPlayer getPlayerInstance() {
    return null;
  }

  public void messagePlayer(EntityPlayer player, String message) {
    if ((player instanceof EntityPlayerMP))
      ((EntityPlayerMP)player).playerNetServerHandler.sendPacketToPlayer(new Packet3Chat(message));
    else
      player.addChatMessage(message);
  }

  

  public void profilerStartSection(String section)
  {
  }

  public void profilerEndSection()
  {
  }

  public void profilerEndStartSection(String section)
  {
  }

  public void addLocalization(String name, String desc) {
    languageRegistry.addStringLocalization(name, desc);
  }

  public File getMinecraftDir() {
    return new File(".");
  }

  public void playSoundSp(String sound, float f, float g)
  {
  }

  public void resetPlayerInAirTime(EntityPlayer player) {
    if (!(player instanceof EntityPlayerMP)) return;
    ((EntityPlayerMP)player).playerNetServerHandler.ticksForFloatKick = 0;
  }

  public int getBlockTexture(Block block, IBlockAccess world, int x, int y, int z, int side) {
    return 0;
  }

  public int addArmor(String name) {
    return 0;
  }

  public void removePotion(EntityLiving entity, int potion) {
    entity.removePotionEffect(potion);
  }

  public int getRenderId(String name) {
    return -1;
  }
}
