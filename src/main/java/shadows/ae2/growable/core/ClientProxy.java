package shadows.ae2.growable.core;


import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	ModRegistry.initModels();
	}
	


	
	
	
	
}
