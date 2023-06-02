package com.gregtechceu.gtceu.api.data.worldgen;

import com.gregtechceu.gtceu.GTCEu;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

public class VeinGenerators {
    public static Codec<GTOreFeatureEntry.StandardVeinGenerator> STANDARD = register(GTCEu.id("standard"), GTOreFeatureEntry.StandardVeinGenerator.CODEC);
    public static Codec<GTOreFeatureEntry.LayeredVeinGenerator> LAYER = register(GTCEu.id("layer"), GTOreFeatureEntry.LayeredVeinGenerator.CODEC);

    public static <T extends GTOreFeatureEntry.VeinGenerator> Codec<T> register(ResourceLocation id, Codec<T> codec) {
        GTOreFeatureEntry.VeinGenerator.DATAGEN_EXTENSIONS.put(id, codec);
        return codec;
    }
}
