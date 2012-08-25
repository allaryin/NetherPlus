package netherplus;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.src.ItemStack;

public class FuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == NetherPlus.netherCoal.shiftedIndex) {
			return 1800;
		}
		return 0;
	}
	
}
