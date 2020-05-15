package skyblockagesutils.utils;

import skyblockagesutils.blocks.ModBlocks;
import skyblockagesutils.items.ModItems;
import skyblockagesutils.SkyblockAgesUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class Handlers {
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
		SkyblockAgesUtils.logger.info("registering blocks..");
		ModBlocks.register(event.getRegistry());
		SkyblockAgesUtils.logger.info("registered all blocks!");
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	SkyblockAgesUtils.logger.info("registering items..");
    	ModItems.register(event.getRegistry());
    	ModBlocks.registerItemBlocks(event.getRegistry());
    	SkyblockAgesUtils.logger.info("registered all items!");
    }
    
    @SubscribeEvent
	public static void registerItems(ModelRegistryEvent event) {
    	SkyblockAgesUtils.logger.info("registering models..");
		ModItems.registerModels();
		ModBlocks.registerModels();
		SkyblockAgesUtils.logger.info("registered all models!");
	}
    
}
