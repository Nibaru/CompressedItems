package gg.twinhead.compresseditems.datagen;

import gg.twinhead.compresseditems.CompressedItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        for (CompressedItem block: CompressedItem.values()) {
            RecipeProvider.offerReversibleCompactingRecipes(exporter, block.getCraftingItem(), block.getBlock(1), block + "_pack", block.toString(), block.toString(1) + "_unpack", block.toString());
            for (int i = 0; i < block.getMaxCompression() - 1; i++) {
                RecipeProvider.offerReversibleCompactingRecipes(exporter, block.getBlock(i +1), block.getBlock(i + 2), block.toString(i + 1) + "_pack", block.toString(), block.toString(i + 2) + "_unpack", block.toString());
            }
        }
    }
}
