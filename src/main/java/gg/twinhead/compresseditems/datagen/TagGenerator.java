package gg.twinhead.compresseditems.datagen;

import gg.twinhead.compresseditems.CompressedItem;
import gg.twinhead.compresseditems.CompressedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagGenerator extends FabricTagProvider<Block> {


    /**
     * Construct a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided. For example @see BlockTagProvider
     *
     * @param dataGenerator T    The backing registry for the Tag type.
     */
    public TagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.BLOCK);
    }

    @Override
    protected void generateTags() {
        TagKey<Block> commonStorage = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "storage_blocks"));

        for (CompressedItem block: CompressedItem.values()) {
            for (int i = 0; i < block.getMaxCompression(); i++) {
                getOrCreateTagBuilder(TagKey.of(Registry.BLOCK_KEY, new Identifier(CompressedItems.MOD_ID, block.toString().toLowerCase()))).add(block.getBlock(i + 1));
                if (i > 4) getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE).add(block.getBlock(i + 1));
            }
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).addTag(TagKey.of(Registry.BLOCK_KEY, new Identifier(CompressedItems.MOD_ID, block.toString().toLowerCase())));
            getOrCreateTagBuilder(commonStorage).addTag(TagKey.of(Registry.BLOCK_KEY, new Identifier(CompressedItems.MOD_ID, block.toString().toLowerCase())));
        }


    }


}

