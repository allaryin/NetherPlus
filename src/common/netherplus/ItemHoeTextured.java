package netherplus;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemHoe;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.UseHoeEvent;

public class ItemHoeTextured extends ItemHoe
{
    public ItemHoeTextured(int id, EnumToolMaterial toolMaterial)
    {
        super(id, toolMaterial);
    }
    
	public String getTextureFile() {
		return "/NetherPlus/Item_Textures.png";
	}
}
