
package thermalexpansion.core.gui;

import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

import thermalexpansion.core.PropsCore;
import thermalexpansion.core.utils.SessionVars;
import cpw.mods.fml.client.FMLClientHandler;

public abstract class Tab {

    protected static FontRenderer tabFontRenderer = FMLClientHandler.instance().getClient().fontRenderer;
    protected static SoundManager tabSoundManager = FMLClientHandler.instance().getClient().sndManager;

    private boolean open;

    protected Gui myGui;
    protected boolean leftSide;
    protected int overlayColor = 0xffffff;

    public int currentShiftX = 0;
    public int currentShiftY = 0;

    protected int limitWidth = 128;
    protected int maxWidth = 124;
    protected int minWidth = 22;
    protected int currentWidth = minWidth;

    protected int maxHeight = 22;
    protected int minHeight = 22;
    protected int currentHeight = minHeight;

    public Tab(Gui gui) {

        myGui = gui;
    }

    public abstract void draw(int x, int y);

    protected void drawBackground(int x, int y) {

        float colorR = (overlayColor >> 16 & 255) / 255.0F;
        float colorG = (overlayColor >> 8 & 255) / 255.0F;
        float colorB = (overlayColor & 255) / 255.0F;

        GL11.glColor4f(colorR, colorG, colorB, 1.0F);

        if (leftSide) {
            ForgeHooksClient.bindTexture(PropsCore.PATH_GUI + "tab_left.png", 0);

            myGui.drawTexturedModalRect(x - currentWidth, y + 4, 0, 256 - currentHeight + 4, 4, currentHeight - 4);
            myGui.drawTexturedModalRect(x - currentWidth + 4, y, 256 - currentWidth + 4, 0, currentWidth - 4, 4);
            myGui.drawTexturedModalRect(x - currentWidth, y, 0, 0, 4, 4);
            myGui.drawTexturedModalRect(x - currentWidth + 4, y + 4, 256 - currentWidth + 4, 256 - currentHeight + 4, currentWidth - 4, currentHeight - 4);
        } else {
            ForgeHooksClient.bindTexture(PropsCore.PATH_GUI + "tab_right.png", 0);

            myGui.drawTexturedModalRect(x, y, 0, 256 - currentHeight, 4, currentHeight);
            myGui.drawTexturedModalRect(x + 4, y, 256 - currentWidth + 4, 0, currentWidth - 4, 4);
            myGui.drawTexturedModalRect(x, y, 0, 0, 4, 4);
            myGui.drawTexturedModalRect(x + 4, y + 4, 256 - currentWidth + 4, 256 - currentHeight + 4, currentWidth - 4, currentHeight - 4);
        }

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0F);
    }

    protected void drawIcon(String texture, int iconIndex, int x, int y) {

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0F);
        ForgeHooksClient.bindTexture(texture, 0);
        int textureRow = iconIndex >> 4;
        int textureColumn = iconIndex - 16 * textureRow;
        myGui.drawTexturedModalRect(x, y, 16 * textureColumn, 16 * textureRow, 16, 16);

    }

    public int getHeight() {

        return currentHeight;
    }

    public abstract String getTooltip();

    public boolean handleMouseClicked(int x, int y, int mouseButton) {

        return false;
    }

    public boolean intersectsWith(int mouseX, int mouseY, int shiftX, int shiftY) {

        if (leftSide) {
            if (mouseX <= shiftX && mouseX >= shiftX - currentWidth && mouseY >= shiftY && mouseY <= shiftY + currentHeight) {
                return true;
            }
        } else if (mouseX >= shiftX && mouseX <= shiftX + currentWidth && mouseY >= shiftY && mouseY <= shiftY + currentHeight) {
            return true;
        }
        return false;
    }

    protected boolean isFullyOpened() {

        return currentWidth >= maxWidth;
    }

    public boolean isOpen() {

        return open;
    }

    public boolean isVisible() {

        return true;
    }

    public void setFullyOpen() {

        open = true;
        currentWidth = maxWidth;
        currentHeight = maxHeight;
    }

    public void toggleOpen() {

        if (open) {
            open = false;
            if (leftSide) {
                SessionVars.setOpenedLeftTab(null);
            } else {
                SessionVars.setOpenedRightTab(null);
            }
        } else {
            open = true;
            if (leftSide) {
                SessionVars.setOpenedLeftTab(this.getClass());
            } else {
                SessionVars.setOpenedRightTab(this.getClass());
            }
        }
    }

    public void update() {

        if (open && currentWidth < maxWidth) {
            currentWidth += 8;
        } else if (!open && currentWidth > minWidth) {
            currentWidth -= 8;
        }

        if (currentWidth > maxWidth) {
            currentWidth = maxWidth;
        } else if (currentWidth < minWidth) {
            currentWidth = minWidth;
        }

        if (open && currentHeight < maxHeight) {
            currentHeight += 8;
        } else if (!open && currentHeight > minHeight) {
            currentHeight -= 8;
        }

        if (currentHeight > maxHeight) {
            currentHeight = maxHeight;
        } else if (currentHeight < minHeight) {
            currentHeight = minHeight;
        }
    }
}