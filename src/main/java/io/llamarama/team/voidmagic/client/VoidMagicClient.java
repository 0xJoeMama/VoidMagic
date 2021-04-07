package io.llamarama.team.voidmagic.client;

import io.llamarama.team.voidmagic.VoidMagic;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class VoidMagicClient {

    private static final Minecraft game = Minecraft.getInstance();

    public VoidMagicClient() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        VoidMagic.getLogger().info("Loaded client side of VoidMagic");
    }

    public static Minecraft getGame() {
        return game;
    }

}
