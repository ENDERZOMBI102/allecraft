package skyblockagesutils.items;

import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.utils.Configs;

public class ItemNetDense extends ItemNet {

	public ItemNetDense(int durability, String name) {
		super(durability, name);
		setupDrops();
	}
	
	public static void setupDrops() {
    	SkyblockAgesUtils.logger.info("loading drops for dense net!");
    	// create variables
    	String[] singleItems = Configs.NetConfigs.netDenseDropList.split(";");
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
    	SkyblockAgesUtils.logger.info("successffully loaded dense net drops!");
    }
}
