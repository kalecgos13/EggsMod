package com.kalec.ItemGroups;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;

public class EggsItemGroup extends ItemGroup {

    public EggsItemGroup(String label){
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.EGG);
    }
    @Override
    public void fill(NonNullList<ItemStack> itemsToShow) {
        for(Item item: ForgeRegistries.ITEMS) {
            if(item != null) {
                if (item.getRegistryName().getNamespace().equals("eggs")) {
                    item.fillItemGroup(ItemGroup.SEARCH, itemsToShow);
                }
            }
        }
    }
}
