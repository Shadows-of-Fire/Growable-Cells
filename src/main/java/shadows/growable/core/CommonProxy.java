package shadows.growable.core;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent e) {
		// Initialization of blocks and items typically goes here:
		config = new Configuration(e.getSuggestedConfigurationFile());
		ConfigFile.syncConfig();
		if (Loader.isModLoaded("appliedenergistics2")) {
			ModRegistry.initAE();
			RecipeManager.initAE();
		}
		if (!Loader.isModLoaded("appliedenergistics2"))
			System.out.println("Growable Cells: Applied Energistics 2 not loaded");
		if (Loader.isModLoaded("refinedstorage")) {
			ModRegistry.initRS();
			RecipeManager.initRS();
		}
		if (!Loader.isModLoaded("refinedstorage"))
			System.out.println("Growable Cells: Refined Storage not loaded.");

	}

	public void init(FMLInitializationEvent e) {

	}

	public void postInit(FMLPostInitializationEvent e) {

	}

}