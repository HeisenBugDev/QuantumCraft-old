package sammko.quantumCraft.machine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class TileEntityMachine extends TileEntity {

	public int mtype = 0;
	public int rotation = 0;
	public int[] tMap = new int[6];
	
	public TileEntityMachine(World w,int rot) {
		mtype = w.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord); // set machines type from metadata
		rotation = rot; // the rotation is stored in TE variable.
		
	}
	
	

}
