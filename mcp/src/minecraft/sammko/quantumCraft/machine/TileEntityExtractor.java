
package sammko.quantumCraft.machine; //Comments are awsome ^^

import sammko.quantumCraft.items.ItemInitializator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityExtractor extends TileEntityMachine implements IInventory, ISidedInventory {

	//TODO: finish this
	
	public int fuel;
	public int itemFuel;
	public int progress;
	
	public TileEntityExtractor(World w, ForgeDirection rot) {
		super(w, rot, 5, "Extractor");
		fuel = 0;
		itemFuel = 0;
		progress = 0;
	}
	
	@SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.progress * par1 / 2;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
    	if (itemFuel == 0) {return par1;}
        return this.fuel * par1 / this.itemFuel;
    }

    public boolean isBurning()
    {
        return this.fuel > 0;
    }

    public void updateEntity()
    {
    	System.out.println("[QUANTUMCRAFT][TEE] MBT:" + fuel + " CIBT:" + itemFuel + " MCT:" + progress);
        boolean var1 = this.fuel > 0;
        boolean var2 = false;

        if (this.fuel > 0) //Fuel level goes down
        {
            --this.fuel;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.fuel == 0 && this.canSmelt()) //Use up a fuel item
            {
                this.itemFuel = this.fuel = getItemBurnTime(this.inventory[2]);

                if (this.fuel > 0) //If we got fuel get rid of the item
                {
                    var2 = true;

                    if (this.inventory[2] != null)
                    {
                        --this.inventory[2].stackSize;

                        if (this.inventory[2].stackSize == 0)
                        {
                            this.inventory[2] = this.inventory[2].getItem().getContainerItemStack(inventory[2]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt()) //Smelt stuff
            {
                ++this.progress;

                if (this.progress == 20)
                {
                    this.progress = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.progress = 0;
            }

            if (var1 != this.fuel > 0)
            {
                var2 = true;
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    /**
     * Returns true if the machine can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.inventory[0] == null)
        {
            return false;
        }
        if (this.inventory[1] == null)
        {
            return false;
        }
        else
        {
            if (inventory[1].itemID != ItemInitializator.ItemEmptyEnergyPacket.itemID) return false;
            if (inventory[0].itemID == ItemInitializator.ItemPositroniumCrystal.itemID ||
            	inventory[0].itemID == ItemInitializator.ItemRadiumCrystal.itemID ||
            	inventory[0].itemID == ItemInitializator.ItemGammatroniumCrystal.itemID ||
            	inventory[0].itemID == ItemInitializator.ItemNeutriniumCrystal.itemID) { return true; }
        	return false;
        }
    }

    public ItemStack getResult(ItemStack inp)
    {
    	if (inp.itemID == ItemInitializator.ItemPositroniumCrystal.itemID) { return new ItemStack(ItemInitializator.ItemPositroniumEnergyPacket,1); }
    	if (inp.itemID == ItemInitializator.ItemRadiumCrystal.itemID) { return new ItemStack(ItemInitializator.ItemRadiumEnergyPacket,1); }
    	if (inp.itemID == ItemInitializator.ItemGammatroniumCrystal.itemID) { return new ItemStack(ItemInitializator.ItemGammatroniumEnergyPacket,1); }
    	if (inp.itemID == ItemInitializator.ItemNeutriniumCrystal.itemID) { return new ItemStack(ItemInitializator.ItemNeutriniumEnergyPacket,1); }
    	return null;
    	
    }
    
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = this.getResult(this.inventory[0]);

            if (this.inventory[4] == null)
            {
                this.inventory[4] = var1.copy();
            }
            else if (this.inventory[4].isItemEqual(var1))
            {
            	inventory[4].stackSize += var1.stackSize;
            }
            if (this.inventory[3] == null)
            {
                this.inventory[3] = new ItemStack(ItemInitializator.ItemDepletedCrystal,1);
            }
            else if (this.inventory[3].isItemEqual(new ItemStack(ItemInitializator.ItemDepletedCrystal,1)))
            {
            	inventory[3].stackSize += var1.stackSize;
            }

            --this.inventory[0].stackSize;
            
            
            if (this.inventory[0].stackSize <= 0)
            {
                this.inventory[0] = null;
            }
            
            --this.inventory[1].stackSize;
            
            
            if (this.inventory[1].stackSize <= 0)
            {
                this.inventory[1] = null;
            }
        }
    }

    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            int var1 = par0ItemStack.getItem().itemID;
            Item var2 = par0ItemStack.getItem();

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[var1] != null)
            {
                Block var3 = Block.blocksList[var1];

                if (var3 == Block.woodSingleSlab)
                {
                    return 150;
                }

                if (var3.blockMaterial == Material.wood)
                {
                    return 300;
                }
            }

            /*if (var2 instanceof ItemTool && ((ItemTool) var2).getToolMaterialName().equals("WOOD")) return 200;
            if (var2 instanceof ItemSword && ((ItemSword) var2).func_77825_f().equals("WOOD")) return 200;
            if (var2 instanceof ItemHoe && ((ItemHoe) var2).func_77842_f().equals("WOOD")) return 200;*/ //Sorry, no wooden tools for you sir :(
            if (var1 == Item.stick.itemID) return 100;
            if (var1 == Item.coal.itemID) return 1600;
            if (var1 == Item.bucketLava.itemID) return 20000;
            if (var1 == Block.sapling.blockID) return 100;
            if (var1 == Item.blazeRod.itemID) return 2400;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }
    
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

}
