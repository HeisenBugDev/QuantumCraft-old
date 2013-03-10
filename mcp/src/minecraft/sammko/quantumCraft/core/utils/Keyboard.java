package sammko.quantumCraft.core.utils;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;

public class Keyboard
{
  private Map altKeyState = new HashMap();
  private Map boostKeyState = new HashMap();
  private Map forwardKeyState = new HashMap();
  private Map modeSwitchKeyState = new HashMap();
  private Map jumpKeyState = new HashMap();
  private Map sideinventoryKeyState = new HashMap();

  public boolean isAltKeyDown(EntityPlayer player)
  {
    if (this.altKeyState.containsKey(player)) {
      return ((Boolean)this.altKeyState.get(player)).booleanValue();
    }
    return false;
  }

  public boolean isBoostKeyDown(EntityPlayer player)
  {
    if (this.boostKeyState.containsKey(player)) {
      return ((Boolean)this.boostKeyState.get(player)).booleanValue();
    }
    return false;
  }

  public boolean isForwardKeyDown(EntityPlayer player)
  {
    if (this.forwardKeyState.containsKey(player)) {
      return ((Boolean)this.forwardKeyState.get(player)).booleanValue();
    }
    return false;
  }

  public boolean isJumpKeyDown(EntityPlayer player)
  {
    if (this.jumpKeyState.containsKey(player)) {
      return ((Boolean)this.jumpKeyState.get(player)).booleanValue();
    }
    return false;
  }

  public boolean isModeSwitchKeyDown(EntityPlayer player)
  {
    if (this.modeSwitchKeyState.containsKey(player)) {
      return ((Boolean)this.modeSwitchKeyState.get(player)).booleanValue();
    }
    return false;
  }

  public boolean isSideinventoryKeyDown(EntityPlayer player)
  {
    if (this.sideinventoryKeyState.containsKey(player)) {
      return ((Boolean)this.sideinventoryKeyState.get(player)).booleanValue();
    }
    return false;
  }

  public boolean isSneakKeyDown(EntityPlayer player)
  {
    return player.isSneaking();
  }

  public void sendKeyUpdate()
  {
  }

  public void processKeyUpdate(EntityPlayer player, int keyState) {
    this.altKeyState.put(player, Boolean.valueOf((keyState & 0x1) != 0));
    this.boostKeyState.put(player, Boolean.valueOf((keyState & 0x2) != 0));
    this.forwardKeyState.put(player, Boolean.valueOf((keyState & 0x4) != 0));
    this.modeSwitchKeyState.put(player, Boolean.valueOf((keyState & 0x8) != 0));
    this.jumpKeyState.put(player, Boolean.valueOf((keyState & 0x10) != 0));
    this.sideinventoryKeyState.put(player, Boolean.valueOf((keyState & 0x20) != 0));
  }

  public void removePlayerReferences(EntityPlayer player) {
    this.altKeyState.remove(player);
    this.boostKeyState.remove(player);
    this.forwardKeyState.remove(player);
    this.modeSwitchKeyState.remove(player);
    this.jumpKeyState.remove(player);
    this.sideinventoryKeyState.remove(player);
  }
}