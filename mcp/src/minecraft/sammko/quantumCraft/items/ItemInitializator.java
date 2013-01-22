package sammko.quantumCraft.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.blocks.BlockEmpty;
import sammko.quantumCraft.blocks.BlockQuantumOre;
import sammko.quantumCraft.machine.BlockMachine;
import sammko.quantumCraft.machine.TileEntityGenerator;
import sammko.quantumCraft.machine.TileEntityMachine;
import sammko.quantumCraft.machine.gui.GuiGenerator;
import sammko.quantumCraft.render.RenderBlockEmpty;
import sammko.quantumCraft.render.RenderBlockMachine;
import sammko.quantumCraft.resources.BlockTextureMatrix;
import sammko.quantumCraft.resources.ItemTextureMatrix;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemInitializator implements IGuiHandler{

	public ItemInitializator() {
		// TODO Auto-generated constructor stub
	}
	
		//GUI IDs
		public static int GuiGeneratorID = 1;
		//Render IDs
		public static int BlockEmptyRenderID;
		public static int BlockMachineRenderID;
		//Ores
		public static BlockQuantumOre OrePositronium;
		public static BlockQuantumOre OrePlutonium;
		public static BlockQuantumOre OreRadium;
		public static BlockQuantumOre OreGammatronium;
		public static BlockQuantumOre OreNeutrinium;
		//Blocks
		public static BlockEmpty EmptyBlock;
		//Machines
		public static BlockMachine MachineBlock;
		//Items
		public static ItemPlutoniumIngot ItemIngotPlutonium;
		public static ItemCrystal ItemPositroniumCrystal;
		public static ItemCrystal ItemRadiumCrystal;
		public static ItemCrystal ItemGammatroniumCrystal;
		public static ItemCrystal ItemNeutriniumCrystal;
		public static ItemCrystal ItemDepletedCrystal;
		
		public static ItemEnergyPacket ItemEmptyEnergyPacket;
		public static ItemEnergyPacket ItemPositroniumEnergyPacket;
		public static ItemEnergyPacket ItemRadiumEnergyPacket;
		public static ItemEnergyPacket ItemGammatroniumEnergyPacket;
		public static ItemEnergyPacket ItemNeutriniumEnergyPacket;
		//InitCode
		public static void initOres()
		{
			OrePositronium = (BlockQuantumOre) new BlockQuantumOre(QuantumCraftSettings.OrePositroniumID, BlockTextureMatrix.getIndex(BlockTextureMatrix.OrePositronium)).setBlockName("orePositronium").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
			OrePlutonium = (BlockQuantumOre) new BlockQuantumOre(QuantumCraftSettings.OrePlutoniumID, BlockTextureMatrix.getIndex(BlockTextureMatrix.OrePlutonium)).setBlockName("orePlutonium").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
			OreRadium = (BlockQuantumOre) new BlockQuantumOre(QuantumCraftSettings.OreRadiumID, BlockTextureMatrix.getIndex(BlockTextureMatrix.OreRadium)).setBlockName("oreRadium").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
			OreGammatronium = (BlockQuantumOre) new BlockQuantumOre(QuantumCraftSettings.OreGammatroniumID, BlockTextureMatrix.getIndex(BlockTextureMatrix.OreGammatronium)).setBlockName("oreGammatronium").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
			OreNeutrinium = (BlockQuantumOre) new BlockQuantumOre(QuantumCraftSettings.OreNeutriniumID, BlockTextureMatrix.getIndex(BlockTextureMatrix.OreNeutrinium)).setBlockName("oreNeutrinium").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);

			LanguageRegistry.addName(OrePositronium, "Positronium Ore");
			LanguageRegistry.addName(OrePlutonium, "Plutonium Ore");
			LanguageRegistry.addName(OreRadium, "Radium Ore");
			LanguageRegistry.addName(OreGammatronium, "Gammatronium Ore");
			LanguageRegistry.addName(OreNeutrinium, "Neutrinium Ore");
		}
		public static void initBlocks()
		{
			EmptyBlock = new BlockEmpty(QuantumCraftSettings.EmptyBlockID, BlockTextureMatrix.getIndex(BlockTextureMatrix.EBlockBackSingle), BlockEmptyRenderID);
			MachineBlock = new BlockMachine(QuantumCraftSettings.MachineBlockID, BlockMachineRenderID);
		}

		public static void initItems()
		{
			ItemIngotPlutonium = new ItemPlutoniumIngot(QuantumCraftSettings.PlutoniumIngotID);
			ItemPositroniumCrystal = new ItemCrystal(QuantumCraftSettings.CrystalPositroniumID);
			ItemRadiumCrystal = new ItemCrystal(QuantumCraftSettings.CrystalRadiumID);
			ItemGammatroniumCrystal = new ItemCrystal(QuantumCraftSettings.CrystalGammatroniumID);
			ItemNeutriniumCrystal = new ItemCrystal(QuantumCraftSettings.CrystalNeutriniumID);
			ItemDepletedCrystal = new ItemCrystal(QuantumCraftSettings.CrystalDepletedID);
			
			ItemEmptyEnergyPacket = new ItemEnergyPacket(QuantumCraftSettings.EmptyEnergyPacketID);
			ItemPositroniumEnergyPacket = new ItemEnergyPacket(QuantumCraftSettings.PositroniumEnergyPacketID);
			ItemRadiumEnergyPacket = new ItemEnergyPacket(QuantumCraftSettings.RadiumEnergyPacketID);
			ItemGammatroniumEnergyPacket = new ItemEnergyPacket(QuantumCraftSettings.GammatroniumEnergyPacketID);
			ItemNeutriniumEnergyPacket = new ItemEnergyPacket(QuantumCraftSettings.NeutriniumEnergyPacketID);
			
			ItemIngotPlutonium.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.PlutoniumIngot)).setItemName("plutoniumIngot");
			ItemPositroniumCrystal.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.PositroniumCrystal)).setItemName("positroniumCrystal");
			ItemRadiumCrystal.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.RadiumCrystal)).setItemName("radiumCrystal");
			ItemGammatroniumCrystal.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.GammatroniumCrystal)).setItemName("gammatroniumCrystal");
			ItemNeutriniumCrystal.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.NeutriniumCrystal)).setItemName("neutriniumCrystal");
			ItemDepletedCrystal.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.DepletedCrystal)).setItemName("depletedCrystal");
			
			ItemEmptyEnergyPacket.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.EmptyEPacket)).setItemName("emptyEP");
			ItemPositroniumEnergyPacket.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.PositroniumEPacket)).setItemName("positroniumEP");
			ItemRadiumEnergyPacket.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.RadiumEPacket)).setItemName("radiumEP");
			ItemGammatroniumEnergyPacket.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.GammatroniumEPacket)).setItemName("gammatroniumEP");
			ItemNeutriniumEnergyPacket.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(ItemTextureMatrix.getIndex(ItemTextureMatrix.NeutriniumEPacket)).setItemName("neutroniumEP");
			
			LanguageRegistry.addName(ItemIngotPlutonium, "Plutonium Ingot");
			LanguageRegistry.addName(ItemPositroniumCrystal, "Positronium Crystal");
			LanguageRegistry.addName(ItemRadiumCrystal, "Radium Crystal");
			LanguageRegistry.addName(ItemGammatroniumCrystal, "Gammatronium Crystal");
			LanguageRegistry.addName(ItemNeutriniumCrystal, "Neutrinium Crystal");
			LanguageRegistry.addName(ItemDepletedCrystal, "Depleted Crystal");
			
			LanguageRegistry.addName(ItemEmptyEnergyPacket, "Empty EPacket");
			LanguageRegistry.addName(ItemPositroniumEnergyPacket, "Positronium EPacket");
			LanguageRegistry.addName(ItemRadiumEnergyPacket, "Radium EPacket");
			LanguageRegistry.addName(ItemGammatroniumEnergyPacket, "Gammatronium EPacket");
			LanguageRegistry.addName(ItemNeutriniumEnergyPacket, "Neutrinium EPacket");
		}
		public static void initTEntities()
		{
			GameRegistry.registerTileEntity(TileEntityMachine.class, "MachineTE");
			GameRegistry.registerTileEntity(TileEntityGenerator.class, "GeneratorTE");
		}
		public static void initRenderers()
		{
			BlockEmptyRenderID = RenderingRegistry.getNextAvailableRenderId();
			BlockMachineRenderID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new RenderBlockEmpty(BlockEmptyRenderID,0));
			RenderingRegistry.registerBlockHandler(new RenderBlockMachine(BlockMachineRenderID));
		}
			
		public static void initAll()
		{
			initTEntities();
			initRenderers();
			initBlocks();
			initItems();
			initOres();
		
		}
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			// TODO Auto-generated method stub
			return null;
		}

}