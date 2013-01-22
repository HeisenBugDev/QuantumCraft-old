package sammko.quantumCraft.machine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class TileEntityMachine extends TileEntity {

	public int mtype = 0;
	public int rotation = 0;
	
	public TileEntityMachine(World w,int rot) {
		this.mtype = w.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		rotation = rot;
		
	}
	
	

}