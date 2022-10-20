package gg.twinhead.compresseditems.registry;

import gg.twinhead.compresseditems.CompressedItem;
import gg.twinhead.compresseditems.CompressedItems;
import gg.twinhead.compresseditems.block.CrateBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class BlockRegistry {
    public static HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void register(){
        for (CompressedItem compressedBlock : CompressedItem.values()) {
            for (int i = 0; i < compressedBlock.getMaxCompression(); i++) {
                Block block = new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.METAL));
                registerBlock(compressedBlock.toString(i+1), block);
            }
        }
    }


    private static void registerBlock(String name, Block block) {

        Registry.register(Registry.BLOCK, new Identifier(CompressedItems.MOD_ID, name), block);

        BLOCKS.put(name, block);

        Item.Settings settings = new Item.Settings().group(CompressedItems.GROUP);
        BlockItem item = new CrateBlockItem(block, settings);


        Registry.register(Registry.ITEM, new Identifier(CompressedItems.MOD_ID, name), item);
    }
}
