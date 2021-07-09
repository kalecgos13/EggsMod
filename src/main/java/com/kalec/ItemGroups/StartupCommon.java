package com.kalec.ItemGroups;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartupCommon {

    public static EggsItemGroup eggsItemGroup;
    public static BlockItem tempBlockItem;
    public static Item tempItem;

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> ItemRegisterEvent) {
        eggsItemGroup = new EggsItemGroup("eggs_item_group");
    }
}
