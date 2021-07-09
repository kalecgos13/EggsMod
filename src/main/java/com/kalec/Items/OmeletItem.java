package com.kalec.Items;

import com.kalec.handler.ConfigHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
public class OmeletItem extends Item {
    public OmeletItem() {
        super(new Item.Properties().food(new Food.Builder().hunger(
                6)
                .saturation(0.5f)
                .build())
                .group(ItemGroup.FOOD));
    }
}
