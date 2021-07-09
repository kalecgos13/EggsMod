package com.kalec.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class StartupClient {

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(StartupCommon.explosiveEggEntity, entity -> new SpriteRenderer<>(entity, Minecraft.getInstance().getItemRenderer()));
    }
}
