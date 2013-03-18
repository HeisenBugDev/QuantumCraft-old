package mods.quantumCraft.resources;

public class BlockTextureMatrix {

	// texture layout in the file. 0x = Hex; 1st digit = Rows, 2nd digit =
	// Colums. 0 - F (0 - 15)
	public static TextureIndex OrePositronium = new TextureIndex(0x0E);
	public static TextureIndex OrePlutonium = new TextureIndex(0x0F);
	public static TextureIndex OreRadium = new TextureIndex(0x1E);
	public static TextureIndex OreGammatronium = new TextureIndex(0x1F);
	public static TextureIndex OreNeutrinium = new TextureIndex(0x2F);
	public static TextureIndex OreDepleted = new TextureIndex(0x2E);

	public static TextureIndex Err = new TextureIndex(0x41);

	public static TextureIndex[] Deco = { new TextureIndex(0x05),
			new TextureIndex(0x07), new TextureIndex(0x60),
			new TextureIndex(0x08), new TextureIndex(0x09),
			new TextureIndex(0x15), new TextureIndex(0x17),
			new TextureIndex(0x16), new TextureIndex(0x18),
			new TextureIndex(0x19), new TextureIndex(0x25),
			new TextureIndex(0x27), new TextureIndex(0x26),
			new TextureIndex(0x28), new TextureIndex(0x29),
			new TextureIndex(0x35) };

	public static TextureIndex[] MachineFront = { new TextureIndex(0x74),
			new TextureIndex(0x48), new TextureIndex(0x49),
			new TextureIndex(0x4A), new TextureIndex(0x57),
			new TextureIndex(0x58), new TextureIndex(0x59),
			new TextureIndex(0x5A), new TextureIndex(0x67),
			new TextureIndex(0x68), new TextureIndex(0x69),
			new TextureIndex(0x6A), new TextureIndex(0x77),
			new TextureIndex(0x78), new TextureIndex(0x79),
			new TextureIndex(0x7A) };

	public static TextureIndex[] MachineTop = { new TextureIndex(0x79),
			new TextureIndex(0x98), new TextureIndex(0x99),
			new TextureIndex(0x9A), new TextureIndex(0xA7),
			new TextureIndex(0xA8), new TextureIndex(0xA9),
			new TextureIndex(0xAA), new TextureIndex(0xB7),
			new TextureIndex(0xB8), new TextureIndex(0xB9),
			new TextureIndex(0xBA), new TextureIndex(0xC7),
			new TextureIndex(0xC8), new TextureIndex(0xC9),
			new TextureIndex(0xCA) };

	public static TextureIndex EBlockBackSingle = new TextureIndex(0x00);
	public static TextureIndex EBlockBackTop = new TextureIndex(0x10);
	public static TextureIndex EBlockBackMid = new TextureIndex(0x20);
	public static TextureIndex EBlockBackBot = new TextureIndex(0x30);
	public static TextureIndex EBlockSideSingle = new TextureIndex(0x40);
}
