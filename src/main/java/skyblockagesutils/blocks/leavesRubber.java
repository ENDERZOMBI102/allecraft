package skyblockagesutils.blocks;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.blocks.ModBlocks;

public class leavesRubber extends BlockLeaves{
	
	public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
    public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");
    protected boolean leavesFancy;
    int[] surroundings;

	public leavesRubber () {
		super();
		this.setCreativeTab(SkyblockAgesUtils.creativeTab);
		this.setUnlocalizedName("rubber_leaves");
		this.setRegistryName("rubber_leaves");
		this.fullBlock = false;
		// sets the default state of the block, the initial state will be this
		this.setDefaultState( this.blockState.getBaseState().withProperty( DECAYABLE, false ).withProperty( CHECK_DECAY, false ) );
	}
	
	public void registerItemModel(Item itemBlock) {
		SkyblockAgesUtils.proxy.registerItemRenderer( itemBlock, 0, this.getUnlocalizedName() );
		SkyblockAgesUtils.logger.debug( "registered model for item \"{}\"".replace( "{}", this.getUnlocalizedName() ) );
	}
	
	public Item createItemBlock() {
		// returns the item of the block, aka itemblock
		return new ItemBlock(this).setRegistryName( getRegistryName() );
	}
	
	@SuppressWarnings("null")
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		List<ItemStack> list = null;
		list.add( new ItemStack( Item.getItemFromBlock( this ) ) );
		return list;
	}

	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock( ModBlocks.rubberSapling );
	}
	
	// state things
	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer( this, CHECK_DECAY, DECAYABLE );
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty( DECAYABLE, Boolean.valueOf( (meta & 4) == 0 ) ).withProperty( CHECK_DECAY, Boolean.valueOf( (meta & 8) > 0 ) );
    }
	
    @Override
    public int getMetaFromState(IBlockState state) {
    	int meta = 0;
        if (!state.getValue( DECAYABLE ).booleanValue() )
        {
            meta |= 4;
        }
        if (state.getValue( CHECK_DECAY ).booleanValue() )
        {
            meta |= 8;
        }
        return meta;
    }
}
