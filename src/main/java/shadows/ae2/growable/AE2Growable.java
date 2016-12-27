package shadows.ae2.growable;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shadows.ae2.growable.core.CommonProxy;

@Mod(modid = AE2Growable.MODID, name = AE2Growable.MODNAME, version = AE2Growable.VERSION, dependencies = "required-after:appliedenergistics2")
public class AE2Growable
{
    public static final String MODID = "growablecells";
    public static final String MODNAME = "Growable AE2 Cells";
    public static final String VERSION = "0.1.0";
    
    @SidedProxy(clientSide = "shadows.ae2.growable.core.ClientProxy", serverSide = "shadows.ae2.growable.core.ServerProxy")
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
