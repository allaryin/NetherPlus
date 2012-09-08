package netherplus;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;

/**
 * Base mod class for Nether+.
 * 
 * @author Joe12o
 */

@Mod(modid = "NetherPlus", name = "Nether+", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class NetherPlus {
	
	public static String netherPlusBlocks = "/netherplus/Block_Textures.png";
	public static String netherPlusItems = "/netherplus/Item_Textures.png";
	
	public static Block oreDarkCrystal;
	public static Block oreFieryCrystal;
	public static Block oreWaterCrystal;
	public static Block oreBlackDiamond;
	public static Block oreNetherCoal;
	public static Block oreNetheridium;
	public static Block oreMolten;
	public static Block blockSynthesizer;
	public static Block soulChest;
	
	public static Item crystalDark;
	public static Item crystalFiery;
	public static Item crystalFiery2;
	public static Item crystalWater;
	public static Item staff;
	public static Item bookSpellFlame;
	public static Item itemMagicStaff;
	public static Item blackDiamond;
	public static Item netherCoal;
	public static Item ingotNetheridium;
	public static Item ingotMolten;
	
	public static Item pickNetheridium;
	public static Item pickBlackDiamond;
	public static Item pickMolten;
	public static Item axeNetheridium;
	public static Item axeBlackDiamond;
	public static Item axeMolten;
	public static Item spadeNetheridium;
	public static Item spadeBlackDiamond;
	public static Item spadeMolten;
	public static Item hoeNetheridium;
	public static Item hoeBlackDiamond;
	public static Item hoeMolten;
	public static Item swordNetheridium;
	public static Item swordBlackDiamond;
	public static Item swordMolten;
	public static Item helmBlackDiamond;
	public static Item chestBlackDiamond;
	public static Item pantsBlackDiamond;
	public static Item bootsBlackDiamond;
	
	public static EnumArmorMaterial A_BLACK_DIAMOND;
	public static EnumToolMaterial T_BLACK_DIAMOND;
	public static EnumToolMaterial T_NETHERIDIUM;
	public static EnumToolMaterial T_MOLTEN;
	
	private Configuration configuration;
	
	@SidedProxy(clientSide = "netherplus.ClientProxy", serverSide = "netherplus.CommonProxy")
	public static CommonProxy proxy;
	@Instance
	public static NetherPlus instance;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		try {
			configuration = new Configuration(event.getSuggestedConfigurationFile());
			configuration.load();
			System.out.println("Nether+ configuration loaded successfully.");
		}
		catch(Exception exception) {
			FMLLog.log(Level.WARNING, exception, "Error while trying to access the Nether+ configuration!");
		}
		initBlocks(configuration);
		initItems(configuration);
	}
	
	@Init
	public void initialize(FMLInitializationEvent evt) {
		proxy.preloadTexture(netherPlusBlocks);
		proxy.preloadTexture(netherPlusItems);
		
		registerEntities();
		initRecipes();
		
		LanguageRegistry.instance().addStringLocalization("item.cast.fireblast", "en_US", "Selected Spell: Fire Blast I");
		LanguageRegistry.instance().addStringLocalization("item.cast.fireblast2", "en_US", "Selected Spell: Fire Blast II");
	    
		LanguageRegistry.instance().addStringLocalization("item.cast.darkspell", "en_US", "Selected Spell: Dark Spell I");
		LanguageRegistry.instance().addStringLocalization("item.cast.darkspell2", "en_US", "Selected Spell: Dark Spell II");
	    
		LanguageRegistry.instance().addStringLocalization("item.cast.waterburst", "en_US", "Selected Spell: Water Burst I");
		LanguageRegistry.instance().addStringLocalization("item.cast.waterburst2", "en_US", "Selected Spell: Water Burst II");
	    
		LanguageRegistry.instance().addStringLocalization("container.synthesizer", "en_US", "Crystal Synthesizer");
		
		GameRegistry.registerWorldGenerator(new NetherGenerator());
		GameRegistry.registerFuelHandler(new FuelHandler());
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}
	
	//Adds blocks
	private void initBlocks(Configuration cfg) {
		
		oreDarkCrystal = new BlockOre(getBlockID(cfg, "oreDarkCrystal", 204), 0).setHardness(0.8F).setResistance(5.0F).setBlockName("oreDarkCrystal");
		oreFieryCrystal = new BlockOre(getBlockID(cfg, "oreFieryCrystal", 205), 1).setHardness(0.9F).setResistance(5.0F).setBlockName("oreFieryCrystal");
		oreWaterCrystal = new BlockOre(getBlockID(cfg, "oreWaterCrystal", 206), 2).setHardness(0.9F).setResistance(5.0F).setBlockName("oreWaterCrystal");
		oreBlackDiamond = new BlockOre(getBlockID(cfg, "oreBlackDiamond", 200), 3).setHardness(0.8F).setResistance(5.0F).setBlockName("oreBlackDiamond");
		oreNetherCoal = new BlockOre(getBlockID(cfg, "oreNetherCoal", 201), 4).setHardness(0.8F).setResistance(5.0F).setBlockName("oreNetherCoal");
		oreNetheridium = new BlockOre(getBlockID(cfg, "oreNetheridium", 202), 5).setHardness(0.8F).setResistance(5.0F).setBlockName("oreNetheridium");
		oreMolten = new BlockOre(getBlockID(cfg, "oreMolten", 203), 6).setHardness(0.8F).setResistance(5.0F).setBlockName("oreMolten");
		blockSynthesizer = new BlockSynthesizer(getBlockID(cfg, "crystalSynthesizer", 207), 16).setHardness(1.0F).setResistance(5.0F).setBlockName("blockUpgrader");
		cfg.save();
		
		
		NetherPlusCore.addName(oreDarkCrystal, "Dark Crystal Ore");
		NetherPlusCore.addName(oreFieryCrystal, "Fiery Crystal Ore");
		NetherPlusCore.addName(oreWaterCrystal, "Water Crystal Ore");
		NetherPlusCore.addName(oreBlackDiamond, "Black Diamond Ore");
		NetherPlusCore.addName(oreNetherCoal, "Nethercoal Ore");
		NetherPlusCore.addName(oreNetheridium, "Netheridium Ore");
		NetherPlusCore.addName(oreMolten, "Molten Ore");
		NetherPlusCore.addName(blockSynthesizer, "Crystal Synthesizer");
		
		GameRegistry.registerBlock(oreDarkCrystal);
		GameRegistry.registerBlock(oreFieryCrystal);
		GameRegistry.registerBlock(oreWaterCrystal);
		GameRegistry.registerBlock(oreBlackDiamond);
		GameRegistry.registerBlock(oreNetherCoal);
		GameRegistry.registerBlock(oreNetheridium);
		GameRegistry.registerBlock(oreMolten);
		GameRegistry.registerBlock(blockSynthesizer);
		
		NetherPlusCore.setBlockHarvestLevel(oreBlackDiamond, "pickaxe", 2);
		NetherPlusCore.setBlockHarvestLevel(oreMolten, "pickaxe", 3);
		NetherPlusCore.setBlockHarvestLevel(oreNetherCoal, "pickaxe", 0);
		NetherPlusCore.setBlockHarvestLevel(oreNetheridium, "pickaxe", 1);
		
		NetherPlusCore.setBlockHarvestLevel(oreFieryCrystal, "pickaxe", 2);
		NetherPlusCore.setBlockHarvestLevel(oreWaterCrystal, "pickaxe", 2);
		NetherPlusCore.setBlockHarvestLevel(oreDarkCrystal, "pickaxe", 2);
	}
	
	//Adds items
	private void initItems(Configuration cfg) {
		
		int blackDiamondRenderID = proxy.registerArmorRenderID("/netherplus/blackdiamond_");
		
		A_BLACK_DIAMOND = EnumHelper.addArmorMaterial("BLACK_DIAMOND", 23, new int[]{3, 7, 5, 2}, 11);
		T_BLACK_DIAMOND = EnumHelper.addToolMaterial("BLACK_DIAMOND", 3, 1456, 8.0F, 3, 8);
		T_NETHERIDIUM = EnumHelper.addToolMaterial("NETHERIDIUM", 2, 300, 6.0F, 2, 14);
		T_MOLTEN = EnumHelper.addToolMaterial("MOLTEN", 2, 512, 7.0F, 4, 7);
		
		crystalDark = new ItemTextured(getItemID(cfg, "crystalDark", 5023)).setIconCoord(0, 0).setItemName("crystalDark");
		crystalFiery = new ItemTextured(getItemID(cfg, "crystalFiery", 5024)).setIconCoord(1, 0).setItemName("crystalFiery");
		crystalWater = new ItemTextured(getItemID(cfg, "crystalWater", 5025)).setIconCoord(2, 0).setItemName("crystalWater");
		bookSpellFlame = new SpellBook(getItemID(cfg, "spellBook", 5026)).setIconCoord(3, 0).setItemName("flameBook");
		itemMagicStaff = new ItemStaff(getItemID(cfg, "magicStaff", 5027)).setIconCoord(4, 0).setItemName("itemMagicStaff");
		blackDiamond = new ItemTextured(getItemID(cfg, "blackDiamond", 5000)).setIconCoord(6, 0).setItemName("blackDiamond");
		netherCoal = new ItemTextured(getItemID(cfg, "netherCoal", 5001)).setIconCoord(7, 0).setItemName("netherCoal");
		ingotNetheridium = new ItemTextured(getItemID(cfg, "ingotNetheridium", 5002)).setIconCoord(8, 0).setItemName("ingotNetheridium");
		ingotMolten = new ItemTextured(getItemID(cfg, "ingotMolten", 5003)).setIconCoord(9, 0).setItemName("ingotMolten");
		
		pickNetheridium = new ItemPickTextured(getItemID(cfg, "pickNetheridium", 5004), T_NETHERIDIUM).setIconCoord(0, 2).setItemName("pickNetheridium");
		pickBlackDiamond = new ItemPickTextured(getItemID(cfg, "pickBlackDiamond", 5005), T_BLACK_DIAMOND).setIconCoord(1, 2).setItemName("pickBlackDiamond");
		pickMolten = new ItemPickTextured(getItemID(cfg, "pickMolten", 5006), T_MOLTEN).setIconCoord(2, 2).setItemName("pickMolten");
		axeNetheridium = new ItemAxeTextured(getItemID(cfg, "axeNetheridium", 5007), T_NETHERIDIUM).setIconCoord(3, 2).setItemName("axeNetheridium");
		axeBlackDiamond = new ItemAxeTextured(getItemID(cfg, "axeBlackDiamond", 5008), T_BLACK_DIAMOND).setIconCoord(4, 2).setItemName("axeBlackDiamond");
		axeMolten = new ItemAxeTextured(getItemID(cfg, "axeMolten", 5009), T_MOLTEN).setIconCoord(5, 2).setItemName("axeMolten");
		spadeNetheridium = new ItemSpadeTextured(getItemID(cfg, "spadeNetheridium", 5010), T_NETHERIDIUM).setIconCoord(6, 2).setItemName("spadeNetheridium");
		spadeBlackDiamond = new ItemSpadeTextured(getItemID(cfg, "spadeBlackDiamond", 5011), T_BLACK_DIAMOND).setIconCoord(7, 2).setItemName("spadeBlackDiamond");
		spadeMolten = new ItemSpadeTextured(getItemID(cfg, "spadeMolten", 5012), T_MOLTEN).setIconCoord(8, 2).setItemName("spadeMolten");
		hoeNetheridium = new ItemHoeTextured(getItemID(cfg, "hoeNetheridium", 5013), T_NETHERIDIUM).setIconCoord(9, 2).setItemName("hoeNetheridium");
		hoeBlackDiamond = new ItemHoeTextured(getItemID(cfg, "hoeBlackDiamond", 5014), T_BLACK_DIAMOND).setIconCoord(10, 2).setItemName("hoeBlackDiamond");
		hoeMolten = new ItemHoeTextured(getItemID(cfg, "hoeMolten", 5015), T_MOLTEN).setIconCoord(11, 2).setItemName("hoeMolten");
		swordNetheridium = new ItemSwordTextured(getItemID(cfg, "swordNetheridium", 5016), T_NETHERIDIUM).setIconCoord(12, 2).setItemName("swordNetheridium");
		swordBlackDiamond = new ItemSwordTextured(getItemID(cfg, "swordBlackDiamond", 5017), T_BLACK_DIAMOND).setIconCoord(13, 2).setItemName("swordBlackDiamond");
		swordMolten = new ItemSwordTextured(getItemID(cfg, "swordMolten", 5018), T_MOLTEN).setIconCoord(14, 2).setItemName("swordMolten");
		
		helmBlackDiamond = new ItemArmorTextured(getItemID(cfg, "helmBlackDiamond", 5019), A_BLACK_DIAMOND, blackDiamondRenderID, 0).setIconCoord(0, 4).setItemName("helmBlackDiamond");
		chestBlackDiamond = new ItemArmorTextured(getItemID(cfg, "chestBlackDiamond", 5020), A_BLACK_DIAMOND, blackDiamondRenderID, 1).setIconCoord(1, 4).setItemName("chestBlackDiamond");
		pantsBlackDiamond = new ItemArmorTextured(getItemID(cfg, "pantsBlackDiamond", 5021), A_BLACK_DIAMOND, blackDiamondRenderID, 2).setIconCoord(2, 4).setItemName("pantsBlackDiamond");
		bootsBlackDiamond = new ItemArmorTextured(getItemID(cfg, "bootsBlackDiamond", 5022), A_BLACK_DIAMOND, blackDiamondRenderID, 3).setIconCoord(3, 4).setItemName("bootsBlackDiamond");
		cfg.save();
		
		NetherPlusCore.addName(crystalDark, "Dark Crystal");
		NetherPlusCore.addName(crystalFiery, "Fiery Crystal");
		NetherPlusCore.addName(crystalWater, "Water Crystal");
		NetherPlusCore.addName(bookSpellFlame, "Flame Spellbook");
		NetherPlusCore.addName(itemMagicStaff, "Staff");
		NetherPlusCore.addName(blackDiamond, "Black Diamond");
		NetherPlusCore.addName(netherCoal, "Nether Coal");
		NetherPlusCore.addName(ingotNetheridium, "Netheridium Ingot");
		NetherPlusCore.addName(ingotMolten, "Molten Ingot");
		NetherPlusCore.addName(pickNetheridium, "Netheridium Pickaxe");
		NetherPlusCore.addName(pickBlackDiamond, "Black Diamond Pickaxe");
		NetherPlusCore.addName(pickMolten, "Molten Pickaxe");
		NetherPlusCore.addName(axeNetheridium, "Netheridium Axe");
		NetherPlusCore.addName(axeBlackDiamond, "Black Diamond Axe");
		NetherPlusCore.addName(axeMolten, "Molten Axe");
		NetherPlusCore.addName(spadeNetheridium, "Netheridium Shovel");
		NetherPlusCore.addName(spadeBlackDiamond, "Black Diamond Shovel");
		NetherPlusCore.addName(spadeMolten, "Molten Shovel");
		NetherPlusCore.addName(hoeNetheridium, "Netheridium Hoe");
		NetherPlusCore.addName(hoeBlackDiamond, "Black Diamond Hoe");
		NetherPlusCore.addName(hoeMolten, "Molten Hoe");
		NetherPlusCore.addName(swordNetheridium, "Netheridium Sword");
		NetherPlusCore.addName(swordBlackDiamond, "Black Diamond Sword");
		NetherPlusCore.addName(swordMolten, "Molten Sword");
		NetherPlusCore.addName(helmBlackDiamond, "Black Diamond Helmet");
		NetherPlusCore.addName(chestBlackDiamond, "Black Diamond Chestplate");
		NetherPlusCore.addName(pantsBlackDiamond, "Black Diamond Leggings");
		NetherPlusCore.addName(bootsBlackDiamond, "Black Diamond Boots");
	}
	
	public void registerEntities() {
		//ModLoader.registerTileEntity(NPTileEntitySynthesizer.class, "Synthesizer");
	}
	
	public void initRecipes() {
		
		NetherPlusCore.addSmelting(oreNetheridium.blockID, new ItemStack(ingotNetheridium), 1.0F);
		NetherPlusCore.addSmelting(oreMolten.blockID, new ItemStack(ingotMolten), 1.0F);
		
		NetherPlusCore.addRecipe(new ItemStack(pickBlackDiamond, 1), new Object[] {"DDD", " R ", " R ", Character.valueOf('R'), Item.blazeRod, Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(hoeBlackDiamond, 1), new Object[] {"DD ", " R ", " R ", Character.valueOf('R'), Item.blazeRod, Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(swordBlackDiamond, 1), new Object[] {"D", "D", "R", Character.valueOf('R'), Item.blazeRod, Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(axeBlackDiamond, 1), new Object[] {"DD ", "DR ", " R ", Character.valueOf('R'), Item.blazeRod, Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(spadeBlackDiamond, 1), new Object[] {"D", "R", "R", Character.valueOf('R'), Item.blazeRod, Character.valueOf('D'), blackDiamond});
		
		NetherPlusCore.addRecipe(new ItemStack(pickMolten, 1), new Object[] {"MMM", " R ", " R ", Character.valueOf('R'), Item.blazeRod, Character.valueOf('M'), ingotMolten});
		NetherPlusCore.addRecipe(new ItemStack(hoeMolten, 1), new Object[] {"MM ", " R ", " R ", Character.valueOf('R'), Item.blazeRod, Character.valueOf('M'), ingotMolten});
		NetherPlusCore.addRecipe(new ItemStack(swordMolten, 1), new Object[] {"M", "M", "R", Character.valueOf('R'), Item.blazeRod, Character.valueOf('M'), ingotMolten});
		NetherPlusCore.addRecipe(new ItemStack(axeMolten, 1), new Object[] {"MM ", "MR ", " R ", Character.valueOf('R'), Item.blazeRod, Character.valueOf('M'), ingotMolten});
		NetherPlusCore.addRecipe(new ItemStack(spadeMolten, 1), new Object[] {"M", "R", "R", Character.valueOf('R'), Item.blazeRod, Character.valueOf('M'), ingotMolten});
		
		NetherPlusCore.addRecipe(new ItemStack(pickNetheridium, 1), new Object[] {"NNN", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('N'), ingotNetheridium});
		NetherPlusCore.addRecipe(new ItemStack(hoeNetheridium, 1), new Object[] {"NN ", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('N'), ingotNetheridium});
		NetherPlusCore.addRecipe(new ItemStack(swordNetheridium, 1), new Object[] {"N", "N", "S", Character.valueOf('S'), Item.stick, Character.valueOf('N'), ingotNetheridium});
		NetherPlusCore.addRecipe(new ItemStack(axeNetheridium, 1), new Object[] {"NN ", "NS ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('N'), ingotNetheridium});
		NetherPlusCore.addRecipe(new ItemStack(spadeNetheridium, 1), new Object[] {"N", "S", "S", Character.valueOf('S'), Item.stick, Character.valueOf('N'), ingotNetheridium});
		
		NetherPlusCore.addRecipe(new ItemStack(helmBlackDiamond, 1), new Object[] {"DDD", "D D", Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(chestBlackDiamond, 1), new Object[] {"D D", "DDD", "DDD", Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(pantsBlackDiamond, 1), new Object[] {"DDD", "D D", "D D", Character.valueOf('D'), blackDiamond});
		NetherPlusCore.addRecipe(new ItemStack(bootsBlackDiamond, 1), new Object[] {"D D", "D D", Character.valueOf('D'), blackDiamond});

		NetherPlusCore.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] {"C", "S", Character.valueOf('S'), Item.stick, Character.valueOf('C'), netherCoal});
	}
	
	public int getBlockID(Configuration cfg, String name, int defaultID) {
		if(cfg == null) {
			return defaultID;
		}
		else {
			try {
				return cfg.getOrCreateBlockIdProperty(name, defaultID).getInt(defaultID);
			}
			catch(Exception exception) {
				FMLLog.log(Level.WARNING, exception, "Error while trying to access the Nether+ configuration!");
				return defaultID;
			}
		}
	}
	
	public int getItemID(Configuration cfg, String name, int defaultID) {
		if(cfg == null) {
			return defaultID;
		}
		else {
			try {
				return cfg.getOrCreateIntProperty(name, Configuration.CATEGORY_ITEM, defaultID).getInt(defaultID);
			}
			catch(Exception exception) {
				FMLLog.log(Level.WARNING, exception, "Error while trying to access the Nether+ configuration!");
				return defaultID;
			}
		}
	}
}