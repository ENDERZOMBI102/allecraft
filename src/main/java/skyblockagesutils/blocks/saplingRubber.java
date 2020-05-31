package skyblockagesutils.blocks;

import java.util.Random;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.world.generation.generators.WorldGenTreeRubber;

@SuppressWarnings("deprecation")
public class saplingRubber extends BlockSapling implements IGrowable{
	
	public saplingRubber() {
		super();
		this.setCreativeTab(SkyblockAgesUtils.creativeTab);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName("rubber_sapling");
		this.setRegistryName(this.getUnlocalizedName());
	}
	
	public void registerItemModel(Item itemBlock) {
		SkyblockAgesUtils.proxy.registerItemRenderer( itemBlock, 0, this.getUnlocalizedName() );
		SkyblockAgesUtils.logger.debug("registered item model for block \"rubber_sapling\"");
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName( getRegistryName() );
	}
	
	@Override
	public String getLocalizedName() {
        return I18n.translateToLocal(this.getUnlocalizedName());
    }
	
	@Override
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		//if the sapling can't grow exit...?
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
		//create the world gen instance
        WorldGenerator worldgenerator = new WorldGenTreeRubber();
        //get the air state?
        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();
        // do something
        worldIn.setBlockState(pos, iblockstate2, 4);
        //generate?
        if (!worldgenerator.generate(worldIn, rand, pos.add(0, 0, 0)))
        {
        	worldIn.setBlockState(pos, state, 4);
        }
	}
	
}
