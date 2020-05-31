package skyblockagesutils.items;

import java.util.ArrayList;

import net.minecraft.item.Item;
import skyblockagesutils.utils.Configs;
import skyblockagesutils.SkyblockAgesUtils;

public class ItemNet extends Item {
	
	public static final ArrayList<String> dropList = null;
	public static final ArrayList<Double> chanceList = null;
	
	public ItemNet( int durability, String name ) {
		super();
		//setup item info
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
		this.canRepair = false;
		this.setCreativeTab(SkyblockAgesUtils.creativeTab);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		setupDrops();
	}
	
	public void registerItemModel() {
		SkyblockAgesUtils.proxy.registerItemRenderer( this, 0, this.getUnlocalizedName() );
		SkyblockAgesUtils.logger.debug( "registered model for item \"{}\"".replace( "{}", this.getUnlocalizedName() ) );
	}
	
	public static void setupDrops() {
    	SkyblockAgesUtils.logger.info("loading drops for net!");
    	// create variables
    	String[] singleItems = Configs.NetConfigs.netDropList.split(";");
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
    	SkyblockAgesUtils.logger.info("successffully loaded net drops!");
    }

}
