
package thermalexpansion.api.core;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerProviderLoss extends IPowerProviderAdv {

    public void addEnergyWithoutLoss(float quantity);

    public void receiveEnergyWithoutLoss(float quantity, ForgeDirection from);
}