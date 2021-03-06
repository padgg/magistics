package T145.magistics.client.renderers;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import T145.magistics.common.tiles.TileChestHungryEnder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileChestHungryEnderRenderer extends TileEntitySpecialRenderer {
	private final ModelChest model = new ModelChest();

	@Override
	public void renderTileEntityAt(TileEntity tile, double i, double j, double k, float tick) {
		if (tile instanceof TileChestHungryEnder) {
			TileChestHungryEnder chest = (TileChestHungryEnder) tile;
			bindTexture(new ResourceLocation("magistics", "textures/models/chest_hungry/ender.png"));
			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glColor4f(1F, 1F, 1F, 1F);
			GL11.glTranslatef((float) i, (float) j + 1F, (float) k + 1F);
			GL11.glScalef(1F, -1F, -1F);
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			
			if (chest.hasWorldObj())
				switch (chest.getBlockMetadata()) {
				case 2:
					GL11.glRotatef(180, 0F, 1F, 0F);
					break;
				case 4:
					GL11.glRotatef(90, 0F, 1F, 0F);
					break;
				case 5:
					GL11.glRotatef(-90, 0F, 1F, 0F);
					break;
				}
			
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			float lidOpening = chest.prevLidAngle + (chest.lidAngle - chest.prevLidAngle) * tick;
			lidOpening = 1F - lidOpening;
			lidOpening = 1F - lidOpening * lidOpening * lidOpening;
			model.chestLid.rotateAngleX = -(lidOpening * (float) Math.PI / 2F);
			model.renderAll();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
	}
}