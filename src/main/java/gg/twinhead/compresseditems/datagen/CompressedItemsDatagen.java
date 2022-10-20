package gg.twinhead.compresseditems.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CompressedItemsDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ModelGenerator::new);
        fabricDataGenerator.addProvider(LootTableGenerator::new);
        fabricDataGenerator.addProvider(LangDatagen::new);
        fabricDataGenerator.addProvider(RecipeGenerator::new);
        fabricDataGenerator.addProvider(TagGenerator::new);
    }
}
