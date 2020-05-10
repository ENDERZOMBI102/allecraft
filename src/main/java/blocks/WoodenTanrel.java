package blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import init.BlockInit;
import init.ItemInit;

public class WoodenTanrel extends Block {

	public WoodenTanrel() {
		super(Material.WOOD);
		this.setUnlocalizedName("Wooden Tanrel");
		this.setRegistryName("Wooden Tanrel");
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add( new ItemBlock(this).setRegistryName("Wooden Tanrel"));
	}

}
