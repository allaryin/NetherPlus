package netherplus;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemArmorTextured extends ItemArmor implements IArmorTextureProvider
{
    public ItemArmorTextured(int id, EnumArmorMaterial armorMaterial, int i, int j)
    {
        super(id, armorMaterial, i, j);
    }
    
	public String getTextureFile() {
		return "/netherplus/Item_Textures.png";
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.itemID == NetherPlus.helmBlackDiamond.shiftedIndex || itemstack.itemID == NetherPlus.bootsBlackDiamond.shiftedIndex || 
				itemstack.itemID == NetherPlus.chestBlackDiamond.shiftedIndex) {
			return "/netherplus/blackdiamond_1.png";
		}
		if(itemstack.itemID == NetherPlus.pantsBlackDiamond.shiftedIndex) {
			return "/netherplus/blackdiamond_2.png";
		}
		return "/netherplus/blackdiamond_1.png";
	}
}
