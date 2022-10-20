package gg.twinhead.compresseditems.datagen;

import gg.twinhead.compresseditems.CompressedItem;
import gg.twinhead.compresseditems.CompressedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class LootTableGenerator extends SimpleFabricLootTableProvider {


    public LootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        for (CompressedItem block: CompressedItem.values()) {
            for (int i = 0; i < block.getMaxCompression(); i++) {
                identifierBuilderBiConsumer.accept(new Identifier(CompressedItems.MOD_ID, "blocks/" + block.toString(i+1)), BlockLootTableGenerator.drops(block.getBlock(i+1)));

            }

        }
    }
}
