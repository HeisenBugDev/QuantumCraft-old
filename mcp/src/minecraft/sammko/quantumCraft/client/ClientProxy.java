package sammko.quantumCraft.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;
import sammko.quantumCraft.CommonProxy;
import sammko.quantumCraft.blocks.BlockEmpty;
import sammko.quantumCraft.core.QuantumCraftSettings;
import sammko.quantumCraft.render.RenderBlockEmpty;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(QuantumCraftSettings.ITEMS_PNG); // Texture loading
		MinecraftForgeClient.preloadTexture(QuantumCraftSettings.BLOCK_PNG);
		
		 
	}
	
	

	
}