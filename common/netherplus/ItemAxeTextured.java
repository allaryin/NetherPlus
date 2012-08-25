package netherplus;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class ItemAxeTextured extends ItemAxe
{
    public ItemAxeTextured(int id, EnumToolMaterial toolMaterial)
    {
        super(id, toolMaterial);
    }
    
	public String getTextureFile() {
		return "/netherplus/Item_Textures.png";
	}
}
