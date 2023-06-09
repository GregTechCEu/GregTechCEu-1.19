/*
package com.gregtechceu.gtceu.integration.kjs.registrywrapper;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.registry.GTRegistry;
import com.gregtechceu.gtceu.core.mixins.IHolderReferenceAccessor;
import com.gregtechceu.gtceu.core.mixins.IMappedRegistryAccessor;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GTStringRegistryWrapper<T> extends MappedRegistry<T> {
    private final GTRegistry.String<T> registry;
    private final ResourceKey<? extends Registry<T>> key;

    public GTStringRegistryWrapper(ResourceKey<? extends Registry<T>> key, Lifecycle lifecycle, GTRegistry.String<T> registry) {
        super(key, lifecycle, null);
        this.registry = registry;
        this.key = key;
        IMappedRegistryAccessor<T> accessor = (IMappedRegistryAccessor<T>) this;
        accessor.setNextId(registry.keys().size());

        var byId = registry.entries().stream().map(val -> {
            var id = ResourceKey.create(key, new ResourceLocation(GTCEu.MOD_ID, val.getKey().toLowerCase(Locale.ROOT)));
            var value = Holder.Reference.createStandAlone(GTStringRegistryWrapper.this, id);
            ((IHolderReferenceAccessor<T>)value).invokeBind(id, val.getValue());
            return value;
        }).toList();
        accessor.getById().addAll(byId);

        var byKey = registry.entries().stream().map(val -> {
            var id = ResourceKey.create(key, new ResourceLocation(GTCEu.MOD_ID, val.getKey().toLowerCase(Locale.ROOT)));
            var value = Holder.Reference.createStandAlone(GTStringRegistryWrapper.this, id);
            ((IHolderReferenceAccessor<T>)value).invokeBind(id, val.getValue());
            return Map.entry(id, value);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        accessor.getByKey().putAll(byKey);

        var byLocation = registry.entries().stream().map(val -> {
            var id = ResourceKey.create(key, new ResourceLocation(GTCEu.MOD_ID, val.getKey().toLowerCase(Locale.ROOT)));
            var value = Holder.Reference.createStandAlone(GTStringRegistryWrapper.this, id);
            return Map.entry(id.location(), value);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        accessor.getByLocation().putAll(byLocation);

        AtomicInteger index = new AtomicInteger(0);
        var toId = registry.values().stream().map(val -> Map.entry(val, index.getAndIncrement())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        accessor.getToId().putAll(toId);

        var byValue = registry.entries().stream().map(val -> {
            var id = ResourceKey.create(key, new ResourceLocation(GTCEu.MOD_ID, val.getKey().toLowerCase(Locale.ROOT)));
            var value = Holder.Reference.createStandAlone(GTStringRegistryWrapper.this, id);
            ((IHolderReferenceAccessor<T>)value).invokeBind(id, val.getValue());
            return Map.entry(val.getValue(), value);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        accessor.getByValue().putAll(byValue);
    }

    @Override
    public Holder<T> registerMapping(int id, ResourceKey<T> key, T value, Lifecycle lifecycle) {
        //registry.register(key.location().getPath(), value);
        return super.registerMapping(id, key, value, lifecycle);
    }

    @Nullable
    @Override
    public ResourceLocation getKey(T value) {
        return new ResourceLocation(GTCEu.MOD_ID, registry.getKey(value));
    }

    @Nullable
    @Override
    public T get(@Nullable ResourceLocation name) {
        return this.registry.get(name.getPath());
    }

    @Override
    public Optional<Holder<T>> getHolder(ResourceKey<T> key) {
        ResourceKey<T> keyReal = ResourceKey.create(this.key, key.location());
        var ref = Holder.Reference.createStandAlone(this, keyReal);
        ((IHolderReferenceAccessor<T>)ref).invokeBind(keyReal, registry.get(key.location().getPath()));
        return Optional.of(ref);
    }

    @Nullable
    @Override
    public T get(@Nullable ResourceKey<T> key) {
        return this.registry.get(key.location().getPath());
    }

    @Override
    public Optional<ResourceKey<T>> getResourceKey(T value) {
        return Optional.of(ResourceKey.create(this.key.location(), new ResourceLocation(GTCEu.MOD_ID, this.registry.getKey(value))));
    }

    @Override
    public Optional<T> getOptional(@Nullable ResourceLocation name) {
        return Optional.ofNullable(this.registry.get(name.getPath()));
    }

    @Override
    public Optional<T> getOptional(@Nullable ResourceKey<T> registryKey) {
        return Optional.ofNullable(this.registry.get(registryKey.location().getPath()));
    }


    @Override
    public Set<ResourceLocation> keySet() {
        return this.registry.keys().stream().map(val -> new ResourceLocation(GTCEu.MOD_ID, val)).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean containsKey(ResourceLocation name) {
        return registry.containKey(name.getPath());
    }

    @Override
    public Registry<T> freeze() {
        registry.freeze();
        return super.freeze();
    }

    @Override
    public Iterator<T> iterator() {
        return this.registry.iterator();
    }

}
*/