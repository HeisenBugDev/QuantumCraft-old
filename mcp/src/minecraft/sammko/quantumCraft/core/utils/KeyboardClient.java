package sammko.quantumCraft.core.utils;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

@SideOnly(Side.CLIENT)
public class KeyboardClient extends Keyboard
{
  private Minecraft mc = Minecraft.getMinecraft();

  private KeyBinding altKey = new KeyBinding("ALT Key", 56);
  private KeyBinding boostKey = new KeyBinding("Boost Key", 29);
  private KeyBinding modeSwitchKey = new KeyBinding("Mode Switch Key", 50);
  private KeyBinding sideinventoryKey = new KeyBinding("Side Inventory Key", 46);
  private int lastKeyState = 0;

  public KeyboardClient()
  {
    KeyBindingRegistry.registerKeyBinding(new KeyBindingRegistry.KeyHandler(new KeyBinding[] { this.altKey, this.boostKey, this.modeSwitchKey, this.sideinventoryKey })
    {
      public String getLabel() {
        return "IC2Keyboard";
      }

      public EnumSet ticks()
      {
        return EnumSet.of(TickType.CLIENT);
      }

      public void keyUp(EnumSet types, KeyBinding kb, boolean tickEnd)
      {
      }

      public void keyDown(EnumSet types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
      }
    });
  }

  public void sendKeyUpdate() {
    int currentKeyState = (this.altKey.pressed ? 1 : 0) << 0 | (this.boostKey.pressed ? 1 : 0) << 1 | (this.mc.gameSettings.keyBindForward.pressed ? 1 : 0) << 2 | (this.modeSwitchKey.pressed ? 1 : 0) << 3 | (this.mc.gameSettings.keyBindJump.pressed ? 1 : 0) << 4 | (this.sideinventoryKey.pressed ? 1 : 0) << 5;

    if (currentKeyState != this.lastKeyState) {
      super.processKeyUpdate(Utils.platform.getPlayerInstance(), currentKeyState);
      this.lastKeyState = currentKeyState;
    }
  }
}
