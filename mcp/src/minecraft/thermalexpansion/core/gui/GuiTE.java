
package thermalexpansion.core.gui;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import thermalexpansion.core.utils.SessionVars;

public abstract class GuiTE extends GuiContainer {

    protected static enum SlotColor {
        BLUE, RED, YELLOW, ORANGE, GREEN, PURPLE;
    }

    protected static enum SlotType {
        SINGLE, OUTPUT, DOUBLEOUTPUT;
    }

    protected static enum SlotRender {
        TOP, BOTTOM, FULL;
    }

    protected static int SCALE_ENERGY = 42;
    protected static int SCALE_LIQUID = 60;
    protected static int SCALE_PROGRESS = 24;
    protected static int SCALE_SPEED = 16;

    protected ArrayList<Tab> tabListLeft = new ArrayList<Tab>();
    protected ArrayList<Tab> tabListRight = new ArrayList<Tab>();

    protected int mouseX = 0;
    protected int mouseY = 0;

    public static boolean enableGuiBorders;
    public static boolean enableInfoTabs;
    public static boolean enableTutorialTabs;

    public GuiTE(Container container) {

        super(container);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        drawTabs(mouseX, mouseY);
        drawTooltips();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    protected abstract void drawTooltips();

    /* DRAW FUNCTIONS */
    protected void drawColoredSlot(int x, int y, SlotColor color, SlotType type, SlotRender render) {

        if (enableGuiBorders) {
            drawColoredSlotWithBorder(x, y, color, type, render);
        } else {
            drawColoredSlotNoBorder(x, y, color, type, render);
        }
    }

    protected void drawColoredSlotNoBorder(int x, int y, SlotColor color, SlotType type, SlotRender render) {

        int sizeX = 0;
        int sizeY = 0;
        int offsetX = color.ordinal() / 3 * 128;
        int offsetY = color.ordinal() % 3 * 32;

        switch (type) {
        case SINGLE:
            sizeX = 16;
            sizeY = 16;
            offsetX += 8;
            offsetY += 8;
            break;
        case OUTPUT:
            sizeX = 24;
            sizeY = 24;
            offsetX += 36;
            offsetY += 4;
            break;
        case DOUBLEOUTPUT:
            sizeX = 42;
            sizeY = 24;
            offsetX += 75;
            offsetY += 4;
            break;
        }

        switch (render) {
        case TOP:
            sizeY /= 2;
            break;
        case BOTTOM:
            sizeY /= 2;
            y += sizeY;
            offsetY += sizeY;
            break;
        case FULL:
            break;
        }

        drawTexturedModalRect(x, y, offsetX, offsetY, sizeX, sizeY);
    }

    protected void drawColoredSlotWithBorder(int x, int y, SlotColor color, SlotType type, SlotRender render) {

        int sizeX = 32;
        int sizeY = 32;
        int offsetX = color.ordinal() / 3 * 128;
        int offsetY = color.ordinal() % 3 * 32;

        offsetX += type.ordinal() * 32;

        if (type.ordinal() == 2) {
            sizeX = 64;
        }

        switch (type) {
        case SINGLE:
            x -= 8;
            y -= 8;
            break;
        case OUTPUT:
            x -= 4;
            y -= 4;
            break;
        case DOUBLEOUTPUT:
            x -= 11;
            y -= 4;
            break;
        }

        switch (render) {
        case TOP:
            sizeY /= 2;
            break;
        case BOTTOM:
            sizeY /= 2;
            y += sizeY;
            offsetY += sizeY;
            break;
        case FULL:
            break;
        }

        drawTexturedModalRect(x, y, offsetX, offsetY, sizeX, sizeY);
    }

    protected void drawColoredLiquidSlot(int x, int y, SlotColor color) {

        if (enableGuiBorders) {
            drawColoredLiquidSlotWithBorder(x, y, color);
        } else {
            drawColoredLiquidSlotNoBorder(x, y, color);
        }
    }

    protected void drawColoredLiquidSlotNoBorder(int x, int y, SlotColor color) {

        int sizeX = 16;
        int sizeY = 60;
        int offsetX = color.ordinal() * 32;
        int offsetY = 96;

        drawTexturedModalRect(x, y, offsetX + 8, offsetY + 2, sizeX, sizeY);
    }

    protected void drawColoredLiquidSlotWithBorder(int x, int y, SlotColor color) {

        int sizeX = 32;
        int sizeY = 64;
        int offsetX = color.ordinal() * 32;
        int offsetY = 96;

        drawTexturedModalRect(x - 8, y - 2, offsetX, offsetY, sizeX, sizeY);
    }

    protected void drawLiquid(int j, int k, int liquidId, int liquidMeta, int width, int height) {

        int liquidImgIndex = 0;

        if (liquidId < Block.blocksList.length && Block.blocksList[liquidId] != null) {
            ForgeHooksClient.bindTexture(Block.blocksList[liquidId].getTextureFile(), 0);
            liquidImgIndex = Block.blocksList[liquidId].getBlockTextureFromSideAndMetadata(0, liquidMeta);
        } else if (Item.itemsList[liquidId] != null) {
            ForgeHooksClient.bindTexture(Item.itemsList[liquidId].getTextureFile(), 0);
            liquidImgIndex = Item.itemsList[liquidId].getIconFromDamage(liquidMeta);
        }

        int imgLine = liquidImgIndex / 16;
        int imgColumn = liquidImgIndex - imgLine * 16;

        int x = 0;
        int y = 0;

        int drawHeight = 0;
        int drawWidth = 0;

        for (x = 0; x < width; x += 16) {
            for (y = 0; y < height; y += 16) {

                drawWidth = Math.min(width - x, 16);
                drawHeight = Math.min(height - y, 16);

                drawTexturedModalRect(j + x, k + y, imgColumn * 16, imgLine * 16, drawWidth, drawHeight);
            }
        }
    }

    protected void drawTooltip(String tooltip) {

        drawCreativeTabHoveringText(tooltip, mouseX, mouseY);
    }

    /* UTILITY FUNCTIONS */
    protected int getCenteredOffset(String string) {

        return this.getCenteredOffset(string, xSize);
    }

    protected int getCenteredOffset(String string, int xWidth) {

        return (xWidth - fontRenderer.getStringWidth(string)) / 2;
    }

    @Override
    protected void mouseClicked(int x, int y, int mouseButton) {

        super.mouseClicked(x, y, mouseButton);

        Tab tab = getTabAtPosition(mouseX, mouseY);

        if (tab != null && !tab.handleMouseClicked(mouseX, mouseY, mouseButton)) {

            if (tab.leftSide) {
                for (Tab other : tabListLeft) {
                    if (other != tab && other.isOpen()) {
                        other.toggleOpen();
                    }
                }
            } else {
                for (Tab other : tabListRight) {
                    if (other != tab && other.isOpen()) {
                        other.toggleOpen();
                    }
                }
            }
            tab.toggleOpen();
        }
    }

    @Override
    public void handleMouseInput() {

        int x = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int y = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        mouseX = x - (width - xSize) / 2;
        mouseY = y - (height - ySize) / 2;

        super.handleMouseInput();
    }

    /* TAB MANAGEMENT */
    public void addTab(Tab tab) {

        if (tab.leftSide) {

            tabListLeft.add(tab);
            if (SessionVars.getOpenedLeftTab() != null && tab.getClass().equals(SessionVars.getOpenedLeftTab())) {
                tab.setFullyOpen();
            }
        } else {

            tabListRight.add(tab);
            if (SessionVars.getOpenedRightTab() != null && tab.getClass().equals(SessionVars.getOpenedRightTab())) {
                tab.setFullyOpen();
            }
        }
    }

    protected void drawTabs(int mX, int mY) {

        int yPosRight = 4;
        int yPosLeft = 4;

        for (Tab tab : tabListLeft) {

            tab.update();
            if (!tab.isVisible()) {
                continue;
            }
            tab.draw(0, yPosLeft);
            yPosLeft += tab.getHeight();
        }

        for (Tab tab : tabListRight) {

            tab.update();
            if (!tab.isVisible()) {
                continue;
            }

            tab.draw(xSize, yPosRight);
            yPosRight += tab.getHeight();
        }

        Tab tab = getTabAtPosition(mX, mY);
        if (tab != null) {
            String tooltip = tab.getTooltip();
            if (tooltip != null) {
                drawTooltip(tooltip);
            }
        }
    }

    protected Tab getTabAtPosition(int mX, int mY) {

        int xShift = 0;
        int yShift = 4;

        for (int i = 0; i < tabListLeft.size(); ++i) {
            Tab tab = tabListLeft.get(i);
            if (!tab.isVisible()) {
                continue;
            }

            tab.currentShiftX = xShift;
            tab.currentShiftY = yShift;
            if (tab.intersectsWith(mX, mY, xShift, yShift)) {
                return tab;
            }
            yShift += tab.getHeight();
        }

        xShift = xSize;
        yShift = 4;

        for (int i = 0; i < tabListRight.size(); ++i) {
            Tab tab = tabListRight.get(i);
            if (!tab.isVisible()) {
                continue;
            }

            tab.currentShiftX = xShift;
            tab.currentShiftY = yShift;
            if (tab.intersectsWith(mX, mY, xShift, yShift)) {
                return tab;
            }
            yShift += tab.getHeight();
        }

        return null;
    }
}