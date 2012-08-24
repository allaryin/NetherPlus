package netherplus;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;

public class BlockSynthesizer extends BlockContainer {
	
	private Random rand = new Random();

	public BlockSynthesizer(int id, int tex) {
		super(id, tex, Material.rock);
	}
	
    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        setDefaultDirection(world, i, j, k);
    }
	
    private void setDefaultDirection(World world, int i, int j, int k)
    {
        if (world.isRemote)
        {
            return;
        }
        int l = world.getBlockId(i, j, k - 1);
        int i1 = world.getBlockId(i, j, k + 1);
        int j1 = world.getBlockId(i - 1, j, k);
        int k1 = world.getBlockId(i + 1, j, k);
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 4;
        }
        world.setBlockMetadataWithNotify(i, j, k, byte0);
    }
    
    public int getBlockTexture(IBlockAccess blockaccess, int x, int y, int z, int side)
    {
        if(side == 1 || side == 0) {
        	return blockIndexInTexture + 3;
        }
        int i1 = blockaccess.getBlockMetadata(x, y, z);
        if(side != i1)
        {
            return blockIndexInTexture + 1;
        }
        else {
            return blockIndexInTexture;
        }
    }
	
	public int getBlockTextureFromSide(int side) {
		
		if(side == 1 || side == 0) {
			return blockIndexInTexture + 3;
		}
		
		if(side == 3) {
			return blockIndexInTexture;
		}
		
		else {
			return blockIndexInTexture + 1;
		}
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4);
        }
    }
    
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
    	TileEntitySynthesizer tile = (TileEntitySynthesizer)par1World.getBlockTileEntity(par2, par3, par4);

    	if (tile != null)
    	{
    		for (int var6 = 0; var6 < tile.getSizeInventory(); ++var6)
    		{
    			ItemStack var7 = tile.getStackInSlot(var6);

    			if (var7 != null)
    			{
    				float var8 = rand.nextFloat() * 0.8F + 0.1F;
    				float var9 = rand.nextFloat() * 0.8F + 0.1F;
    				float var10 = rand.nextFloat() * 0.8F + 0.1F;

    				while (var7.stackSize > 0)
    				{
    					int var11 = rand.nextInt(21) + 10;

    					if (var11 > var7.stackSize)
    					{
    						var11 = var7.stackSize;
    					}

    					var7.stackSize -= var11;
    					EntityItem var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));

    					if (var7.hasTagCompound())
    					{
    						var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
    					}

    					float var13 = 0.05F;
    					var12.motionX = (double)((float)rand.nextGaussian() * var13);
    					var12.motionY = (double)((float)rand.nextGaussian() * var13 + 0.2F);
    					var12.motionZ = (double)((float)rand.nextGaussian() * var13);
    					par1World.spawnEntityInWorld(var12);
    				}
    			}
    		}
    	}
    	super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	
    public String getTextureFile()
    {
        return "/NetherPlus/Block_Textures.png";
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntitySynthesizer();
	}

}
