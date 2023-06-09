package com.gregtechceu.gtceu.api.data.worldgen;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.addon.AddonFinder;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.data.worldgen.generator.WorldGeneratorUtils;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

public class VeinGenerators {
    public static Codec<GTOreFeatureEntry.NoopVeinGenerator> NO_OP = register(GTCEu.id("no_op"), GTOreFeatureEntry.NoopVeinGenerator.CODEC);
    public static Codec<GTOreFeatureEntry.StandardVeinGenerator> STANDARD = register(GTCEu.id("standard"), GTOreFeatureEntry.StandardVeinGenerator.CODEC);
    public static Codec<GTOreFeatureEntry.LayeredVeinGenerator> LAYER = register(GTCEu.id("layer"), GTOreFeatureEntry.LayeredVeinGenerator.CODEC);

    public static <T extends GTOreFeatureEntry.VeinGenerator> Codec<T> register(ResourceLocation id, Codec<T> codec) {
        WorldGeneratorUtils.VEIN_GENERATORS.put(id, codec);
        return codec;
    }

    public static void registerAddonGenerators() {
        AddonFinder.getAddons().forEach(IGTAddon::registerVeinGenerators);
    }
}
