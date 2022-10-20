package gg.twinhead.compresseditems.datagen;

import gg.twinhead.compresseditems.CompressedItem;
import gg.twinhead.compresseditems.CompressedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (CompressedItem block: CompressedItem.values()) {
            for (int i = 0; i < block.getMaxCompression(); i++) {
               registerCrate(blockStateModelGenerator, block, i+1);
            }
        }
    }

    public void registerCrate(BlockStateModelGenerator blockStateModelGenerator, CompressedItem block, int compression){
        TextureMap textureMap = new TextureMap();
        textureMap.put(TextureKey.CONTENT, block.getTextureIdentifier());
        switch (compression){
            case 1 -> textureMap.put(TextureKey.LAYER0, new Identifier("minecraft", "block/copper_block"));
            case 2 -> textureMap.put(TextureKey.LAYER0, new Identifier("minecraft", "block/iron_block"));
            case 3 -> textureMap.put(TextureKey.LAYER0, new Identifier("minecraft", "block/gold_block"));
            case 4 -> textureMap.put(TextureKey.LAYER0, new Identifier("minecraft", "block/diamond_block"));
            case 5 -> textureMap.put(TextureKey.LAYER0, new Identifier("minecraft", "block/netherite_block"));
        }

        Identifier model = new Model(Optional.of(new Identifier(CompressedItems.MOD_ID, "block/crate")), Optional.empty(), TextureKey.CONTENT, TextureKey.LAYER0)
                .upload(new Identifier(CompressedItems.MOD_ID, "block/"+ block.toString(compression)), textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block.getBlock(compression), model));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
