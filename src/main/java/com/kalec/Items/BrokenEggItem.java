package com.kalec.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BrokenEggItem extends Item {
    public BrokenEggItem() {
        super((new Item.Properties()).maxStackSize(16).group(ItemGroup.MISC));
    }
}
