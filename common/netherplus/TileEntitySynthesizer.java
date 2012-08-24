package netherplus;

import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntitySynthesizer extends TileEntity {
	
	private ItemStack[] itemStacks = new ItemStack[3];
	public int synthesizeTime = 0;
	
    public int getSizeInventory()
    {
        return itemStacks.length;
    }
    
    public ItemStack getStackInSlot(int i)
    {
        return itemStacks[i];
    }
    
    public ItemStack decrStackSize(int slot, int i)
    {
        if (itemStacks[slot] != null)
        {
            ItemStack itemstack;

            if (itemStacks[slot].stackSize <= i)
            {
            	itemstack = itemStacks[slot];
                itemStacks[slot] = null;
                return itemstack;
            }
            else
            {
            	itemstack = itemStacks[slot].splitStack(i);

                if (itemStacks[slot].stackSize == 0)
                {
                	itemStacks[slot] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }
    
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (itemStacks[slot] != null)
        {
            ItemStack itemstack = itemStacks[slot];
            itemStacks[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }
    
    public void setInventorySlotContents(int slot, ItemStack itemstack)
    {
        itemStacks[slot] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
        	itemstack.stackSize = getInventoryStackLimit();
        }
    }
    
    public String getInvName()
    {
        return "Crystal Synthesizer";
    }
    
    public void readFromNBT(NBTTagCompound nbttag)
    {
        super.readFromNBT(nbttag);
        NBTTagList tagList = nbttag.getTagList("Items");
        itemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)tagList.tagAt(i);
            byte b = nbttagcompound.getByte("Slot");

            if (b >= 0 && b < itemStacks.length)
            {
                itemStacks[b] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        synthesizeTime = nbttag.getShort("SynthesizeTime");
    }
    
    public void writeToNBT(NBTTagCompound nbttag)
    {
        super.writeToNBT(nbttag);
        nbttag.setShort("SynthesizeTime", (short)synthesizeTime);
        NBTTagList tagList = new NBTTagList();

        for (int i = 0; i < itemStacks.length; ++i)
        {
            if (itemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                itemStacks[i].writeToNBT(nbttagcompound);
                tagList.appendTag(nbttagcompound);
            }
        }

        nbttag.setTag("Items", tagList);
    }
    
    public int getInventoryStackLimit()
    {
        return 64;
    }
    
}
