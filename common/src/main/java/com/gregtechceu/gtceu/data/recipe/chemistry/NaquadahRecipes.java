package com.gregtechceu.gtceu.data.recipe.chemistry;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.api.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class NaquadahRecipes {

    // Rough ratio of Naquadah Dust breakdown from this process:
    //
    // 6 NAQUADAH DUST:
    // |> 1 Enriched Naquadah
    // |> 1 Naquadria
    // |> 1 Titanium
    // |> 1 Sulfur
    // |> 0.5 Indium
    // |> 0.5 Trinium
    // |> 0.5 Phosphorus
    // |> 0.25 Gallium
    // |> 0.25 Barium

    public static void init(Consumer<FinishedRecipe> provider) {

        // FLUOROANTIMONIC ACID

        CHEMICAL_RECIPES.recipeBuilder("dust_" + Antimony.getName()).EUt(GTValues.VA[GTValues.ULV]).duration(60)
                .inputItems(dust, Antimony, 2)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, AntimonyTrioxide, 5)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("dust_" + AntimonyTrioxide.getName()).EUt(GTValues.VA[GTValues.LV]).duration(60)
                .inputItems(dust, AntimonyTrioxide, 5)
                .inputFluids(HydrofluoricAcid.getFluid(6000))
                .outputItems(dust, AntimonyTrifluoride, 8)
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("dust_" + AntimonyTrifluoride.getName()).EUt(GTValues.VA[GTValues.HV]).duration(300)
                .inputItems(dust, AntimonyTrifluoride, 4)
                .inputFluids(HydrofluoricAcid.getFluid(4000))
                .outputFluids(FluoroantimonicAcid.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);


        // STARTING POINT

        LARGE_CHEMICAL_RECIPES.recipeBuilder("dust_" + Naquadah.getName()).EUt(GTValues.VA[GTValues.LuV]).duration(600)
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .inputItems(dust, Naquadah, 6)
                .outputFluids(ImpureEnrichedNaquadahSolution.getFluid(2000))
                .outputFluids(ImpureNaquadriaSolution.getFluid(2000))
                .outputItems(dust, TitaniumTrifluoride, 4)
                .save(provider);


        // ENRICHED NAQUADAH PROCESS

        CENTRIFUGE_RECIPES.recipeBuilder(ImpureEnrichedNaquadahSolution.getName()).EUt(GTValues.VA[GTValues.EV]).duration(400)
                .inputFluids(ImpureEnrichedNaquadahSolution.getFluid(2000))
                .outputItems(dust, TriniumSulfide)
                .outputItems(dust, AntimonyTrifluoride, 2)
                .outputFluids(EnrichedNaquadahSolution.getFluid(1000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder(AcidicEnrichedNaquadahSolution.getName()).EUt(GTValues.VA[GTValues.HV]).duration(100)
                .inputFluids(EnrichedNaquadahSolution.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .outputFluids(AcidicEnrichedNaquadahSolution.getFluid(3000))
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder(AcidicEnrichedNaquadahSolution.getName()).EUt(GTValues.VA[GTValues.HV]).duration(100)
                .inputFluids(AcidicEnrichedNaquadahSolution.getFluid(3000))
                .outputFluids(EnrichedNaquadahWaste.getFluid(2000))
                .outputFluids(Fluorine.getFluid(500))
                .outputItems(dust, EnrichedNaquadahSulfate, 6) // Nq+SO4
                .save(provider);

        BLAST_RECIPES.recipeBuilder("dust_" + EnrichedNaquadahSulfate.getName()).EUt(GTValues.VA[GTValues.IV]).duration(500).blastFurnaceTemp(7000)
                .inputItems(dust, EnrichedNaquadahSulfate, 6)
                .inputFluids(Hydrogen.getFluid(2000))
                .outputItems(ingotHot, NaquadahEnriched)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder(EnrichedNaquadahWaste.getName()).EUt(GTValues.VA[GTValues.HV]).duration(300)
                .inputFluids(EnrichedNaquadahWaste.getFluid(2000))
                .outputItems(dustSmall, BariumSulfide, 2)
                .outputFluids(SulfuricAcid.getFluid(500))
                .outputFluids(EnrichedNaquadahSolution.getFluid(250))
                .outputFluids(NaquadriaSolution.getFluid(100))
                .save(provider);


        // NAQUADRIA PROCESS

        CENTRIFUGE_RECIPES.recipeBuilder(ImpureNaquadriaSolution.getName()).EUt(GTValues.VA[GTValues.EV]).duration(400)
                .inputFluids(ImpureNaquadriaSolution.getFluid(2000))
                .outputItems(dust, IndiumPhosphide)
                .outputItems(dust, AntimonyTrifluoride, 2)
                .outputFluids(NaquadriaSolution.getFluid(1000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder(AcidicNaquadriaSolution.getName()).EUt(GTValues.VA[GTValues.HV]).duration(100)
                .inputFluids(NaquadriaSolution.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .outputFluids(AcidicNaquadriaSolution.getFluid(3000))
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder(AcidicNaquadriaSolution.getName()).EUt(GTValues.VA[GTValues.HV]).duration(100)
                .inputFluids(AcidicNaquadriaSolution.getFluid(3000))
                .outputFluids(NaquadriaWaste.getFluid(2000))
                .outputFluids(Fluorine.getFluid(500))
                .outputItems(dust, NaquadriaSulfate, 6)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("ingot_hot_" + Naquadria.getName()).EUt(GTValues.VA[GTValues.ZPM]).duration(600).blastFurnaceTemp(9000)
                .inputItems(dust, NaquadriaSulfate, 6)
                .inputFluids(Hydrogen.getFluid(2000))
                .outputItems(ingotHot, Naquadria)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder(NaquadriaWaste.getName()).EUt(GTValues.VA[GTValues.HV]).duration(300)
                .inputFluids(NaquadriaWaste.getFluid(2000))
                .outputItems(dustSmall, GalliumSulfide, 2)
                .outputFluids(SulfuricAcid.getFluid(500))
                .outputFluids(NaquadriaSolution.getFluid(250))
                .outputFluids(EnrichedNaquadahSolution.getFluid(100))
                .save(provider);


        // TRINIUM

        BLAST_RECIPES.recipeBuilder("ingot_hot_" + Trinium.getName()).duration(750).EUt(GTValues.VA[GTValues.LuV]).blastFurnaceTemp(Trinium.getBlastTemperature())
                .inputItems(dust, TriniumSulfide, 2)
                .inputItems(dust, Zinc)
                .outputItems(ingotHot, Trinium)
                .outputItems(dust, ZincSulfide, 2)
                .save(provider);


        // BYPRODUCT PROCESSING

        // Titanium Trifluoride
        BLAST_RECIPES.recipeBuilder("ingot_hot_" + Titanium.getName()).EUt(GTValues.VA[GTValues.HV]).duration(900).blastFurnaceTemp(1941)
                .inputItems(dust, TitaniumTrifluoride, 4)
                .inputFluids(Hydrogen.getFluid(3000))
                .outputItems(ingotHot, Titanium)
                .outputFluids(HydrofluoricAcid.getFluid(3000))
                .save(provider);

        // Indium Phosphide
        CHEMICAL_RECIPES.recipeBuilder("indium_phosphide").duration(30).EUt(GTValues.VA[GTValues.ULV])
                .inputItems(dust, IndiumPhosphide, 2)
                .inputItems(dust, Calcium)
                .outputItems(dust, Indium)
                .outputItems(dust, CalciumPhosphide, 2)
                .save(provider);
    }
}