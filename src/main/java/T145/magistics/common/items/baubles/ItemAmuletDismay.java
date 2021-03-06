package T145.magistics.common.items.baubles;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import T145.magistics.api.items.baubles.ItemBauble;
import baubles.api.BaubleType;

public class ItemAmuletDismay extends ItemBauble {
	@Override
	public BaubleType getBaubleType(ItemStack is) {
		return BaubleType.AMULET;
	}

	@Override
	public void onWornTick(ItemStack is, EntityLivingBase user) {
		Random rand = new Random();
		List mobs = user.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox(user.posX - 8D, user.posY - 3D, user.posZ - 8D, user.posX + 8D, user.posY + 3D, user.posZ + 8D));

		for (int mob = 0; mob < mobs.size(); mob++) {
			EntityLiving beast = (EntityLiving) mobs.get(mob);

			if (beast.isEntityUndead() && beast.getAttackTarget() instanceof EntityPlayer && rand.nextInt(20) == 0) {
				beast.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 40, 0, true));
				break;
			}
		}
	}
}