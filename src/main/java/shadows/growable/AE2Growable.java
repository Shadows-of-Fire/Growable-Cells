package shadows.growable;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shadows.growable.core.CommonProxy;

@Mod(modid = AE2Growable.MODID, name = AE2Growable.MODNAME, version = AE2Growable.VERSION, dependencies = "after:refinedstorage;after:appliedenergistics2", acceptedMinecraftVersions = "1.10.2;1.11.2")
public class AE2Growable {
	public static final String MODID = "growablecells";
	public static final String MODNAME = "Growable Cells";
	public static final String VERSION = "1.0.0";

	@SidedProxy(clientSide = "shadows.growable.core.ClientProxy", serverSide = "shadows.growable.core.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static AE2Growable instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws NullPointerException {
		if (!Loader.isModLoaded("appliedenergistics2") && !Loader.isModLoaded("refinedstorage"))
			throw new NullPointerException("URGENT: Growable Cells has found neither AE2 or RS. The mod WILL NOT work.");
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
