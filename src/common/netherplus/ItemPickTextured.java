package netherplus;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemPickaxe;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class ItemPickTextured extends ItemPickaxe {

    public ItemPickTextured(int id, EnumToolMaterial toolMaterial)
    {
        super(id, toolMaterial);
    }
    
	public String getTextureFile() {
		return "/NetherPlus/Item_Textures.png";
	}
}
