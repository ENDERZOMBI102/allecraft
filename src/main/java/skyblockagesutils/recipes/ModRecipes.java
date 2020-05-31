package skyblockagesutils.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.*;
import skyblockagesutils.blocks.ModBlocks;
import skyblockagesutils.items.ModItems;

public class ModRecipes {
	
	public static void init() {
		/***OREDICT***/
		OreDictionary.registerOre("logWood", ModBlocks.rubberLog);// rubber log
		OreDictionary.registerOre("plankWood", ModBlocks.rubberPlank);// rubber planks
		OreDictionary.registerOre("treeLeaves", ModBlocks.rubberLeaves);//rubber leaves
		OreDictionary.registerOre("treeSapling", ModBlocks.rubberSapling);// rubber sapling
		OreDictionary.registerOre("slimeball", ModItems.coagulatedLatex);// coagulated latex
		/***FURNACES**/
		//rubber log to charcoal
		GameRegistry.addSmelting(ModBlocks.rubberLog, new ItemStack(Items.COAL, 1, 1), 0.0f);
	}
}
