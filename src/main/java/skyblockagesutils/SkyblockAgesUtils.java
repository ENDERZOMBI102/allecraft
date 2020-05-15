package skyblockagesutils;

import org.apache.logging.log4j.Logger;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import skyblockagesutils.client.SauTab;
import skyblockagesutils.proxy.*;
import skyblockagesutils.recipes.ModRecipes;

@Mod(modid = SkyblockAgesUtils.MODID, name = SkyblockAgesUtils.NAME, version = SkyblockAgesUtils.VERSION)
public class SkyblockAgesUtils
{
    public static final String MODID = "sau";
    public static final String NAME = "Skyblock Ages Utils";
    public static final String VERSION = "1.0";

    public static Logger logger;
    
    public static final SauTab creativeTab = new SauTab();
    
    @Mod.Instance(MODID)
    public static SkyblockAgesUtils instance;
    
    @SidedProxy(serverSide = "skyblockagesutils.proxy.CommonProxy", clientSide = "skyblockagesutils.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        ModRecipes.init();
    }
    
    
    
}
