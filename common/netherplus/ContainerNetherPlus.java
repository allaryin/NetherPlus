package netherplus;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;

public class ContainerNetherPlus extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
}
