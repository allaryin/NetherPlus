package netherplus;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSpade;

public class ItemSpadeTextured extends ItemSpade {

    public ItemSpadeTextured(int id, EnumToolMaterial toolMaterial)
    {
        super(id, toolMaterial);
    }
    
	public String getTextureFile() {
		return "/NetherPlus/Item_Textures.png";
	}
}
