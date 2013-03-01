package sammko.quantumCraft.resources;

public class ItemTextureMatrix {

	//same as block texture matrix
	
	public static int PlutoniumIngot = 0x00;
	
	public static int PositroniumCrystal = 0x10;
	public static int RadiumCrystal = 0x20;
	public static int NeutriniumCrystal = 0x30;
	public static int GammatroniumCrystal = 0x40;
	public static int DepletedCrystal = 0x50;
	
	public static int EmptyEPacket = 0x01;
	public static int PositroniumEPacket = 0x11;
	public static int RadiumEPacket = 0x21;
	public static int NeutriniumEPacket = 0x31;
	public static int GammatroniumEPacket = 0x41;
	
	public static int DCrystalShard = 0x51;
	
	public static int CPickaxe = 0x02;
	public static int CSword = 0x12;
	public static int CAxe = 0x22;
	public static int CShovel = 0x32;
	
	public static int GammPickaxe = 0x03;
	public static int GammSword = 0x13;
	public static int GammAxe = 0x23;
	public static int GammShovel = 0x33;
	
	public static int RadioactiveMeat = 0x04;
	
	public static int getIndex(int v)
	{
		return ((v >> 4) & 15) | ((v << 4) & 240);
	
	}
}
