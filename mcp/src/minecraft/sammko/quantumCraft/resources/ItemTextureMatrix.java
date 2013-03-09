package sammko.quantumCraft.resources;

public class ItemTextureMatrix {

	//same as block texture matrix
	
	public static TextureIndex PlutoniumIngot = new TextureIndex(0x00);
	
	public static TextureIndex PositroniumCrystal = new TextureIndex(0x10);
	public static TextureIndex RadiumCrystal = new TextureIndex(0x20);
	public static TextureIndex NeutriniumCrystal = new TextureIndex(0x30);
	public static TextureIndex GammatroniumCrystal = new TextureIndex(0x40);
	public static TextureIndex DepletedCrystal = new TextureIndex(0x50);
	
	public static TextureIndex EmptyEPacket = new TextureIndex(0x01);
	public static TextureIndex PositroniumEPacket = new TextureIndex(0x11);
	public static TextureIndex RadiumEPacket = new TextureIndex(0x21);
	public static TextureIndex NeutriniumEPacket = new TextureIndex(0x31);
	public static TextureIndex GammatroniumEPacket = new TextureIndex(0x41);

	public static TextureIndex DCrystalShard = new TextureIndex(0x51);
	
	public static TextureIndex CPickaxe = new TextureIndex(0x02);
	public static TextureIndex CSword = new TextureIndex(0x12);
	public static TextureIndex CAxe = new TextureIndex(0x22);
	public static TextureIndex CShovel = new TextureIndex(0x32);
	
	public static TextureIndex GammPickaxe = new TextureIndex(0x03);
	public static TextureIndex GammSword = new TextureIndex(0x13);
	public static TextureIndex GammAxe = new TextureIndex(0x23);
	public static TextureIndex GammShovel = new TextureIndex(0x33);
	
	public static TextureIndex RadioactiveMeat = new TextureIndex(0x04);
	
	public static int getIndex(int v)
	{
		return ((v >> 4) & 15) | ((v << 4) & 240);
	
	}
}
