package skyblockagesutils.items;

import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.utils.Configs;

public class ItemNetFish extends ItemNet {

	public ItemNetFish(int durability, String name) {
		super(durability, name);
		setupDrops();
	}
	
	public static void setupDrops() {
    	SkyblockAgesUtils.logger.info("loading drops for fish net!");
    	// create variables
    	String[] singleItems = Configs.NetConfigs.netFishDropList.split(";");
    	String[] tmp = null;
    	try {
    		// for every drop-chance
	    	for (String i : singleItems ) {
	    		tmp = i.split(",");// divide them
	    		dropList.add( tmp[0] );// drop
	    		chanceList.add( Double.parseDouble( tmp[1] ) );// chance
	    	}
    	} catch (NumberFormatException e) {
    		// ERROR :(
    		SkyblockAgesUtils.logger.error("Found invalid double number at item {}! pls correct!".replace("{}", tmp[0]));
    		return;
    	}
    	// success!
    	SkyblockAgesUtils.logger.info("successffully loaded fish net drops!");
    }

}
