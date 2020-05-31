package skyblockagesutils.items.pan;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.IItemHandler;

public class ItemPanHandler implements ICapabilityProvider, IPanInventoryProvider {
	
	private ItemStack pan;
	
	public ItemPanHandler(ItemStack stack) {
		this.pan = stack;
	}
	
	@Nonnull
    @Override
    public IItemHandler getInventory() {
        return BackpackInfo.fromStack(backpack).getInventory();
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == IronBackpacksInventoryHelper.BACKPACK_INV_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == IronBackpacksInventoryHelper.BACKPACK_INV_CAPABILITY ? (T) this : null;
    }

    public static class Default extends ItemBackpackHandler {
        public Default() {
            super(ItemStack.EMPTY);
        }
    }

}
