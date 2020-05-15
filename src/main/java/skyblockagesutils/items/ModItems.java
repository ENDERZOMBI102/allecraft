package skyblockagesutils.items;

import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	public static ArrayList<ItemBase> ITEMS = new ArrayList<>();
	//register all items
	public static ItemBase coagulatedLatex = new ItemBase("coagulated_latex");

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(ITEMS.toArray( new ItemBase[0] ));
	}
	
	public static void registerModels() {
		for (ItemBase item : ITEMS) {
			item.registerItemModel();
		}
		
	}

}
