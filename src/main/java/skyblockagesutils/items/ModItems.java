package skyblockagesutils.items;

import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import skyblockagesutils.items.pan.ItemPan;

public class ModItems {
	
	public static ArrayList<ItemBase> ITEMS = new ArrayList<>();
	//register all items
	public static ItemBase coagulatedLatex = new ItemBase("coagulated_latex");
	public static ItemPan pan = new ItemPan();
	public static ItemNet net = new ItemNet(32, "net_base");
	public static ItemNet net0 = new ItemNet(128, "net_reinforced");
	public static ItemNetDense netDense = new ItemNetDense(32, "net_dense");
	public static ItemNetDense netDense0 = new ItemNetDense(128, "net_dense_reinforced");
	public static ItemNetFish netFish = new ItemNetFish(32, "net_fish");
	public static ItemNetFish netFish0 = new ItemNetFish(128, "net_fish_reinforced");
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.register( coagulatedLatex );
		registry.register( pan );
		registry.registerAll(// all the nets
				net,
				net0,
				netDense,
				netDense0,
				netFish,
				netFish0
		);
	}
	
	public static void registerModels() {
		coagulatedLatex.registerItemModel();
		pan.registerItemModel();
		// all the nets
		net.registerItemModel();
		net0.registerItemModel();
		netDense.registerItemModel();
		netDense0.registerItemModel();
		netFish.registerItemModel();
		netFish0.registerItemModel();
		
	}
	
	public static void specialSetup() {
		
	}

}
