package skyblockagesutils.blocks;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import skyblockagesutils.blocks.faucelet.Faucelet;

public class ModBlocks {
	
	public static ArrayList<BlockBase> BLOCKS = new ArrayList<>();
	
	public static BlockBase rubberLog = new BlockBase(Material.WOOD, "rubber_log");
	public static BlockBase rubberPlank = new BlockBase(Material.WOOD, "rubber_plank");
	public static BlockBase rubberStripped = new BlockBase(Material.WOOD, "rubber_stripped");
	public static leavesRubber rubberLeaves = new leavesRubber();
	public static Faucelet faucelet = new Faucelet();
	public static saplingRubber rubberSapling= new saplingRubber();
	
	@SuppressWarnings("deprecation")
	public static void register(IForgeRegistry<Block> registry) {
		registry.register( rubberLog );
		registry.register( rubberPlank );
		registry.register( rubberStripped );
		registry.register( rubberLeaves );
		registry.register( faucelet );
		registry.register( rubberSapling );
		GameRegistry.registerTileEntity(faucelet.getTileEntityClass(), faucelet.getRegistryName().toString());
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.register( rubberLog.createItemBlock() );
		registry.register( rubberPlank.createItemBlock() );
		registry.register( rubberStripped.createItemBlock() );
		registry.register( rubberLeaves.createItemBlock() );
		registry.register( faucelet.createItemBlock() );
		registry.register( rubberSapling.createItemBlock() );
	}

	public static void registerModels() {
		rubberLog.registerItemModel( Item.getItemFromBlock( rubberLog ) );
		rubberPlank.registerItemModel( Item.getItemFromBlock( rubberPlank ) );
		rubberStripped.registerItemModel( Item.getItemFromBlock( rubberStripped ) );
		rubberLeaves.registerItemModel( Item.getItemFromBlock( rubberLeaves ) );
		faucelet.registerItemModel( Item.getItemFromBlock( faucelet ) );
		rubberSapling.registerItemModel( Item.getItemFromBlock( rubberSapling ) );
	}

}
