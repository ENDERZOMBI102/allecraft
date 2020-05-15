package skyblockagesutils.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;
import skyblockagesutils.blocks.ModBlocks;
import skyblockagesutils.items.ModItems;

public class ModRecipes {
	
	public static void init() {
		/***OREDICT***/
		ModBlocks.rubberLog.initOreDict();
		ModBlocks.rubberPlank.initOreDict();
		ModBlocks.rubberLeaves.initOreDict();
		/***FURNACES**/
		//rubber log to charcoal
		GameRegistry.addSmelting(ModBlocks.rubberLog, new ItemStack(Items.COAL, 1, 1), 0.0f);
	}
}
