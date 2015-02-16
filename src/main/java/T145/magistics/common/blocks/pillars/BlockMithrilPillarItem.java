package T145.magistics.common.blocks.pillars;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockMithrilPillarItem extends ItemBlock {
	public BlockMithrilPillarItem(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack is) {
		String name;
		switch (is.getItemDamage()) {
		case 0:
			name = "quartz";
			break;
		case 1:
			name = "base";
			break;
		default:
			name = "broken";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}
}