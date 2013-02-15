
package thermalexpansion.api.core;

import buildcraft.api.power.IPowerProvider;

public interface IPowerProviderAdv extends IPowerProvider {

    public void addEnergy(float quantity);

    public void subtractEnergy(float quantity);

    public void setEnergyStored(float quantity);

    public void roundEnergyStored();
}