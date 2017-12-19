package shadows.growable.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.growable.GrowableCells;
import shadows.growable.integration.Waila;
import shadows.placebo.client.IHasModel;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(this);
		if (Loader.isModLoaded("waila")) FMLInterModComms.sendMessage("waila", "register", Waila.class.getName() + ".callbackRegister");
	}

	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent e) {
		for (Block b : GrowableCells.INFO.getBlockList())
			if (b instanceof IHasModel) ((IHasModel) b).initModels(e);
		for (Item i : GrowableCells.INFO.getItemList())
			if (i instanceof IHasModel) ((IHasModel) i).initModels(e);
	}

}
