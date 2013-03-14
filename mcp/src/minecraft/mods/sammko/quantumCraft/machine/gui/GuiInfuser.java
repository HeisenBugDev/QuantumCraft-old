package mods.sammko.quantumCraft.machine.gui;

import mods.sammko.quantumCraft.core.QuantumCraftSettings;
import mods.sammko.quantumCraft.machine.InfuserContainer;
import mods.sammko.quantumCraft.machine.TileEntityInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiInfuser extends GuiContainer {
	TileEntityInfuser te;
	InfuserContainer e;

	public GuiInfuser(InventoryPlayer ip, TileEntityInfuser tee) {
		super(new InfuserContainer(ip, tee));
		this.te = tee;
		e = new InfuserContainer(ip, tee);
	}

	@Override
	public void initGui() {
		super.initGui();

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		// the parameters for drawString are: string, x, y, color
		// fontRenderer.drawString("Quantum Reactor", 45, 6, 0x000000);
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 96 + 2, 0x000000);
		fontRenderer.drawString("Quantum Gamma Infuser", 45, 6, 0x000000);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		int texture = mc.renderEngine
				.getTexture(QuantumCraftSettings.BGinfuserGUI);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		// this.mc.renderEngine.bindTexture(texture);

		this.mc.renderEngine.func_98187_b("/gui/Infuser.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		int t = 0;
		int t2 = 0;
		e.detectAndSendChanges();

		// t = Utils.Scale(42, 100 - te.getChargeState(), 16000);
		t = te.gaugeFuelScaled(16, 42);
		this.drawTexturedModalRect(x + 49, y + 18, 176, 0, t, 6); // 49@18
		// t2 = Utils.Scale(24, te.progress, 20);
		t2 = te.gaugeProgressScaled(100, 24);
		this.drawTexturedModalRect(x + 58, y + 30, 176, 14, t2, 15);
	}
}
