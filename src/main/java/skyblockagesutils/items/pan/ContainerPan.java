package skyblockagesutils.items.pan;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public class ContainerPan extends Container {

	private final ItemPan pan;
	
	public ContainerPan(InventoryPlayer player, ItemPan pan) {
		this.pan = pan;
		this.addSlotToContainer( new SlotPan(pan, 0, 80, 20) );
		
		for ( int y = 0; y < 3; y++ ) {
			for ( int x = 0; x < 9; x++ ) {
				this.addSlotToContainer( new Slot( player, x + (y * 9 + 9), 8 + x * 18, 84 + y * 18 ) );
			}
		}
		
		for ( int x = 0; x < 9; x++ ) {
			this.addSlotToContainer( new Slot( player, x, 8 + x * 18, 142) );
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
	// methods that have to be implemented for some reason
	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties( this, this.pan );
	}

}
