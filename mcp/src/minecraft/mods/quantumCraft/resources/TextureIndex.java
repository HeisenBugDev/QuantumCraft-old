package mods.quantumCraft.resources;

public class TextureIndex {

	private int hex;

	public int getHEX() {
		return this.hex;
	}

	public String getString()
	{
		
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toHexString(hex));
		if (sb.length() < 2) {
		    sb.insert(0, '0'); // pad with leading zero if needed
		}
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		sb.setCharAt(1, Character.toUpperCase(sb.charAt(1)));
		
		String s = "quantumcraft:0x" + sb.toString();

		System.out.println("someone requsted texture string: " + s);
		return s;
	}
	
	public int getINT() {
		return ((this.hex >> 4) & 15) | ((this.hex << 4) & 240);
	}

	public TextureIndex(int hexindex) {
		this.hex = hexindex;
	}

}
