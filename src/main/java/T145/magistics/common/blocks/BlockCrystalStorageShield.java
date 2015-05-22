package T145.magistics.common.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrystalStorageShield extends BlockCrystalStorage {
	public static int renderID = RenderingRegistry.getNextAvailableRenderId();
	public static IIcon icon;

	public BlockCrystalStorageShield() {
		setBlockName("crystal_storage:shield");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister r) {
		super.registerBlockIcons(r);
		icon = r.registerIcon("magistics:decor/shield");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon;
	}

	@Override
	public int getRenderType() {
		return renderID;
	}
}