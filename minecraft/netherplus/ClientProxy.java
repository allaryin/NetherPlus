package netherplus;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public static void preloadTexture(String texture) {
		MinecraftForgeClient.preloadTexture(texture);
	}
	
	public int registerArmorRenderID(String prefix)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(prefix);
	}
}
