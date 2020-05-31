package skyblockagesutils.blocks.faucelet;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import skyblockagesutils.blocks.BlockTileEntity;

public class Faucelet extends BlockTileEntity<TileEntityFaucelet> {
	public Faucelet() {
		super(Material.WOOD, "faucelet");//init the block
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityFaucelet tile = getTileEntity(world, pos);
			if (side == EnumFacing.DOWN) {
				tile.decrementCount();
			} else if (side == EnumFacing.UP) {
				tile.incrementCount();
			}
			player.sendMessage(new TextComponentString("Count: " + tile.getCount()));
		}
		return true;
	}
	
	@Override
	public Class<TileEntityFaucelet> getTileEntityClass() {
		return TileEntityFaucelet.class;
	}
	
	@Nullable
	@Override
	public TileEntityFaucelet createTileEntity(World world, IBlockState state) {
		return new TileEntityFaucelet();
	}
	
	
	// model stuff
	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;// isn't really deprecated? :thinking:
	}
	
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;// isn't really deprecated? :thinking:
	}
	// sound stuff
	@Override
	public SoundType getSoundType() {
		return SoundType.WOOD;
	}
}
