package skyblockagesutils.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import skyblockagesutils.SkyblockAgesUtils;
import skyblockagesutils.items.ModItems;

public class SauTab extends CreativeTabs {
	
	public SauTab() {
		super(SkyblockAgesUtils.MODID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.coagulatedLatex);
	}

}