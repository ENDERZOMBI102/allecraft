package skyblockagesutils.items.pan;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import skyblockagesutils.items.ModItems;

public class SlotPan extends Slot{

	public SlotPan(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		boolean valid = false;
		Item item = stack.getItem();
		if ( item.getClass().equals( ModItems.net.getClass() ) || // is a net?
				item.getClass().equals( ModItems.netDense.getClass() ) || // is a dense net?
						item.getClass().equals( ModItems.net.getClass() ) // is a fish net?
			) valid = true;
		return valid;
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
		
	}
	
}
