package skyblockagesutils;

import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;
import skyblockagesutils.client.SauTab;
import skyblockagesutils.items.ModItems;
import skyblockagesutils.proxy.*;
import skyblockagesutils.recipes.ModRecipes;
import skyblockagesutils.utils.Configs;

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
        changeTitle();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("registring recipes..");
        ModRecipes.init();
        logger.info("recipes registered!");
        logger.info("special setups..");
        ModItems.specialSetup();
        logger.info("special setup finished!");
    }
    
    public void changeTitle() {
    	String title = Configs.windowName;
    	if ( ! title.equalsIgnoreCase("null") ) {
    		Display.setTitle(title);
    	}
    }
    
}
