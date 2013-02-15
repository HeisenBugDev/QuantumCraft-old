
package thermalexpansion.api.core;

public interface IReconfigurableFacing {

    public int getFacing();

    public boolean rotateBlock();

    public boolean setFacing(int side);
}