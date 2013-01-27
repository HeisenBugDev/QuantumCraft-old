package sammko.quantumCraft.core;

import net.minecraftforge.common.Configuration;

public class QuantumCraftSettings {


		public static String BLOCK_PNG = "/sammko/qc/block.png";
		public static String ITEMS_PNG = "/sammko/qc/items.png";

		//wgen
		public static boolean WGenPlu;
		public static boolean WGenPos;
		public static boolean WGenRad;
		public static boolean WGenGam;
		public static boolean WGenNeu;
		public static boolean WGenDep;
		//config IDs
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
		public static int CrystalPickaxeID;
		
		public static void getConfig(Configuration config)
		{
			//config
	        config.load();

	        PlutoniumIngotID = config.get("Items", "IngotPlutonium", 4500).getInt();
	        CrystalPositroniumID = config.get("Items", "CrystalPositronium", 4501).getInt();
	        CrystalRadiumID = config.get("Items", "CrystalRadium", 4502).getInt();
	        CrystalGammatroniumID = config.get("Items", "CrystalGammatronium", 4503).getInt();
	        CrystalNeutriniumID = config.get("Items", "CrystalNeutrinium", 4504).getInt();
	        CrystalDepletedID = config.get("Items", "CrystalDepleted", 4505).getInt();
	        EmptyEnergyPacketID = config.get("Items", "EmptyEnergyPacketID", 4506).getInt();
	        PositroniumEnergyPacketID = config.get("Items", "PositroniumEnergyPacketID", 4507).getInt();
	        RadiumEnergyPacketID = config.get("Items", "RadiumEnergyPacketID", 4508).getInt();
	        GammatroniumEnergyPacketID = config.get("Items", "GammatroniumEnergyPacketID", 4509).getInt();
	        NeutriniumEnergyPacketID = config.get("Items", "NeutriniumEnergyPacketID", 4510).getInt();
	        CrystalPickaxeID = config.get("Items", "CrystalPickaxeID", 4511).getInt();
	        
	      
	        OrePositroniumID = config.get("Blocks", "OrePositronium", 2500).getInt();
	        OrePlutoniumID = config.get("Blocks", "OrePlutonium", 2501).getInt();
	        OreRadiumID = config.get("Blocks", "OreRadium", 2502).getInt();
	        OreGammatroniumID = config.get("Blocks", "OreGammatronium", 2503).getInt();
	        OreNeutriniumID = config.get("Blocks", "OreNeutrinium", 2504).getInt();
	        EmptyBlockID = config.get("Blocks", "EmtyBlock", 2505).getInt();
	        MachineBlockID = config.get("Blocks", "MachineBlock", 2506).getInt();
	        OreDepletedID = config.get("Blocks", "OreDepleted", 2507).getInt();
	        
	        WGenPlu = config.get("World Gen", "Plutonium", true).getBoolean(true);
	        WGenPos = config.get("World Gen", "Positronium", true).getBoolean(true);
	        WGenRad = config.get("World Gen", "Radium", true).getBoolean(true);
	        WGenGam = config.get("World Gen", "Gammatronium", true).getBoolean(true);
	        WGenNeu = config.get("World Gen", "Neutrinium", true).getBoolean(true);
	        WGenDep = config.get("World Gen", "DepletedOre", true).getBoolean(true);
	        
	        config.save();
		}
		
}
