package skyblockagesutils;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.block.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

import init.BlockInit;
import init.ItemInit;

@Mod(modid = SkyblockAgesUtils.MODID, name = SkyblockAgesUtils.NAME, version = SkyblockAgesUtils.VERSION)
public class SkyblockAgesUtils
{
    public static final String MODID = "sau";
    public static final String NAME = "Skyblock Ages Utils";
    public static final String VERSION = "1.0";

    private static Logger logger;

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
        BlockInit()
    }
    
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
    	event.getRegistry().registerAll(BlockInit.BLOCKS.toArray( new Block[0] ));
    }
    
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
    	event.getRegistry().registerAll(ItemInit.ITEMS.toArray( new Item[0] ));
    }
    
}
