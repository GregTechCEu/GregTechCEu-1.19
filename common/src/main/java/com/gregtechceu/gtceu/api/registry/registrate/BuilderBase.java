package com.gregtechceu.gtceu.api.registry.registrate;

import dev.latvian.mods.rhino.util.HideFromJS;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public abstract class BuilderBase<T> implements Supplier<T> {

    public ResourceLocation id;
    protected T value = null;

    public BuilderBase(ResourceLocation id, Object... args) {
        this.id = id;
    }

    @HideFromJS
    public abstract T register();

    @Override
    public T get() {
        return value;
    }
}
