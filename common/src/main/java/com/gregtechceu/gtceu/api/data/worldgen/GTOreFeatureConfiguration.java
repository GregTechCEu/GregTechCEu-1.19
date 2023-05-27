package com.gregtechceu.gtceu.api.data.worldgen;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;
import java.util.Optional;

/**
 * @author KilaBash
 * @date 2023/3/20
 * @implNote GTOreFeatureConfiguration
 */
public class GTOreFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<GTOreFeatureConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.either(GTOreFeatureEntry.CODEC, GTOreFeatureEntry.DIRECT_CODEC)
                    .xmap(either -> either.map(entry -> entry, entry -> entry), Either::left)
                    .optionalFieldOf("entry")
                    .forGetter(config -> Optional.ofNullable(config.entry))
        ).apply(instance, (optional) -> new GTOreFeatureConfiguration(optional.orElse(null)))
    );

    @Setter
    private GTOreFeatureEntry entry;
    @Getter
    private final boolean isSpawn;


    public GTOreFeatureConfiguration() {
        this.entry = null;
        this.isSpawn = false;
    }

    public GTOreFeatureConfiguration(GTOreFeatureEntry entry) {
        this.entry = entry;
        this.isSpawn = true;
    }

    public GTOreFeatureEntry getEntry(RandomSource random) {
        if (this.entry != null) return this.entry;
        GTOreFeatureEntry[] values = GTOreFeatureEntry.ALL.values().toArray(GTOreFeatureEntry[]::new);
        return values[random.nextInt(values.length)];
    }

}
