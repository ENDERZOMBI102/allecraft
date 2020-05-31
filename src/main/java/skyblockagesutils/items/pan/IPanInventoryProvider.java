package skyblockagesutils.items.pan;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

/**
 * Provides an interface for the capability which exposes the internal inventory of a backpack.
 * Acquire an instance of this using {@link net.minecraft.item.ItemStack#getCapability(Capability, EnumFacing)}.
 */
public interface IPanInventoryProvider {

    /**
     * Gets the inventory of the backpack given the variant.
     * Note: Modifying this Client Side is not advised
     *
     * @return The inventory representing this backpack, as an {@link IItemHandler}
     */
    @Nonnull
    IItemHandler getInventory();
}