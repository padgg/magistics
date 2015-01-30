package T145.magistics.common.tiles;

import mods.railcraft.common.blocks.machine.beta.TileChestMetals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.wands.IWandable;

public class TileChestHungryMetals extends TileChestMetals implements IWandable {
	@Override
	public boolean receiveClientEvent(int id, int data) {
		switch (id) {
		case 2:
			if (lidAngle < data / 10F)
				lidAngle = data / 10F;
			return true;
		default:
			return false;
		}
	}

	public boolean onWanded(EntityPlayer player, int side) {
		if (player.isSneaking() && numUsingPlayers == 0) {
			rotateBlock(ForgeDirection.getOrientation(side));
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			player.worldObj.playSound(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, "thaumcraft:tool", 0.3F, 1.9F + player.worldObj.rand.nextFloat() * 0.2F, false);
			player.swingItem();
			markDirty();
			return true;
		} else
			return false;
	}

	@Override
	public int onWandRightClick(World world, ItemStack wand, EntityPlayer player, int i, int j, int k, int side, int meta) {
		onWanded(player, side);
		return 0;
	}

	@Override
	public ItemStack onWandRightClick(World world, ItemStack wand, EntityPlayer player) {
		return null;
	}

	@Override
	public void onUsingWandTick(ItemStack wand, EntityPlayer player, int count) {}

	@Override
	public void onWandStoppedUsing(ItemStack wand, World world, EntityPlayer player, int count) {}
}