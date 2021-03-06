package T145.magistics.client.lib;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ChestRenderer implements ISimpleBlockRenderingHandler {
	public int id = 0;
	public ResourceLocation textures[];
	public TileEntity chest;

	public ChestRenderer(int renderID, ResourceLocation[] resources) {
		id = renderID;
		textures = resources;
	}

	public ChestRenderer(int renderID, TileEntity tile) {
		id = renderID;
		chest = tile;
	}

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelId, RenderBlocks renderer) {
		if (chest == null) {
			if (textures.length > 1)
				Minecraft.getMinecraft().getTextureManager().bindTexture(textures[meta]);
			else
				Minecraft.getMinecraft().getTextureManager().bindTexture(textures[0]);

			ChestRenderHelper.renderChest();
		} else
			ChestRenderHelper.renderChest(chest);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return id;
	}
}