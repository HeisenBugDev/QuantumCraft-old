
package thermalexpansion.api.core;

public interface IReconfigurableSides {

    public boolean decrSide(int side);

    public boolean incrSide(int side);

    public int getNumSides();
}