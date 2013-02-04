package sammko.quantumCraft.machine.gui;

import org.lwjgl.opengl.GL11;

import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.machine.ExtractorContainer;
import sammko.quantumCraft.machine.TileEntityExtractor;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;


public class GuiExtractor extends GuiContainer {

	TileEntityExtractor te;

	public GuiExtractor(InventoryPlayer ip, TileEntityExtractor tee) {
		super(new ExtractorContainer(ip, tee));
		this.te = tee;
	}

	public void initGui()
	{
		super.initGui();
		this.controlList.clear();
	
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //the parameters for drawString are: string, x, y, color
            fontRenderer.drawString("Quantum Extractor", 45, 6, 4210752);
            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        int texture = mc.renderEngine.getTexture(QuantumCraftSettings.BGextractorGUI);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		int t;
        
        t = this.te.getFuelScaled(14);
        this.drawTexturedModalRect(x + 63, y + 62 - t, 176, 14 - t, 14, t);
        
        t = this.te.getCookProgressScaled(24);
        this.drawTexturedModalRect(x + 58, y + 30, 176, 14, t, 15);
        
	}

}
