package netherplus;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemStack;
import netherplus.NetherPlusCore;
import net.minecraft.src.World;

public class ItemStaff extends ItemTextured {
	
	public ItemStaff(int i) {
		super(i);
	}
	
	/*
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if (entityplayer.capabilities.isCreativeMode || NetherPlusCore.getHasRequiredItems(entityplayer) == true)
        {
        	entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
            entityplayer.addChatMessage("IT WORKS");
        }

        return itemstack;
    }*/
    
    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 72000;
    }
    
    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.none;
    }
}
