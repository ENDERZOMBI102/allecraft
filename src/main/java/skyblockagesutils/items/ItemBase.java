package skyblockagesutils.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.items.ModItems;

public class ItemBase extends Item {

	protected String name;

	public ItemBase(String name) {
		
		this.name = name;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(SkyblockAgesUtils.creativeTab);
		
		ModItems.ITEMS.add(this);
		SkyblockAgesUtils.logger.debug( "created item \"{}\"".replace("{}", name) );
	}
	
	public void registerItemModel() {
		SkyblockAgesUtils.proxy.registerItemRenderer(this, 0, name);
		SkyblockAgesUtils.logger.debug("registered model for item \"{}\"".replace("{}", name));
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
