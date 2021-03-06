package sammko.quantumCraft.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumHelper;
import sammko.quantumCraft.blocks.BlockEmpty;
import sammko.quantumCraft.blocks.BlockQuantumBasicBlocks;
import sammko.quantumCraft.blocks.BlockQuantumOre;
import sammko.quantumCraft.items.CrystalAxe;
import sammko.quantumCraft.items.CrystalPickaxe;
import sammko.quantumCraft.items.CrystalShovel;
import sammko.quantumCraft.items.CrystalSword;
import sammko.quantumCraft.items.ItemCrystal;
import sammko.quantumCraft.items.ItemEnergyPacket;
import sammko.quantumCraft.items.ItemPlutoniumIngot;
import sammko.quantumCraft.machine.BlockMachine;
import sammko.quantumCraft.machine.ExtractorContainer;
import sammko.quantumCraft.machine.InfuserContainer;
import sammko.quantumCraft.machine.TileEntityExtractor;
import sammko.quantumCraft.machine.TileEntityInfuser;
import sammko.quantumCraft.machine.gui.GuiExtractor;
import sammko.quantumCraft.machine.gui.GuiInfuser;
import sammko.quantumCraft.render.RenderBlockEmpty;
import sammko.quantumCraft.render.RenderBlockMachine;
import sammko.quantumCraft.resources.BlockTextureMatrix;
import sammko.quantumCraft.resources.ItemTextureMatrix;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Initializator implements IGuiHandler {

	public Initializator() {

	}

	// MultiBlock names
	private static final String[] decoBlockNames = { "Positronium Full Block",
			"Radium Full Block", "Gammatronium Full Block",
			"Neutrinium Full Block", "Depleted Full Block",
			"Positronium Brick", "Radium Brick", "Gammatronium Brick",
			"Neutrinium Brick", "Depleted Brick", "Positronium Small Brick",
			"Radium Small Brick", "Gammatronium Small Brick",
			"Neutrinium Small Brick", "Depleted Small Brick", "Plutonium Block" };

	private static final String[] machineBlockNames = { "Quantum Extractor",
			"Quantum Infuser" };
	public static int MachineCount = machineBlockNames.length;

	// Creative tabs
	public static CreativeTabs tabQC;
	// GUI IDs
	public static int GuiExtractorID = 0;
	public static int GuiInfuserID = 1;
	// Render IDs
	public static int BlockEmptyRenderID;
	public static int BlockMachineRenderID;
	// Ores
	public static BlockQuantumOre OrePositronium;
	public static BlockQuantumOre OrePlutonium;
	public static BlockQuantumOre OreRadium;
	public static BlockQuantumOre OreGammatronium;
	public static BlockQuantumOre OreNeutrinium;
	public static BlockQuantumOre OreDepleted;

	// Blocks
	public static Block EmptyBlock;
	public static Block DecoBlocks;
	// Machines
	public static Block MachineBlock;
	// Items
	public static ItemPlutoniumIngot ItemIngotPlutonium;
	public static ItemCrystal ItemPositroniumCrystal;
	public static ItemCrystal ItemRadiumCrystal;
	public static ItemCrystal ItemGammatroniumCrystal;
	public static ItemCrystal ItemNeutriniumCrystal;
	public static ItemCrystal ItemDepletedCrystal;
	public static ItemCrystal ItemDepletedShard;

	public static ItemPickaxe ItemCrystalPickaxe;
	public static ItemSword ItemCrystalSword;
	public static ItemAxe ItemCrystalAxe;
	public static ItemSpade ItemCrystalShovel;
	
	public static ItemPickaxe ItemInfusedCrystalPickaxe;
	public static ItemSword ItemInfusedCrystalSword;
	public static ItemAxe ItemInfusedCrystalAxe;
	public static ItemSpade ItemInfusedCrystalShovel;

	public static Item ItemRadioactiveMeat;

	public static EnumToolMaterial DEPLETEDCRYSTAL = EnumHelper
			.addToolMaterial("DEPLETEDCRYSTAL", 2, 500, 7.0F, 2, 25);
	// 2 = HarvestLvl; 500 = MaxUses; 7.0F = ToolSpeed; 6 = SwordDMG; 25 =
	// Enchantabillity

	public static ItemEnergyPacket ItemEmptyEnergyPacket;
	public static ItemEnergyPacket ItemPositroniumEnergyPacket;
	public static ItemEnergyPacket ItemRadiumEnergyPacket;
	public static ItemEnergyPacket ItemGammatroniumEnergyPacket;
	public static ItemEnergyPacket ItemNeutriniumEnergyPacket;

	// InitCode
	public static void initOres() {
		OrePositronium = (BlockQuantumOre) new BlockQuantumOre(
				QuantumCraftSettings.OrePositroniumID,
				BlockTextureMatrix.OrePositronium.getINT())
				.setBlockName("orePositronium").setHardness(3.0F)
				.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(tabQC);
		OrePlutonium = (BlockQuantumOre) new BlockQuantumOre(
				QuantumCraftSettings.OrePlutoniumID,
				BlockTextureMatrix.OrePlutonium.getINT())
				.setBlockName("orePlutonium").setHardness(3.0F)
				.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(tabQC);
		OreRadium = (BlockQuantumOre) new BlockQuantumOre(
				QuantumCraftSettings.OreRadiumID,
				BlockTextureMatrix.OreRadium.getINT())
				.setBlockName("oreRadium").setHardness(3.0F)
				.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(tabQC);
		OreGammatronium = (BlockQuantumOre) new BlockQuantumOre(
				QuantumCraftSettings.OreGammatroniumID,
				BlockTextureMatrix.OreGammatronium.getINT())
				.setBlockName("oreGammatronium").setHardness(3.0F)
				.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(tabQC);
		OreNeutrinium = (BlockQuantumOre) new BlockQuantumOre(
				QuantumCraftSettings.OreNeutriniumID,
				BlockTextureMatrix.OreNeutrinium.getINT())
				.setBlockName("oreNeutrinium").setHardness(3.0F)
				.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(tabQC);
		OreDepleted = (BlockQuantumOre) new BlockQuantumOre(
				QuantumCraftSettings.OreDepletedID,
				BlockTextureMatrix.OreDepleted.getINT())
				.setBlockName("OreDepleted").setHardness(5.0F)
				.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(tabQC);

		LanguageRegistry.addName(OrePositronium, "Positronium Ore");
		LanguageRegistry.addName(OrePlutonium, "Plutonium Ore");
		LanguageRegistry.addName(OreRadium, "Radium Ore");
		LanguageRegistry.addName(OreGammatronium, "Gammatronium Ore");
		LanguageRegistry.addName(OreNeutrinium, "Neutrinium Ore");
		LanguageRegistry.addName(OreDepleted, "Depleted Crystal Ore");
	}

	public static void initBlocks() {
		EmptyBlock = new BlockEmpty(QuantumCraftSettings.EmptyBlockID,
				BlockTextureMatrix.EBlockBackSingle.getINT(),
				BlockEmptyRenderID).setCreativeTab(tabQC).setBlockName(
				"emptyBlock");
		MachineBlock = new BlockMachine(QuantumCraftSettings.MachineBlockID,
				BlockMachineRenderID).setCreativeTab(tabQC);
		DecoBlocks = new BlockQuantumBasicBlocks(
				QuantumCraftSettings.DecoBlocksID,
				BlockTextureMatrix.Err.getINT()).setHardness(2.0F)
				.setResistance(10.0F).setCreativeTab(tabQC);

		LanguageRegistry.addName(EmptyBlock, "Empty Block");

		for (int ix = 0; ix < 16; ix++) {
			ItemStack iBlockQBB = new ItemStack(DecoBlocks, 1, ix);
			LanguageRegistry.addName(iBlockQBB,
					decoBlockNames[iBlockQBB.getItemDamage()]);
		}
		for (int ix = 0; ix < MachineCount; ix++) {
			ItemStack iBlockM = new ItemStack(MachineBlock, 1, ix);
			LanguageRegistry.addName(iBlockM,
					machineBlockNames[iBlockM.getItemDamage()]);
		}

	}

	public static void initItems() {
		ItemIngotPlutonium = new ItemPlutoniumIngot(
				QuantumCraftSettings.PlutoniumIngotID);
		ItemPositroniumCrystal = new ItemCrystal(
				QuantumCraftSettings.CrystalPositroniumID);
		ItemRadiumCrystal = new ItemCrystal(
				QuantumCraftSettings.CrystalRadiumID);
		ItemGammatroniumCrystal = new ItemCrystal(
				QuantumCraftSettings.CrystalGammatroniumID);
		ItemNeutriniumCrystal = new ItemCrystal(
				QuantumCraftSettings.CrystalNeutriniumID);
		ItemDepletedCrystal = new ItemCrystal(
				QuantumCraftSettings.CrystalDepletedID);
		ItemDepletedShard = new ItemCrystal(
				QuantumCraftSettings.DCrystalShardID);

		ItemEmptyEnergyPacket = new ItemEnergyPacket(
				QuantumCraftSettings.EmptyEnergyPacketID);
		ItemPositroniumEnergyPacket = new ItemEnergyPacket(
				QuantumCraftSettings.PositroniumEnergyPacketID);
		ItemRadiumEnergyPacket = new ItemEnergyPacket(
				QuantumCraftSettings.RadiumEnergyPacketID);
		ItemGammatroniumEnergyPacket = new ItemEnergyPacket(
				QuantumCraftSettings.GammatroniumEnergyPacketID);
		ItemNeutriniumEnergyPacket = new ItemEnergyPacket(
				QuantumCraftSettings.NeutriniumEnergyPacketID);

		ItemCrystalPickaxe = (ItemPickaxe) new CrystalPickaxe(
				QuantumCraftSettings.CrystalPickaxeID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.CPickaxe.getINT())
				.setItemName("CrystalPickaxe").setCreativeTab(tabQC);
		ItemCrystalSword = (ItemSword) new CrystalSword(
				QuantumCraftSettings.CrystalSwordID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.CSword.getINT())
				.setItemName("CrystalSword").setCreativeTab(tabQC);
		ItemCrystalAxe = (ItemAxe) new CrystalAxe(
				QuantumCraftSettings.CrystalAxeID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.CAxe.getINT())
				.setItemName("CrystalAxe").setCreativeTab(tabQC);
		ItemCrystalShovel = (ItemSpade) new CrystalShovel(
				QuantumCraftSettings.CrystalShovelID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.CShovel.getINT())
				.setItemName("CrystalShovel").setCreativeTab(tabQC);

		ItemInfusedCrystalPickaxe = (ItemPickaxe) new CrystalPickaxe(
				QuantumCraftSettings.InfusedCrystalPickaxeID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.GammPickaxe.getINT())
				.setItemName("InfusedCrystalPickaxe").setCreativeTab(tabQC);
		ItemInfusedCrystalSword = (ItemSword) new CrystalSword(
				QuantumCraftSettings.InfusedCrystalSwordID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.GammSword.getINT())
				.setItemName("InfusedCrystalSword").setCreativeTab(tabQC);
		ItemInfusedCrystalAxe = (ItemAxe) new CrystalAxe(
				QuantumCraftSettings.InfusedCrystalAxeID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.GammAxe.getINT())
				.setItemName("InfusedCrystalAxe").setCreativeTab(tabQC);
		ItemInfusedCrystalShovel = (ItemSpade) new CrystalShovel(
				QuantumCraftSettings.InfusedCrystalShovelID, DEPLETEDCRYSTAL)
				.setIconIndex(ItemTextureMatrix.GammShovel.getINT())
				.setItemName("InfusedCrystalShovel").setCreativeTab(tabQC);

		ItemIngotPlutonium.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.PlutoniumIngot.getINT())
				.setItemName("plutoniumIngot");
		ItemPositroniumCrystal.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.PositroniumCrystal.getINT())
				.setItemName("positroniumCrystal");
		ItemRadiumCrystal.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.RadiumCrystal.getINT())
				.setItemName("radiumCrystal");
		ItemGammatroniumCrystal.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.GammatroniumCrystal.getINT())
				.setItemName("gammatroniumCrystal");
		ItemNeutriniumCrystal.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.NeutriniumCrystal.getINT())
				.setItemName("neutriniumCrystal");
		ItemDepletedCrystal.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.DepletedCrystal.getINT())
				.setItemName("depletedCrystal");
		ItemDepletedShard.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.DCrystalShard.getINT())
				.setItemName("depletedCrystalShard");

		ItemEmptyEnergyPacket.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.EmptyEPacket.getINT())
				.setItemName("emptyEP");
		ItemPositroniumEnergyPacket.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.PositroniumEPacket.getINT())
				.setItemName("positroniumEP");
		ItemRadiumEnergyPacket.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.RadiumEPacket.getINT())
				.setItemName("radiumEP");
		ItemGammatroniumEnergyPacket.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.GammatroniumEPacket.getINT())
				.setItemName("gammatroniumEP");
		ItemNeutriniumEnergyPacket.setMaxStackSize(64).setCreativeTab(tabQC)
				.setIconIndex(ItemTextureMatrix.NeutriniumEPacket.getINT())
				.setItemName("neutroniumEP");

		ItemRadioactiveMeat = new sammko.quantumCraft.items.RadioactiveMeat(
				QuantumCraftSettings.RadioactiveMeatID, 6, 1F, false)
				.setPotionEffect(Potion.poison.id, 20, 2, 0.5F)
				.setMaxStackSize(64).setCreativeTab(tabQC)
				.setItemName("RadioactiveMeat")
				.setIconIndex(ItemTextureMatrix.RadioactiveMeat.getINT());

		LanguageRegistry.addName(ItemRadioactiveMeat, "Radioactive Meat");
		LanguageRegistry.addName(ItemIngotPlutonium, "Plutonium Ingot");
		LanguageRegistry.addName(ItemPositroniumCrystal, "Positronium Crystal");
		LanguageRegistry.addName(ItemRadiumCrystal, "Radium Crystal");
		LanguageRegistry.addName(ItemGammatroniumCrystal,
				"Gammatronium Crystal");
		LanguageRegistry.addName(ItemNeutriniumCrystal, "Neutrinium Crystal");
		LanguageRegistry.addName(ItemDepletedCrystal, "Depleted Crystal");

		LanguageRegistry.addName(ItemEmptyEnergyPacket, "Empty EPacket");
		LanguageRegistry.addName(ItemPositroniumEnergyPacket,
				"Positronium EPacket");
		LanguageRegistry.addName(ItemRadiumEnergyPacket, "Radium EPacket");
		LanguageRegistry.addName(ItemGammatroniumEnergyPacket,
				"Gammatronium EPacket");
		LanguageRegistry.addName(ItemNeutriniumEnergyPacket,
				"Neutrinium EPacket");

		LanguageRegistry.addName(ItemDepletedShard, "Depleted Crystal Shard");

		LanguageRegistry.addName(ItemCrystalPickaxe, "Crystal Pickaxe");
		LanguageRegistry.addName(ItemCrystalSword, "Crystal Sword");
		LanguageRegistry.addName(ItemCrystalAxe, "Crystal Axe");
		LanguageRegistry.addName(ItemCrystalShovel, "Crystal Shovel");
		
		LanguageRegistry.addName(ItemInfusedCrystalPickaxe, "Gamma Infused Crystal Pickaxe");
		LanguageRegistry.addName(ItemInfusedCrystalSword, "Gamma Infused Crystal Sword");
		LanguageRegistry.addName(ItemInfusedCrystalAxe, "Gamma Infused Crystal Axe");
		LanguageRegistry.addName(ItemInfusedCrystalShovel, "Gamma Infused Crystal Shovel");
	}

	public static void initTEntities() {
		GameRegistry.registerTileEntity(TileEntityExtractor.class,
				"ExtractorTE");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "InfuserTE");
	}

	public static void initRenderers() {
		BlockEmptyRenderID = RenderingRegistry.getNextAvailableRenderId();
		BlockMachineRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockEmpty(
				BlockEmptyRenderID, 0));
		RenderingRegistry.registerBlockHandler(new RenderBlockMachine(
				BlockMachineRenderID));
	}

	public static void initCT() {

		tabQC = new TabQuantumCraft();

	}

	public static void initAll() {
		initCT();
		initTEntities();
		initRenderers();
		initBlocks();
		initItems();
		initOres();

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		Object o = world.getBlockTileEntity(x, y, z);

		if (o instanceof TileEntityExtractor) {
			return new ExtractorContainer(player.inventory,
					(TileEntityExtractor) o);
		}
		if (o instanceof TileEntityInfuser) {
			return new InfuserContainer(player.inventory, (TileEntityInfuser) o);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Object o = world.getBlockTileEntity(x, y, z);
		if (o instanceof TileEntityExtractor) {
			return new GuiExtractor(player.inventory, (TileEntityExtractor) o);
		} else if (o instanceof TileEntityInfuser) {
			return new GuiInfuser(player.inventory, (TileEntityInfuser) o);
		} else
			return null;

	}

}
