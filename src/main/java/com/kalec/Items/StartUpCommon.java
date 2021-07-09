package com.kalec.Items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartUpCommon {
    public static OmeletItem omeletItem;
    public static ExplosiveEggItem explosiveEggItem;

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegistryEvent) {
        omeletItem = new OmeletItem();
        omeletItem.setRegistryName("omelet");
        itemRegistryEvent.getRegistry().register(omeletItem);

        explosiveEggItem = new ExplosiveEggItem();
        explosiveEggItem.setRegistryName("explosive_egg");
        itemRegistryEvent.getRegistry().register(explosiveEggItem);
    }
}
