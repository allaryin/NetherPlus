package netherplus;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID) {
		case 40:
			return new ContainerNetherPlus();
			
		default: return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID) {
		case 40: 
			return new GuiSpellbook(new ContainerNetherPlus());
			
		default: return null;
		}
	}

}
