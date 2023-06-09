package com.gregtechceu.gtceu.integration.kjs.builders.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTCreateMachines;
import com.gregtechceu.gtceu.common.data.GTMachines;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

/**
 * @author Screret
 * @date 2023/4/01
 * @implNote MachineBuilder
 */
public class KineticMachineBuilder extends MachineBuilder {
    public transient int[] tiers;

    public KineticMachineBuilder(ResourceLocation i, Object... args) {
        super(i);
        this.tiers = GTMachines.ELECTRIC_TIERS;
    }

    public KineticMachineBuilder tiers(int... tiers) {
        this.tiers = tiers;
        return this;
    }

    @Override
    public MachineDefinition register() {
        value = GTCreateMachines.registerSimpleKineticElectricMachine(name, recipeType, tiers)[0];
        return value;
    }
}
