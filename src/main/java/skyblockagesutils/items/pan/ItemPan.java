package skyblockagesutils.items.pan;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.IItemHandler;
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
					player.inventory.addItemStackToInventory( getItemFromText( id ) );
					// if the config says no multiple drops, we can't drop multiple times
					if ( ! Configs.panDropsMultipleItems ) break;
				}
				i++;
			}
		} else {
			player.openGui(SkyblockAgesUtils.instance, 0, world, 0, 0, 0);
		}
		return EnumActionResult.SUCCESS;
    }
    
    private ItemStack getItemFromText( String id ) {
    	// remove <
    	if ( id.charAt(0) == '<' ) id = id.replaceFirst("<", "");
    	//remove >
    	if ( id.charAt( id.length()-1 ) == '>' ) id = id.replaceFirst(">", "");
    	// return a new itemstack from that id
    	return new ItemStack( Item.getByNameOrId( id ) );
    }
    
    public void registerItemModel() {
		SkyblockAgesUtils.proxy.registerItemRenderer( this, 0, this.getUnlocalizedName() );
		SkyblockAgesUtils.logger.debug( "registered model for item \"{}\"".replace("{}", this.getUnlocalizedName() ) );
	}
	
	@Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound compound) {
        return new PanInventoryProvider();
    }
}