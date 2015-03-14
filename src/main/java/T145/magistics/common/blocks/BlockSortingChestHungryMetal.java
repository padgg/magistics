package T145.magistics.common.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import vazkii.botania.api.wand.IWandable;
import T145.magistics.client.lib.TextureHelper;
import T145.magistics.common.lib.InventoryHelper;
import T145.magistics.common.tiles.TileSortingChestHungryMetal;

import com.dynious.refinedrelocation.block.BlockSortingIronChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.ironchest.IronChestType;

public class BlockSortingChestHungryMetal extends BlockSortingIronChest implements IWandable {
	public static IIcon icon[] = new IIcon[IronChestType.values().length];

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister r) {
		for (IronChestType type : IronChestType.values())
			if (type != type.WOOD)
				icon[type.ordinal()] = r.registerIcon("magistics:chest_hungry/" + TextureHelper.getSimpleIronChestName(type));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon[meta];
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileSortingChestHungryMetal(IronChestType.values()[meta]);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
		InventoryHelper.absorbCollidingItemStackIntoInventory(entity, (TileSortingChestHungryMetal) world.getTileEntity(i, j, k), this, 2, 2, world, i, j, k, true);
	}

	@Override
	public boolean onUsedByWand(EntityPlayer player, ItemStack wand, World world, int i, int j, int k, int side) {
		TileSortingChestHungryMetal tile = (TileSortingChestHungryMetal) world.getTileEntity(i, j, k);
		return tile.onWanded(player, side);
	}
}