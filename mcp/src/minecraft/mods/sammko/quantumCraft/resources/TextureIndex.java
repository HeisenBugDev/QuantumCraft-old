package mods.sammko.quantumCraft.resources;

public class TextureIndex {

	private int hex;

	public int getHEX() {
		return this.hex;
	}

	public int getINT() {
		return ((this.hex >> 4) & 15) | ((this.hex << 4) & 240);
	}

	public TextureIndex(int hexindex) {
		this.hex = hexindex;
	}

	public TextureIndex(int x, int y) {
		this.hex = (x << 1 | y);
	}

}
