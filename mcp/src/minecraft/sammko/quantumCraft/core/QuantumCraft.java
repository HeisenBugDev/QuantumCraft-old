package sammko.quantumCraft.core;

/*CPW IMPORTS*/
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
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
import cpw.mods.fml.common.registry.LanguageRegistry;
/*FORGE IMPORTS*/
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
/*SAMMKO IMPORTS*/
import sammko.quantumCraft.blocks.BlockEmpty;
import sammko.quantumCraft.blocks.BlockQuantumOre;
import sammko.quantumCraft.items.ItemCrystal;
import sammko.quantumCraft.items.ItemEnergyPacket;
import sammko.quantumCraft.items.ItemInitializator;
import sammko.quantumCraft.items.ItemPlutoniumIngot;
import sammko.quantumCraft.machine.BlockMachine;
import sammko.quantumCraft.render.RenderBlockEmpty;
import sammko.quantumCraft.render.RenderBlockMachine;
import sammko.quantumCraft.resources.BlockTextureMatrix;
import sammko.quantumCraft.resources.ItemTextureMatrix;
import sammko.quantumCraft.CommonProxy;

@Mod(modid="QuantumCraft", name="Quantum Craft", version="0.2.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class QuantumCraft {

//MainClass  
	
	public WorldGenOres worldGen = new WorldGenOres();
	
	@Instance("QuantumCraft")
	public static QuantumCraft instance;
	@SidedProxy(clientSide="sammko.quantumCraft.client.ClientProxy", serverSide="sammko.quantumCraft.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		QuantumCraftSettings.getConfig(new Configuration(event.getSuggestedConfigurationFile())); // load all configurations
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(worldGen);
		ItemInitializator.initAll();
		CraftingManager.addCrafting();
		CraftingManager.addSmelting();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}