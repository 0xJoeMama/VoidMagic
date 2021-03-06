package io.github.llamarama.team.voidmagic.common.register;

import io.github.llamarama.team.voidmagic.common.block.*;
import io.github.llamarama.team.voidmagic.common.block.util.ChalkType;
import io.github.llamarama.team.voidmagic.common.util.ModItemGroup;
import io.github.llamarama.team.voidmagic.common.util.misc.PropertiesSupplier;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class ModBlocks {

    // Properties
    private static final PropertiesSupplier WITHERED_STONE_PROPS = () -> {
        // Special for withered stone.
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .hardnessAndResistance(3.0f)
                .setRequiresTool();
    };
    private static final PropertiesSupplier TOFAL_PROPS = () -> {
        // Fancy.
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                .hardnessAndResistance(3.0f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .setLightLevel((state) -> 7)
                .setRequiresTool();
    };
    private static final PropertiesSupplier CHALK_PROPS = () -> {
        // Uses the ToIntFunction with the supplied light level.
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                .doesNotBlockMovement()
                .notSolid()
                .setLightLevel((state) -> {
                    ChalkType chalkType = state.get(ChalkBlock.TYPE);
                    return chalkType.getLightLevel();
                })
                .zeroHardnessAndResistance()
                .sound(SoundType.STONE);
    };
    private static final Function<AbstractBlock, AbstractBlock.Properties> COPY = AbstractBlock.Properties::from;

    // Actual Block Registry
    public static final RegistryObject<WitheredStoneBlock> WITHERED_STONE = register("withered_stone",
            () -> new WitheredStoneBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<WitheredStoneBlock> WITHERED_STONE_BRICKS = register("withered_stone_bricks",
            () -> new WitheredStoneBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<WitheredStoneBlock> CHISELED_WITHERED_STONE_BRICKS = register("chiseled_withered_stone_bricks",
            () -> new WitheredStoneBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<WitheredStoneBlock> CRACKED_WITHER_STONE_BRICKS = register("cracked_withered_stone_bricks",
            () -> new WitheredStoneBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<SlabBlock> WITHERED_STONE_SLAB = register("withered_stone_slab",
            () -> new SlabBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<SlabBlock> WITHERED_STONE_BRICK_SLAB = register("withered_stone_bricks_slab",
            () -> new SlabBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<StairsBlock> WITHERED_STONE_BRICK_STAIRS = register("withered_stone_brick_stairs",
            () -> new StairsBlock(WITHERED_STONE_BRICKS.get()::getDefaultState, WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<TofalBlock> TOFAL = register("tofal",
            () -> new TofalBlock(TOFAL_PROPS.get()));
    public static final RegistryObject<TofalBlock> TOFAL_BRICKS = register("tofal_bricks",
            () -> new TofalBlock(TOFAL_PROPS.get()));
    public static final RegistryObject<TofalBlock> TOFAL_TILES = register("tofal_tiles",
            () -> new TofalBlock(TOFAL_PROPS.get()));
    public static final RegistryObject<SlabBlock> TOFAL_BRICKS_SLAB = register("tofal_bricks_slab",
            () -> new SlabBlock(TOFAL_PROPS.get()));
    public static final RegistryObject<SlabBlock> TOFAL_TILES_SLAB = register("tofal_tiles_slab",
            () -> new SlabBlock(TOFAL_PROPS.get()));
    public static final RegistryObject<StairsBlock> TOFAL_BRICK_STAIRS = register("tofal_brick_stairs",
            () -> new StairsBlock(() -> TOFAL_BRICKS.get().getDefaultState(), TOFAL_PROPS.get()));
    public static final RegistryObject<Block> SHADOW_BRICKS = register("shadow_bricks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.STONE_BRICKS).setLightLevel((state) -> 2)));
    public static final RegistryObject<OreBlock> END_PUTILIAM_ORE = register("end_putiliam_ore",
            () -> new OreBlock(COPY.apply(Blocks.END_STONE)));
    public static final RegistryObject<OreBlock> OVERWORLD_PUTILIAM_ORE = register("overworld_putiliam_ore",
            () -> new OreBlock(COPY.apply(Blocks.IRON_ORE)));
    public static final RegistryObject<WitheredStoneBlock> POLISHED_WITHER_STONE_BRICKS = register("polished_withered_stone",
            () -> new WitheredStoneBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<PlateBlock> WITHERED_STONE_PLATE = register("withered_stone_plate",
            () -> new PlateBlock(POLISHED_WITHER_STONE_BRICKS.get(), WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<PlateBlock> TOFAL_PLATE = register("tofal_plate",
            () -> new PlateBlock(TOFAL.get(), TOFAL_PROPS.get()));
    public static final RegistryObject<OfferingPlateBlock> OFFERING_PLATE = register("offering_plate",
            () -> new OfferingPlateBlock(WITHERED_STONE_PROPS.get()));
    public static RegistryObject<PillarBlock> WITHERED_STONE_PILLAR = register("withered_stone_pillar",
            () -> new PillarBlock(WITHERED_STONE_PROPS.get()));
    public static final RegistryObject<ChalkBlock> CHALK = register("chalk",
            () -> new ChalkBlock(CHALK_PROPS.get()));
    public static final RegistryObject<Block> DECORATIVE_PACKED_BLOCK = register("decorative_packed_block",
            () -> new Block(COPY.apply(Blocks.WHITE_WOOL)));
    public static final RegistryObject<TestBlock> TEST_BLOCK = register("test_block",
            () -> new TestBlock(COPY.apply(Blocks.STONE)));

    private ModBlocks() {
    }

    @NotNull
    private static <B extends Block> RegistryObject<B> register(String id, Supplier<B> block) {
        RegistryObject<B> out = registerNoItem(id, block);
        ModRegistries.ITEMS.
                register(out.getId().getPath(),
                        () -> new BlockItem(out.get(),
                                new Item.Properties().group(ItemGroup.MISC).group(ModItemGroup.get())));
        return out;
    }

    @NotNull
    private static <B extends Block> RegistryObject<B> registerNoItem(String id, Supplier<B> block) {
        return ModRegistries.BLOCKS.register(id, block);
    }

    public static void init(IEventBus bus) {
        ModRegistries.BLOCKS.register(bus);
    }

}
