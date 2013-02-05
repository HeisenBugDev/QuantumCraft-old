
package thermalexpansion.core;

import net.minecraft.block.Block;

public class PropsCore {

    /* General */
    public static final String VERSION = "2.1.7.0";
    public static final String MC_VERSION = "1.4.7";

    public static final String DEFAULT_LANGUAGE = "en_US";
    public static final String PATH_LANGUAGE = "/thermalexpansion/lang/";
    public static final String DEPENDENCY_CORE = "required-after:ThermalExpansion";
    public static final String DEPENDENCY_FACTORY = "required-after:ThermalExpansion|Factory";

    /* Graphics */
    public static final String PATH_GFX = "/thermalexpansion/gfx/";
    public static final String PATH_GUI = PATH_GFX + "gui/";
    public static final String PATH_RENDER = PATH_GFX + "render/";
    public static final String DAMAGE_BARS = PATH_GFX + "damage_bars.png";

    public static final String TEXTURE_BLOCKS = PATH_GFX + "block_textures.png";
    public static final String TEXTURE_BLOCKS_CB = PATH_GFX + "block_textures_cb.png";
    public static final String TEXTURE_ITEMS = PATH_GFX + "item_textures.png";
    public static final String TEXTURE_LIQUIDS = PATH_GFX + "liquid_textures.png";
    public static final String TEXTURE_GUI_COMMON = PATH_GUI + "common.png";
    public static final String TEXTURE_GUI_COMMON_CB = PATH_GUI + "common_cb.png";
    public static final String TEXTURE_GUI_ICON = PATH_GUI + "icons.png";
    public static final String TEXTURE_GUI_TRIGGER = PATH_GUI + "triggers.png";

    /* Network */
    public static final int WORLD_HEIGHT = 256;
    public static final String NET_CHANNEL_NAME = "TE";
    public static final int TILE_UPDATE_RANGE = 8;
    public static final int CHUNK_UPDATE_RANGE = 16;
    public static final int NETWORK_UPDATE_RANGE = 192;

    public static final int PACKET_TILE = 0;
    public static final int PACKET_OMNITOOL = 1;

    public static final int PACKET_COUNT = 1;

    /* Global Constants */
    public static final int BUCKET_VOLUME = 1000;
    public static final int TIME_CONSTANT = 40;
    public static final int LAVA_ID = Block.lavaStill.blockID;
    public static final int WATER_ID = Block.waterStill.blockID;

    public static final int LAVA_MAX_MJ = 36000;

    /* Core */
    public static String[] nameOre = new String[] { "copper", "tin", "silver", "lead", "nickel" };

    public static enum Ores {
        COPPER, TIN, SILVER, LEAD, NICKEL
    }

    public static enum VanillaGen {
        COAL, IRON, GOLD, REDSTONE, DIAMOND, LAPIS
    }

    public static int[] oreLowerBound = new int[] { 40, 20, 5, 10, 5 };
    public static int[] oreUpperBound = new int[] { 75, 55, 30, 35, 20 };
    public static int[] oreNumCluster = new int[] { 10, 7, 3, 4, 2 };
    public static int[] oreClusterSize = new int[] { 8, 8, 8, 8, 4 };

    public static final int MACHINE_TEX_ID = 16 * 13;
    public static final int GLASS_TEX_ID = 16 * 14;
    public static final int ORE_TEX_ID = 16 * 15;

    public static final int LIQUID_REDSTONE_INDEX = 0;
    public static final int LIQUID_REDSTONE_COUNT = 16;
    public static final int LIQUID_ENDER_INDEX = 64;
    public static final int LIQUID_ENDER_COUNT = 1;

    /* Non-Constant */
    public static String textureBlocks = TEXTURE_BLOCKS;
    public static String textureGuiCommon = TEXTURE_GUI_COMMON;

    public static boolean enableGuiBorders = true;
    public static boolean enableInfoTabs = true;
    public static boolean enableTutorialTabs = true;
    public static boolean enableUpdateNotice = true;

    public static int lavaMJ = 20000;
}
