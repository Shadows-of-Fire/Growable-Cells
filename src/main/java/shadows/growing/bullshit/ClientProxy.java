package shadows.growing.bullshit;


import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	ModRegistry.initModels();
	}
	


	
	
	
	
}
