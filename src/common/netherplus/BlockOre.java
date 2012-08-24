package netherplus;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import netherplus.NetherPlus;
import java.util.Random;

public class BlockOre extends Block
{
    public BlockOre(int i, int j)
    {
        super(i, j, Material.rock);
    }
    
    public int idDropped(int i, Random random, int j)
    {
    	//Get what item is dropped based on the block id.
    	/*if(blockID == mod_NetherPlus.oreDarkCrystal.blockID) {
    		return mod_NetherPlus.crystalDark.shiftedIndex;
    	}
    	if(blockID == mod_NetherPlus.oreFieryCrystal.blockID) {
    		return mod_NetherPlus.crystalFiery.shiftedIndex;
    	}
    	if(blockID == mod_NetherPlus.oreWaterCrystal.blockID) {
    		return mod_NetherPlus.crystalWater.shiftedIndex;
    	}*/
    	if(blockID == NetherPlus.oreBlackDiamond.blockID) {
    		return NetherPlus.blackDiamond.shiftedIndex;
    	}
    	if(blockID == NetherPlus.oreNetherCoal.blockID) {
    		return NetherPlus.netherCoal.shiftedIndex;
    	}
    	if(blockID == NetherPlus.oreNetheridium.blockID) {
    		return NetherPlus.oreNetheridium.blockID;
    	}
    	if(blockID == NetherPlus.oreMolten.blockID) {
    		return NetherPlus.oreMolten.blockID;
    	}
    	else {
            return blockID;
    	}
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    public String getTextureFile()
    {
        return "/NetherPlus/Block_Textures.png";
    }
}