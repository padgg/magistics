package T145.magistics.client.lib;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * @author T145
 * 
 * A simple library designed to assist in normal chest rendering.
 */
public class ChestRenderHelper {
	/**
	 * Renders a chest using a given item renderer for inventory rendering
	 * 
	 * @param type
	 *            The ItemRenderType to use.
	 */
	public static void renderChest(ItemRenderType type) {
		switch (type) {
		case ENTITY:
			renderChest(0.5F, 0.5F, 0.5F);
			break;
		case EQUIPPED:
			renderChest(1F, 1F, 1F);
			break;
		case EQUIPPED_FIRST_PERSON:
			renderChest(1F, 1F, 1F);
			break;
		case INVENTORY:
			renderChest(0F, 0.075F, 0F);
			break;
		default:
			break;
		}
	}

	/**
	 * Renders a chest at the given coordinates in an inventory.
	 * 
	 * @param x
	 *            X coordinate
	 * @param y
	 *            Y coordinate
	 * @param z
	 *            Z coordinate
	 */
	public static void renderChest(float x, float y, float z) {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(-90, 0, 1, 0);
		new ModelChest().renderAll();
		GL11.glPopMatrix();
	}

	/**
	 * Renders a chest normally in an inventory.
	 */
	public static void renderChest() {
		renderChest(0.5F, 0.5F, 0.5F);
	}

	/**
	 * Renders a chest's tile entity.
	 * 
	 * @param tile
	 *            The tile entity of the chest to render.
	 */
	public static void renderChest(TileEntity tile) {
		GL11.glRotatef(90F, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		TileEntityRendererDispatcher.instance.renderTileEntityAt(tile, 0, 0, 0, 0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	}
}