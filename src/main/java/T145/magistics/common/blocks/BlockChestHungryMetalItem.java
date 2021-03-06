package T145.magistics.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import T145.magistics.client.renderers.TileChestHungryMetalRenderer;
import cpw.mods.ironchest.IronChestType;

public class BlockChestHungryMetalItem extends ItemBlock {
	public BlockChestHungryMetalItem(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack is) {
		return super.getUnlocalizedName() + "." + TileChestHungryMetalRenderer.getSimpleChestName(IronChestType.values()[is.getItemDamage()]);
	}
}