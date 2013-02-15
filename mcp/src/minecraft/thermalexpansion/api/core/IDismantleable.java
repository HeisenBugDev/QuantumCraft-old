
package thermalexpansion.api.core;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IDismantleable {

    public ItemStack dismantleBlock(World world, int x, int y, int z, boolean returnBlock);

    public boolean canDismantle(World world, int x, int y, int z);
}