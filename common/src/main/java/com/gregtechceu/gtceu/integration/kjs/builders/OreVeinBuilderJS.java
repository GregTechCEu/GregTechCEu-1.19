package com.gregtechceu.gtceu.integration.kjs.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.worldgen.BiomeWeightModifier;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreFeatureEntry;
import com.gregtechceu.gtceu.api.data.worldgen.IWorldGenLayer;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;

@SuppressWarnings("unused")
public class OreVeinBuilderJS {
    private final ResourceLocation id;
    @Setter
    public transient int clusterSize, weight;
    @Setter
    public transient float density, discardChanceOnAirExposure;
    @Setter
    public transient IWorldGenLayer layer;
    @Setter
    public transient HeightRangePlacement heightRange;
    @Setter
    public transient BiomeWeightModifier biomeWeightModifier;
    @Setter
    public GTOreFeatureEntry.VeinGenerator generator;

    private final transient JsonArray dimensionFilter = new JsonArray();
    private final transient JsonArray biomeFilter = new JsonArray();

    public OreVeinBuilderJS(ResourceLocation id) {
        this.id = id;
    }

    public OreVeinBuilderJS addSpawnDimension(String dimension) {
        dimensionFilter.add(dimension);
        return this;
    }

    public OreVeinBuilderJS addSpawnBiome(String biome) {
        biomeFilter.add(biome);
        return this;
    }

    public GTOreFeatureEntry build() {
        RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.BUILTIN.get());
        HolderSet<DimensionType> dimensions = RegistryCodecs.homogeneousList(Registry.DIMENSION_TYPE_REGISTRY)
            .decode(registryOps, dimensionFilter.size() == 1 ? dimensionFilter.get(0) : dimensionFilter).map(Pair::getFirst).getOrThrow(false, GTCEu.LOGGER::error);
        HolderSet<Biome> biomes = RegistryCodecs.homogeneousList(Registry.BIOME_REGISTRY)
                .decode(registryOps, biomeFilter.size() == 1 ? biomeFilter.get(0) : biomeFilter).map(Pair::getFirst).getOrThrow(false, GTCEu.LOGGER::error);
        return new GTOreFeatureEntry(id, clusterSize, density, weight, layer, dimensions, heightRange, discardChanceOnAirExposure, biomes, biomeWeightModifier, generator);
    }

}
