package skyblockagesutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.blocks.ModBlocks;;

public class BlockBase extends Block {

	protected String name;

	public BlockBase(Material material, String name) {
		super(material);
	
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(SkyblockAgesUtils.creativeTab);
		
		ModBlocks.BLOCKS.add(this);
		SkyblockAgesUtils.logger.debug( "created block \"{}\"".replace("{}", name) );
	}
	
	public void registerItemModel(Item itemBlock) {
		SkyblockAgesUtils.proxy.registerItemRenderer(itemBlock, 0, name);
		SkyblockAgesUtils.logger.debug("registered model for item \"{}\"".replace("{}", name));
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	@Override
	public BlockBase setSoundType(SoundType sound) {
		this.blockSoundType = sound;
		return this;
	}
}
