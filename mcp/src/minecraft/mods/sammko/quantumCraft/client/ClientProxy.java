package mods.sammko.quantumCraft.client;

import mods.sammko.quantumCraft.CommonProxy;
import mods.sammko.quantumCraft.core.QuantumCraftSettings;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(QuantumCraftSettings.ITEMS_PNG); // Texture
																				// loading
		MinecraftForgeClient.preloadTexture(QuantumCraftSettings.BLOCK_PNG);

	}

}