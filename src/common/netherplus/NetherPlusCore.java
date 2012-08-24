package netherplus;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import netherplus.SpellBook;

public class NetherPlusCore {
	
	public static int spellType;
	public static int damageAmount;
	private static boolean placeHolder;
	
	public static void addName(Object instance, String name) {
		LanguageRegistry.instance().addNameForObject(instance, "en_US", name);
	}
	
	public static void setBlockHarvestLevel(Block block, String type, int harvestLevel) {
		MinecraftForge.setBlockHarvestLevel(block, type, harvestLevel);
	}
	
	public static void addSmelting(int input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	
	public static void addRecipe(ItemStack output, Object... params) {
		GameRegistry.addRecipe(output, params);
	}
	
	public static void removeUsedCrystals(EntityPlayer entityplayer, int j, int k) {
        if (!entityplayer.capabilities.isCreativeMode)
        {
        	entityplayer.inventory.consumeInventoryItem(j);
        	entityplayer.inventory.consumeInventoryItem(k);
        }
	}
	
	public void castSpell(int i, int j) {
		spellType = i;
		damageAmount = j;
	}
	/*
	public static boolean getHasRequiredItems(EntityPlayer entityplayer) {
		if(placeHolder) {
			if(entityplayer.inventory.hasItem(mod_NetherPlus.crystalFiery.shiftedIndex)) {
				removeUsedCrystals(entityplayer, mod_NetherPlus.crystalFiery.shiftedIndex, 0);
				return true;
			}
		}
		
		if(!placeHolder) {
			if(entityplayer.inventory.hasItem(mod_NetherPlus.crystalFiery.shiftedIndex) && entityplayer.inventory.hasItem(mod_NetherPlus.crystalWater.shiftedIndex)) {
				removeUsedCrystals(entityplayer, mod_NetherPlus.crystalFiery.shiftedIndex, mod_NetherPlus.crystalWater.shiftedIndex);
				return true;
			}
		}
		return false;
	}*/
}
