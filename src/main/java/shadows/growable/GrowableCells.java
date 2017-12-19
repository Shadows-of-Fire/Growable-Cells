package shadows.growable;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.growable.init.AEModule;
import shadows.growable.init.ConfigFile;
import shadows.growable.init.RSModule;
import shadows.growable.proxy.CommonProxy;
import shadows.placebo.registry.RegistryInformation;
import shadows.placebo.util.RecipeHelper;

@Mod(modid = GrowableCells.MODID, name = GrowableCells.MODNAME, version = GrowableCells.VERSION, dependencies = GrowableCells.DEPS)
public class GrowableCells {
	public static final String MODID = "growablecells";
	public static final String MODNAME = "Growable Cells";
	public static final String VERSION = "3.0.0";
	public static final String DEPS = "required-after:placebo@[1.1.0,);after:refinedstorage;after:appliedenergistics2;after:waila";
	public static final String AE2ID = "appliedenergistics2";
	public static final String RSID = "refinedstorage";

	@SidedProxy(clientSide = "shadows.growable.proxy.ClientProxy", serverSide = "shadows.growable.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Configuration config;

	public static Logger logger;

	public static final RegistryInformation INFO = new RegistryInformation(MODID, null);

	public static final RecipeHelper HELPER = new RecipeHelper(MODID, MODNAME, INFO.getRecipeList());

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		config = new Configuration(e.getSuggestedConfigurationFile());
		logger = e.getModLog();
		ConfigFile.syncConfig(config);
		MinecraftForge.EVENT_BUS.register(this);
		checkDeps();
		proxy.preInit(e);
	}

	private static void checkDeps() {
		boolean loaded = false;

		if (Loader.isModLoaded(AE2ID)) {
			loaded = true;
			AEModule.load();
		}
		if (Loader.isModLoaded(RSID)) {
			loaded = true;
			RSModule.load();
		}

		if (!loaded) throw new IllegalStateException("Growable Cells has found neither AE2 or RS. At least one is required.");
	}

	@SubscribeEvent
	public void onItemRegistry(Register<Item> e) {
		e.getRegistry().registerAll(INFO.getItemList().toArray(new Item[0]));
	}

	@SubscribeEvent
	public void onBlockRegistry(Register<Block> e) {
		e.getRegistry().registerAll(INFO.getBlockList().toArray(new Block[0]));
	}

	@SubscribeEvent
	public void onRecipeRegistry(Register<IRecipe> e) {
		if (Loader.isModLoaded(AE2ID)) AEModule.loadRecipes();

		if (Loader.isModLoaded(RSID)) RSModule.loadRecipes();

		e.getRegistry().registerAll(INFO.getRecipeList().toArray(new IRecipe[0]));
	}

}
