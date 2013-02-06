package sammko.quantumCraft.core;

	import net.minecraft.client.gui.FontRenderer;
	import thermalexpansion.core.gui.Tab;
	import net.minecraft.client.gui.Gui;
	import net.minecraft.tileentity.TileEntity;


	public class TabInfo extends Tab
	{
	  TileEntity myTile;
	  int headerColor = 14797103;
	  int subheaderColor = 11186104;
	  int textColor = 16777215;

	  public TabInfo(Gui gui, TileEntity tile)
	  {
	    super(gui);

	    this.myTile = tile;
	    this.maxHeight = 92;
	    this.maxWidth = 100;
	    this.overlayColor = 5900731;
	    this.leftSide = true;
	  }

	  public TabInfo(Gui gui, TileEntity tile, int height, int width)
	  {
	    super(gui);

	    this.myTile = tile;
	    this.maxHeight = height;
	    this.maxWidth = width;
	    this.overlayColor = 5900731;
	    this.leftSide = true;
	  }

	  public void draw(int x, int y)
	  {
	    drawBackground(x, y);

	    drawIcon("/thermalexpansion/gfx/gui/icons.png", 0, x + 2, y + 2);

	    if (!isFullyOpened()) {
	      return;
	    }

	    tabFontRenderer.drawStringWithShadow("Test", x - this.currentWidth + 22, y + 6, this.headerColor);

	    
	  }

	  public String getTooltip()
	  {
	    if (!isFullyOpened()) {
	      return "gui.information";
	    }
	    return null;
	  }
	}

