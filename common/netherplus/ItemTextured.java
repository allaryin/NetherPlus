package netherplus;

import net.minecraft.src.Item;

public class ItemTextured extends Item {
	
	public ItemTextured(int i) {
		super(i);
	}
	
	public String getTextureFile() {
		return "/netherplus/Item_Textures.png";
	}
}
