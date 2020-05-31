package skyblockagesutils.utils;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.*;
import net.minecraftforge.common.config.Config.Type;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.items.pan.ItemPan;

@Config(modid = SkyblockAgesUtils.MODID, type = Type.INSTANCE, name = "sau")
public class Configs {
	
	//configs for the pan
	public static class PanConfigs {
		// for dropping more items than one
		public static boolean panDropsMultipleItems = false;
		
		// if this is true the pan has durability
		@Comment({
			"enable this if you want the pan to also have durability"
		})
		public static boolean panHasDurability = false;
		
		// durability used if the above config is true
		@Comment({
			"this value is used only if the durability is enabled, ignored if not"
		})
		public static int panDurability = 1000;
	}
	
	// configs for the nets
	public static class NetConfigs {
		@Comment({
			"Semicolon-separated list of items that the net can drop with probability",
			"example: <minecraft:coal>, 0.5;"
		})
		public static String netDropList = "<minecraft:gold_nugget>, 0.4;";
		
		@Comment({
			"Semicolon-separated list of items that the dense net can drop with probability",
			"example: <minecraft:coal>, 0.8;"
		})
		public static String netDenseDropList = "<minecraft:gold_nugget>, 0.7;";
		
		@Comment({
			"Semicolon-separated list of items that the fish net can drop with probability",
			"example: <minecraft:cod>, 0.8;"
		})
		public static String netFishDropList = "<minecraft:cod>, 0.9;";
	}
	
	// methods
	// sync the config (from event)
	public static void sync() {
		SkyblockAgesUtils.logger.info("config changed event recived! reloading configs!");
		ConfigManager.sync(SkyblockAgesUtils.MODID, Type.INSTANCE);
		SkyblockAgesUtils.logger.info("config file reloaded!");
		SkyblockAgesUtils.logger.info("reloading pan drops..");
		ItemPan.setupDrops();
		SkyblockAgesUtils.logger.info("finished reloading configs!");
	}
}
