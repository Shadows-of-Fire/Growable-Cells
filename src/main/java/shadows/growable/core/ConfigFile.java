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
			Property allowBonemealProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What
					// category
					// will
					// it
					// be
					// saved
					// to,
					// can
					// be
					// any
					// string
					"allowBonemeal", // Property name
					"false", // Default value
					"If crops can be bonemealed"); // Comment
			Property fluixProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What
					// category
					// will
					// it
					// be
					// saved
					// to,
					// can
					// be
					// any
					// string
					"extraFromFluix", // Property name
					"true", // Default value
					"If fluix blocks give extra seeds"); // Comment
			Property certusProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What
					// category
					// will
					// it
					// be
					// saved
					// to,
					// can
					// be
					// any
					// string
					"extraFromCertus", // Property name
					"true", // Default value
					"If certus blocks give extra cells"); // Comment
			Property purpurProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What
					// category
					// will
					// it
					// be
					// saved
					// to,
					// can
					// be
					// any
					// string
					"extraFromPurpur (RS)", // Property name
					"true", // Default value
					"If purpur blocks give extra seeds"); // Comment
			Property quartzProp = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What
					// category
					// will
					// it
					// be
					// saved
					// to,
					// can
					// be
					// any
					// string
					"extraFromQuartz (RS)", // Property name
					"true", // Default value
					"If quartz blocks give extra cells"); // Comment

			allowBonemeal = allowBonemealProp.getBoolean(); // Get the boolean
															// value, also set
															// the property
															// value to boolean
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
