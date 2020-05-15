package skyblockagesutils.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOredict extends BlockBase {
	
	private String oreName;
	
	public BlockOredict(Material material, String name, String oreName) {
		super(material, name);
		
		this.oreName = oreName;
	}
	
	public void initOreDict() {
		OreDictionary.registerOre(oreName, this);
	}
}
