package sammko.quantumCraft.core;

import net.minecraftforge.common.Configuration;

public class QuantumCraftSettings {


		public static String BLOCK_PNG = "/sammko/qc/block.png";
		public static String ITEMS_PNG = "/sammko/qc/items.png";

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
		public static int EmptyBlockID;
		public static int EmptyEnergyPacketID;
		public static int PositroniumEnergyPacketID;
		public static int RadiumEnergyPacketID;
		public static int GammatroniumEnergyPacketID;
		public static int NeutriniumEnergyPacketID;
		
		public static void getConfig(Configuration config)
		{
			//config
	        config.load();

	        PlutoniumIngotID = config.get("Items", "IngotPlutonium", 7500).getInt();
	        CrystalPositroniumID = config.get("Items", "CrystalPositronium", 7501).getInt();
	        CrystalRadiumID = config.get("Items", "CrystalRadium", 7502).getInt();
	        CrystalGammatroniumID = config.get("Items", "CrystalGammatronium", 7503).getInt();
	        CrystalNeutriniumID = config.get("Items", "CrystalNeutrinium", 7504).getInt();
	        CrystalDepletedID = config.get("Items", "CrystalDepleted", 7505).getInt();
	        EmptyEnergyPacketID = config.get("Items", "EmptyEnergyPacketID", 7506).getInt();
	        PositroniumEnergyPacketID = config.get("Items", "PositroniumEnergyPacketID", 7507).getInt();
	        RadiumEnergyPacketID = config.get("Items", "RadiumEnergyPacketID", 7508).getInt();
	        GammatroniumEnergyPacketID = config.get("Items", "GammatroniumEnergyPacketID", 7509).getInt();
	        NeutriniumEnergyPacketID = config.get("Items", "NeutriniumEnergyPacketID", 7510).getInt();
	        
	        OrePositroniumID = config.get("Blocks", "OrePositronium", 2500).getInt();
	        OrePlutoniumID = config.get("Blocks", "OrePlutonium", 2501).getInt();
	        OreRadiumID = config.get("Blocks", "OreRadium", 2502).getInt();
	        OreGammatroniumID = config.get("Blocks", "OreGammatronium", 2503).getInt();
	        OreNeutriniumID = config.get("Blocks", "OreNeutrinium", 2504).getInt();
	        EmptyBlockID = config.get("Blocks", "EmtyBlock", 2505).getInt();
	        MachineBlockID = config.get("Blocks", "MachineBlock", 2506).getInt();
	        
	        config.save();
		}
		
}
