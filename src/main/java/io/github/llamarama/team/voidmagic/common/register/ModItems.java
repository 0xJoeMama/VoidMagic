package io.github.llamarama.team.voidmagic.common.register;

import io.github.llamarama.team.voidmagic.common.item.GuideBookItem;
import io.github.llamarama.team.voidmagic.util.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class ModItems {

    public static final RegistryObject<Item> PUTILIAM = register("putiliam",
            () -> new Item(getDefaultProperties()));
    public static final RegistryObject<GuideBookItem> GUIDE_BOOK = register("guide_book",
            () -> new GuideBookItem(getUnstackableProperties()));

    private static <I extends Item> RegistryObject<I> register(String id, Supplier<I> item) {
        return ModRegistries.ITEMS.register(id, item);
    }

    static void init(IEventBus bus) {
        ModRegistries.ITEMS.register(bus);
    }

    private static Item.Properties getDefaultProperties() {
        return new Item.Properties().group(ModItemGroup.get());
    }

    private static Item.Properties getUnstackableProperties() {
        return getDefaultProperties().maxStackSize(1);
    }

}