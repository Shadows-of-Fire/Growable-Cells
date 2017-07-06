package shadows.growable.core;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigFile {

	public static boolean allowBonemeal = false;
	public static boolean extraFromFluix = true;
	public static boolean extraFromCertus = true;
	public static boolean extraFromPurpur = true;
	public static boolean extraFromQuartz = true;

	public static void syncConfig() { // Gets called from preInit
		try {
			// Load config
			CommonProxy.config.load();

			// Read props from config
			Property allowBonemealProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, "allowBonemeal", "false", "If crops can be bonemealed");
			Property fluixProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, "extraFromFluix", "true", "If fluix blocks give extra seeds");
			Property certusProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, "extraFromCertus", "true", "If certus blocks give extra cells");
			Property purpurProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, "extraFromPurpur (RS)", // Property name
					"true", // Default value
					"If purpur blocks give extra seeds");
			Property quartzProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, "extraFromQuartz (RS)", // Property name
					"true", // Default value
					"If quartz blocks give extra cells"); // Comment

			allowBonemeal = allowBonemealProp.getBoolean();
			extraFromFluix = fluixProp.getBoolean();
			extraFromCertus = certusProp.getBoolean();
			extraFromPurpur = purpurProp.getBoolean();
			extraFromQuartz = quartzProp.getBoolean();
		} catch (Exception e) {
			// Failed reading/writing, just continue
		} finally {
			// Save props to config IF config changed
			if (CommonProxy.config.hasChanged())
				CommonProxy.config.save();
		}
	}

}
