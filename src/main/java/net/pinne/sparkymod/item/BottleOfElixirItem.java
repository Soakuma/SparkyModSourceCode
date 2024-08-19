
package net.pinne.sparkymod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BottleOfElixirItem extends Item {
	public BottleOfElixirItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
