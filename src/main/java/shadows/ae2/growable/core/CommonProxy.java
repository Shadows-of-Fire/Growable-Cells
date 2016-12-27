package shadows.ae2.growable.core;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;


public class CommonProxy {
	public static Configuration config;
    public void preInit(FMLPreInitializationEvent e) {
        // Initialization of blocks and items typically goes here:
    	config = new Configuration(e.getSuggestedConfigurationFile());
    	ConfigFile.syncConfig();
    	ModRegistry.init();
    	RecipeManager.initRecipes();
    	
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

}