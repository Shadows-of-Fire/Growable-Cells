package shadows.growable.init;

import net.minecraftforge.common.config.Configuration;

public class ConfigFile {

	public static boolean allowBonemeal = false;
	public static boolean extraFromFluix = true;
	public static boolean extraFromCertus = true;
	public static boolean extraFromPurpur = true;
	public static boolean extraFromQuartz = true;

	public static void syncConfig(Configuration config) {
		config.load();

		// Read props from config
		allowBonemeal = config.getBoolean(Configuration.CATEGORY_GENERAL, "allowBonemeal", false, "If crops can be bonemealed");
		extraFromFluix = config.getBoolean(Configuration.CATEGORY_GENERAL, "extraFromFluix", true, "If fluix blocks give extra seeds");
		extraFromCertus = config.getBoolean(Configuration.CATEGORY_GENERAL, "extraFromCertus", true, "If certus blocks give extra cells");
		extraFromPurpur = config.getBoolean(Configuration.CATEGORY_GENERAL, "extraFromPurpur (RS)", true, "If purpur blocks give extra seeds");
		extraFromQuartz = config.getBoolean(Configuration.CATEGORY_GENERAL, "extraFromQuartz (RS)", true, "If quartz blocks give extra cells");

		if (config.hasChanged()) config.save();

	}

}
