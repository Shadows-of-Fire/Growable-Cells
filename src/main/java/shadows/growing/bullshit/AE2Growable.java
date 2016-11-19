package shadows.growing.bullshit;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AE2Growable.MODID, name = AE2Growable.MODNAME, version = AE2Growable.VERSION, dependencies = "required-after:appliedenergistics2")
public class AE2Growable
{
    public static final String MODID = "growablecells";
    public static final String MODNAME = "Growable AE2 Cells";
    public static final String VERSION = "lmao";
    
    @SidedProxy(clientSide = "shadows.growing.bullshit.ClientProxy", serverSide = "shadows.growing.bullshit.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static AE2Growable instance;
    
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
    	proxy.init(e);
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	proxy.postInit(e);
    }

}
