package netherplus;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class SpellBook extends ItemTextured {
	
	public SpellBook(int i) {
		super(i);
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	entityplayer.openGui(NetherPlus.instance, 40, world, entityplayer.serverPosX, entityplayer.serverPosY, entityplayer.serverPosZ);
        return itemstack;
    }

}
