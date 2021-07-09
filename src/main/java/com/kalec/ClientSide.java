package com.kalec;

import net.minecraftforge.eventbus.api.IEventBus;

public class ClientSide {
    private final IEventBus eventBus;

    public ClientSide(IEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void registerClientOnlyEvents() {
        eventBus.register(com.kalec.entity.StartupClient.class);
    }
}
