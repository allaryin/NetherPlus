package netherplus;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import netherplus.NetherPlus;

public class ItemSwordTextured extends ItemTextured
{
    private int weaponDamage;
    private final EnumToolMaterial toolMaterial;
    public boolean isMolten = false;

    public ItemSwordTextured(int id, EnumToolMaterial enumToolMaterial)
    {
        super(id);
        toolMaterial = enumToolMaterial;
        if(toolMaterial == NetherPlus.T_MOLTEN) {
        	isMolten = true;
        }
        maxStackSize = 1;
        setMaxDamage(enumToolMaterial.getMaxUses());
        weaponDamage = 4 + enumToolMaterial.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemStack, Block block)
    {
        return block.blockID == Block.web.blockID ? 15.0F : 1.5F;
    }

    public boolean hitEntity(ItemStack itemStack, EntityLiving entityLiving, EntityLiving entityLiving2)
    {
    	itemStack.damageItem(1, entityLiving2);
    	if(isMolten) {
    		entityLiving.setFire(6);
    	}
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemStack, int i, int j, int k, int l, EntityLiving entityLiving)
    {
    	itemStack.damageItem(2, entityLiving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.block;
    }

    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 72000;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
    	entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    public boolean canHarvestBlock(Block block)
    {
        return block.blockID == Block.web.blockID;
    }

    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
}
