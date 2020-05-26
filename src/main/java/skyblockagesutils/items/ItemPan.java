package skyblockagesutils.items;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.utils.Configs;

public class ItemPan extends Item {
	
	private static final ArrayList<String> dropList = new ArrayList<>();
	private static final ArrayList<Double> chanceList = new ArrayList<>();
	
	public ItemPan() {
		// default things
		super();
		this.setMaxStackSize(64);
        this.setCreativeTab(SkyblockAgesUtils.creativeTab);
        this.setRegistryName("pan");
        this.setUnlocalizedName("pan");
        
        setupDrops();
	}
	
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// get the block the user is pointing at
    	Block block = world.getBlockState(pos.offset(facing)).getBlock();
		// check if is water
		if (block.equals(Blocks.WATER) || block.equals(Blocks.FLOWING_WATER)) {
			int i = 0;
			// cycle in the drops
			for ( String id : dropList ) {
				// if we get a number lower than the chance, drop the corresponding item
				if ( Math.random() < chanceList.get( i ) ) {
					// drop the item
					player.inventory.addItemStackToInventory( new ItemStack( Item.getByNameOrId( id ) ) );
					// if the config says no multiple drops, we can't drop
					if ( ! Configs.panDropsMultipleItems ) break;
				}
				i++;
			}
		}
		return EnumActionResult.SUCCESS;
    }
    
    public static void setupDrops() {
    	SkyblockAgesUtils.logger.info("loading drops for pan!");
    	// create variables
    	String[] singleItems = Configs.panDropList.split(";");
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
    	SkyblockAgesUtils.logger.info("successuffly loaded pan drops!");
    }
}