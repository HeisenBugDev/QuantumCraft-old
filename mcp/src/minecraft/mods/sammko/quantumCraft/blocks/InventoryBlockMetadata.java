package mods.sammko.quantumCraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public abstract class InventoryBlockMetadata extends BlockContainer {
	protected InventoryBlockMetadata(int id, Material material) {
		super(id, material);
	}

	/* Textures */
	public Icon[] icons;
	
	public abstract String[] getTextureNames();
	
	public void func_94332_a(IconRegister iconRegister) {
		
		String[] textureNames = getTextureNames();
		// System.out.println("TextureNames: :"+this.getClass().getSimpleName());
		this.icons = new Icon[textureNames.length];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = iconRegister.func_94245_a("quantumcraft:"
					+ textureNames[i]);
		}
	}
}
