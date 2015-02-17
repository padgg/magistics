package T145.magistics.common.items.baubles;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class MithrilWitherRing extends MithrilRing {
	Random random = new Random();

	@Override
	public void onWornTick(ItemStack is, EntityLivingBase player) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
			return;
		if (random.nextInt(60) == 2)
			for (int i = 0; i < player.worldObj.loadedEntityList.size(); i++) {
				Entity entity = (Entity) player.worldObj.loadedEntityList.get(i);
				if ((entity instanceof EntityMob || entity instanceof EntityLiving) && entity.getDistanceSqToEntity((Entity) player) < 256.0 && random.nextInt(3) != 0) {
					System.out.println("[Mithril mod] Entity withered: " + entity.getCommandSenderName());
					((EntityLiving) entity).addPotionEffect(new PotionEffect(Potion.wither.getId(), 200, 1));
					break;
				}
			}
	}

	@Override
	public EnumRarity getRarity(ItemStack is) {
		return EnumRarity.epic;
	}
}