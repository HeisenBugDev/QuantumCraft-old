package sammko.quantumCraft.core;

import net.minecraftforge.common.Configuration;

public class QuantumCraftSettings {

	// other
	public static boolean debug;
	// tool stuff
	public static int witheringTimeout;
	// mods
	public static boolean gotIC2 = false;
	// files
	public static String BLOCK_PNG = "/sammko/qc/block.png";
	public static String ITEMS_PNG = "/sammko/qc/items.png";
	public static String BGextractorGUI = "/sammko/qc/gui/Extractor.png";
	public static String BGinfuserGUI = "/sammko/qc/gui/Infuser.png";
	// wgen
	public static boolean WGenPlu;
	public static boolean WGenPos;
	public static boolean WGenRad;
	public static boolean WGenGam;
	public static boolean WGenNeu;
	public static boolean WGenDep;
	// config IDs
	public static int DecoBlocksID;
	public static int MachineBlockID;
	public static int CrystalPositroniumID;
	public static int CrystalRadiumID;
	public static int CrystalGammatroniumID;
	public static int CrystalNeutriniumID;
	public static int CrystalDepletedID;
	public static int PlutoniumIngotID;
	public static int OrePositroniumID;
	public static int OrePlutoniumID;
	public static int OreRadiumID;
	public static int OreGammatroniumID;
	public static int OreNeutriniumID;
	public static int OreDepletedID;
	public static int EmptyBlockID;
	public static int EmptyEnergyPacketID;
	public static int PositroniumEnergyPacketID;
	public static int RadiumEnergyPacketID;
	public static int GammatroniumEnergyPacketID;
	public static int NeutriniumEnergyPacketID;

	public static int DCrystalShardID;
	public static int CrystalPickaxeID;
	public static int CrystalSwordID;
	public static int CrystalAxeID;
	public static int CrystalShovelID;

	public static int InfusedCrystalPickaxeID;
	public static int InfusedCrystalSwordID;
	public static int InfusedCrystalAxeID;
	public static int InfusedCrystalShovelID;

	public static int RadioactiveMeatID;
	
	public static int Jappack;

	public static void getConfig(Configuration config) {
		// config
		config.load();

		PlutoniumIngotID = config.get("Items", "IngotPlutonium", 4500).getInt();
		CrystalPositroniumID = config.get("Items", "CrystalPositronium", 4501)
				.getInt();
		CrystalRadiumID = config.get("Items", "CrystalRadium", 4502).getInt();
		CrystalGammatroniumID = config
				.get("Items", "CrystalGammatronium", 4503).getInt();
		CrystalNeutriniumID = config.get("Items", "CrystalNeutrinium", 4504)
				.getInt();
		CrystalDepletedID = config.get("Items", "CrystalDepleted", 4505)
				.getInt();
		EmptyEnergyPacketID = config.get("Items", "EmptyEnergyPacketID", 4506)
				.getInt();
		PositroniumEnergyPacketID = config.get("Items",
				"PositroniumEnergyPacketID", 4507).getInt();
		RadiumEnergyPacketID = config
				.get("Items", "RadiumEnergyPacketID", 4508).getInt();
		GammatroniumEnergyPacketID = config.get("Items",
				"GammatroniumEnergyPacketID", 4509).getInt();
		NeutriniumEnergyPacketID = config.get("Items",
				"NeutriniumEnergyPacketID", 4510).getInt();

		CrystalPickaxeID = config.get("Items", "CrystalPickaxeID", 4511)
				.getInt();
		CrystalSwordID = config.get("Items", "CrystalSwordID", 4512).getInt();
		CrystalAxeID = config.get("Items", "CrystalAxeID", 4513).getInt();
		CrystalShovelID = config.get("Items", "CrystalShovelID", 4514).getInt();
		DCrystalShardID = config.get("Items", "DepletedShardID", 4515).getInt();

		RadioactiveMeatID = config.get("Items", "RadioactiveMeat", 4516)
				.getInt();

		InfusedCrystalPickaxeID = config.get("Items", "InfusedCrystalPickaxeID", 4517)
				.getInt();
		InfusedCrystalSwordID = config.get("Items", "InfusedCrystalSwordID", 4518)
				.getInt();
		InfusedCrystalAxeID = config.get("Items", "InfusedCrystalAxeID", 4519)
				.getInt();
		InfusedCrystalShovelID = config.get("Items", "InfusedCrystalShovelID", 4520)
				.getInt();

		Jappack = config.get("Items", "Jappack", 4521).getInt();
		
		OrePositroniumID = config.get("Blocks", "OrePositronium", 2500)
				.getInt();
		OrePlutoniumID = config.get("Blocks", "OrePlutonium", 2501).getInt();
		OreRadiumID = config.get("Blocks", "OreRadium", 2502).getInt();
		OreGammatroniumID = config.get("Blocks", "OreGammatronium", 2503)
				.getInt();
		OreNeutriniumID = config.get("Blocks", "OreNeutrinium", 2504).getInt();
		EmptyBlockID = config.get("Blocks", "EmtyBlock", 2505).getInt();
		MachineBlockID = config.get("Blocks", "MachineBlock", 2506).getInt();
		OreDepletedID = config.get("Blocks", "OreDepleted", 2507).getInt();
		DecoBlocksID = config.get("Blocks", "DecoBlocks", 2508).getInt();

		debug = config.get("Other", "Debug", false).getBoolean(false);

		witheringTimeout = config.get("ToolStuff", "WitheringTimeout", 300).getInt();
		
		WGenPlu = config.get("WorldGen", "Plutonium", true).getBoolean(true);
		WGenPos = config.get("WorldGen", "Positronium", true).getBoolean(true);
		WGenRad = config.get("WorldGen", "Radium", true).getBoolean(true);
		WGenGam = config.get("WorldGen", "Gammatronium", true).getBoolean(true);
		WGenNeu = config.get("WorldGen", "Neutrinium", true).getBoolean(true);
		WGenDep = config.get("WorldGen", "DepletedOre", true).getBoolean(true);

		config.save();

		gotIC2 = exists("ic2.core.IC2");
	}
	
	public static boolean exists(String className) {
		try {
			Class.forName(className);
			return true;
		} catch (ClassNotFoundException exception) {
			return false;
		}
	}
}
