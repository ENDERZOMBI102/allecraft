package skyblockagesutils.utils;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.*;
import net.minecraftforge.common.config.Config.Type;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.items.ItemPan;

@Config(modid = SkyblockAgesUtils.MODID, type = Type.INSTANCE, name = "sau")
public class Configs {
	
	@Comment({
		"Enable the crafttweaker integration",
		"WARNING: makes the mod REQUIRE crafttweaker"
	})
	public static boolean crafttweaker = false;
	
	// for dropping more items than one
	public static boolean panDropsMultipleItems = false;
	
	// contains the drop list
	@Comment({
		"Semicolon-separated list of items that the pan can drop with probability",
		"example: <minecraft:coal>, 0.5;"
	})
	public static String panDropList = "<minecraft:gold_nugget>, 0.4;";
	
	
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
	// sync the config (from command)
	public static void syncFromCommand() {
		SkyblockAgesUtils.logger.info("command \"reload\" recived! reloading configs!");
		ConfigManager.sync(SkyblockAgesUtils.MODID, Type.INSTANCE);
		SkyblockAgesUtils.logger.info("config file reloaded!");
		SkyblockAgesUtils.logger.info("reloading pan drops..");
		ItemPan.setupDrops();
		SkyblockAgesUtils.logger.info("finished reloading configs!");
	}
}
