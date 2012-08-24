package netherplus;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public static void preloadTexture(String texture) {
		MinecraftForgeClient.preloadTexture(texture);
	}
}
