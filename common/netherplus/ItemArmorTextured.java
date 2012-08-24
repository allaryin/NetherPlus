package netherplus;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;

public class ItemArmorTextured extends ItemArmor
{
    public ItemArmorTextured(int id, EnumArmorMaterial armorMaterial, int i, int j)
    {
        super(id, armorMaterial, i, j);
    }
    
	public String getTextureFile() {
		return "/NetherPlus/Item_Textures.png";
	}
}
