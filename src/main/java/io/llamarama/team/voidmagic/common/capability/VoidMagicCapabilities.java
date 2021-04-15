package io.llamarama.team.voidmagic.common.capability;

import io.llamarama.team.voidmagic.common.capability.handler.IChaosHandler;
import io.llamarama.team.voidmagic.common.capability.impl.ChaosHandler;
import io.llamarama.team.voidmagic.common.capability.storage.ChaosStorage;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public final class VoidMagicCapabilities {

    @CapabilityInject(IChaosHandler.class)
    public static Capability<IChaosHandler> CHAOS = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IChaosHandler.class, new ChaosStorage(), () -> ChaosHandler.DEFAULT);
    }


}