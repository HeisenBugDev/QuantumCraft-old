package sammko.quantumCraft.machine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;


public class TileEntityMachine extends TileEntity {

	public int mtype = 0;
	public ForgeDirection rotation;
	public int[] tMap = new int[6];
	
	public TileEntityMachine(World w, ForgeDirection rot) {
		mtype = w.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord); // set machines type from metadata
		rotation = rot; // the rotation is stored in TE variable.
		
	}
	
	

}
