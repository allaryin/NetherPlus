package netherplus;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;

public class Config {
	public static int oreDarkCrystalID = initConfig(175);
	public static int oreFieryCrystalID = initConfig(176);
	public static int oreWaterCrystalID = initConfig(177);
	public static int oreBlackDiamondID = initConfig(178);
	public static int oreNetherCoalID = initConfig(179);
	public static int oreMoltenID = initConfig(180);
	public static int oreNetheridiumID = initConfig(181);
	public static int blockSynthesizerID = initConfig(182);
	
	public static int crystalDarkID;
	public static int crystalFieryID;
	public static int crystalWaterID;
	public static int bookSpellFlameID;
	public static int bookSpellDarkID;
	public static int bookSpellWaterID;
	public static int itemMagicStaffID;
	public static int crystalFiery2ID;
	public static int blackDiamondID;
	public static int netherCoalID;
	public static int ingotNetheridiumID;
	public static int ingotMoltenID;
	
	public static int pickNetheridiumID;
	public static int pickBlackDiamondID;
	public static int pickMoltenID;
	public static int axeNetheridiumID;
	public static int axeBlackDiamondID;
	public static int axeMolten;
	public static int spadeNetheridium;
	public static int spadeBlackDiamondID;
	public static int spadeMoltenID;
	public static int hoeNetheridiumID;
	public static int hoeBlackDiamondID;
	public static int hoeMoltenID;
	public static int swordNetheridiumID;
	public static int swordBlackDiamondID;
	public static int swordMoltenID;
	
	public static int helmBlackDiamondID;
	public static int chestBlackDiamondID;
	public static int pantsBlackDiamondID;
	public static int bootsBlackDiamondID;
	
	public static File getMinecraftDir() {
		try {
			String s = ModLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			return new File(s.substring(0, s.lastIndexOf('/')));
		} 
		catch (URISyntaxException uri) { 
			//Not possible?
		}
		return null;
	}
	
	public static int initConfig(int j) {
		try {
			File file = new File(new File(getMinecraftDir(), "config"), "NetherPlus.cfg");
			Configuration configuration = new Configuration(file);
			configuration.load();
			System.out.println("Nether+ config loaded from " + file.getAbsolutePath());
			
	        oreDarkCrystalID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreDarkCrystal", 175).value);
	        oreFieryCrystalID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreFieryCrystal", 176).value);
	        oreWaterCrystalID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreWaterCrystal", 177).value);
	        oreBlackDiamondID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreBlackDiamond", 178).value);
	        oreNetherCoalID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreNetherCoal", 179).value);
	        oreMoltenID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreMolten", 180).value);
	        oreNetheridiumID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("oreNetheridium", 181).value);
	        blockSynthesizerID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("blockSynthesizer", 182).value);
	        
	        crystalDarkID = Integer.parseInt(configuration.getOrCreateIntProperty("crystalDark", Configuration.CATEGORY_ITEM, 6000).value);
	        crystalFieryID = Integer.parseInt(configuration.getOrCreateIntProperty("crystalFiery", Configuration.CATEGORY_ITEM, 5001).value);
	        crystalWaterID = Integer.parseInt(configuration.getOrCreateIntProperty("crystalWater", Configuration.CATEGORY_ITEM, 5002).value);
	        bookSpellFlameID = Integer.parseInt(configuration.getOrCreateIntProperty("flameSpellBook", Configuration.CATEGORY_ITEM, 5003).value);
	        bookSpellDarkID = Integer.parseInt(configuration.getOrCreateIntProperty("darkSpellBook", Configuration.CATEGORY_ITEM, 5004).value);
	        bookSpellWaterID = Integer.parseInt(configuration.getOrCreateIntProperty("waterSpellBook", Configuration.CATEGORY_ITEM, 5005).value);
	        itemMagicStaffID = Integer.parseInt(configuration.getOrCreateIntProperty("itemMagicStaff", Configuration.CATEGORY_ITEM, 5006).value);
	        crystalFiery2ID = Integer.parseInt(configuration.getOrCreateIntProperty("crystalFiery2", Configuration.CATEGORY_ITEM, 5007).value);
	        blackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("blackDiamond", Configuration.CATEGORY_ITEM, 5008).value);
	        netherCoalID = Integer.parseInt(configuration.getOrCreateIntProperty("netherCoal", Configuration.CATEGORY_ITEM, 5009).value);
	        ingotNetheridiumID = Integer.parseInt(configuration.getOrCreateIntProperty("ingotNetheridium", Configuration.CATEGORY_ITEM, 5010).value);
	        ingotMoltenID = Integer.parseInt(configuration.getOrCreateIntProperty("ingotMolten", Configuration.CATEGORY_ITEM, 5011).value);
	        
	        pickNetheridiumID = Integer.parseInt(configuration.getOrCreateIntProperty("pickNetheridium", Configuration.CATEGORY_ITEM, 5012).value);
	        pickBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("pickBlackDiamond", Configuration.CATEGORY_ITEM, 5013).value);
	        pickMoltenID = Integer.parseInt(configuration.getOrCreateIntProperty("pickMolten", Configuration.CATEGORY_ITEM, 5014).value);
	        axeNetheridiumID = Integer.parseInt(configuration.getOrCreateIntProperty("axeNetheridium", Configuration.CATEGORY_ITEM, 5015).value);
	        axeBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("axeBlackDiamondID", Configuration.CATEGORY_ITEM, 5016).value);
	        axeMolten = Integer.parseInt(configuration.getOrCreateIntProperty("axeMolten", Configuration.CATEGORY_ITEM, 5017).value);
	        spadeNetheridium = Integer.parseInt(configuration.getOrCreateIntProperty("spadeNetheridium", Configuration.CATEGORY_ITEM, 5018).value);
	        spadeBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("spadeBlackDiamondID", Configuration.CATEGORY_ITEM, 5019).value);
	        spadeMoltenID = Integer.parseInt(configuration.getOrCreateIntProperty("spadeMoltenID", Configuration.CATEGORY_ITEM, 5020).value);
	        hoeNetheridiumID = Integer.parseInt(configuration.getOrCreateIntProperty("hoeNetheridiumID", Configuration.CATEGORY_ITEM, 5021).value);
	        hoeBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("hoeBlackDiamondID", Configuration.CATEGORY_ITEM, 5022).value);
	        hoeMoltenID = Integer.parseInt(configuration.getOrCreateIntProperty("hoeMoltenID", Configuration.CATEGORY_ITEM, 5023).value);
	        swordNetheridiumID = Integer.parseInt(configuration.getOrCreateIntProperty("swordNetheridiumID", Configuration.CATEGORY_ITEM, 5024).value);
	        swordBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("swordBlackDiamondID", Configuration.CATEGORY_ITEM, 5025).value);
	        swordMoltenID = Integer.parseInt(configuration.getOrCreateIntProperty("swordMoltenID", Configuration.CATEGORY_ITEM, 5026).value);
	        
	        helmBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("helmBlackDiamondID", Configuration.CATEGORY_ITEM, 5027).value);
	        chestBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("chestBlackDiamondID", Configuration.CATEGORY_ITEM, 5028).value);
	        pantsBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("pantsBlackDiamondID", Configuration.CATEGORY_ITEM, 5029).value);
	        bootsBlackDiamondID = Integer.parseInt(configuration.getOrCreateIntProperty("bootsBlackDiamondID", Configuration.CATEGORY_ITEM, 5030).value);
	        configuration.save();
		}
		
		catch(Exception exception) {
			FMLLog.log(Level.SEVERE, exception, "Error while trying to access the Nether+ configuration! " + exception);
		}
		return j;
	}
}
