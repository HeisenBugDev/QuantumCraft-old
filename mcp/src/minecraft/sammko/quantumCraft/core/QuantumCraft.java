package sammko.quantumCraft.core;

/*CPW IMPORTS*/
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import sammko.quantumCraft.CommonProxy;
import sammko.quantumCraft.client.ClientTickHandler;
import sammko.quantumCraft.items.ItemInitializator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
/*FORGE IMPORTS*/
/*SAMMKO IMPORTS*/

@Mod(modid = "QuantumCraft", name = "Quantum Craft", version = "0.7.8")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class QuantumCraft {

	// MainClass

	public WorldGenOres worldGen = new WorldGenOres();
	
	@Instance("QuantumCraft")
	public static QuantumCraft instance;
	@SidedProxy(clientSide = "sammko.quantumCraft.client.ClientProxy", serverSide = "sammko.quantumCraft.CommonProxy")
	public static CommonProxy proxy;
	public static ClientTickHandler clientTickHandler;
		
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		QuantumCraftSettings.getConfig(new Configuration(event
				.getSuggestedConfigurationFile())); // load all configurations
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		//CreativeTabs tabQC = new TabGems(CreativeTabs.getNextID(), "gammatroniumCrystal");
		GameRegistry.registerWorldGenerator(worldGen);
		ItemInitializator.initAll();
		CraftingManager.addCrafting();
		CraftingManager.addSmelting();
		MinecraftForge.setToolClass(ItemInitializator.ItemCrystalPickaxe,
				"CrystalPickaxe", 2);
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}