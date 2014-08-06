package T145.magistics.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import T145.magistics.common.blocks.BlockFragileApparatus.Types;

public class BlockFragileApparatusItem extends BlockApparatusItem {
	public BlockFragileApparatusItem(Block b) {
		super(b);
	}

	@Override
	public String getUnlocalizedName(ItemStack is) {
		return getUnlocalizedName() + "." + Types.values()[is.getItemDamage()];
	}
}