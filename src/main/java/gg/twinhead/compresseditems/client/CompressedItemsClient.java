package gg.twinhead.compresseditems.client;

import gg.twinhead.compresseditems.CompressedItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class CompressedItemsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (CompressedItem block: CompressedItem.values()) {
            for (int i = 0; i < block.getMaxCompression(); i++) {
                BlockRenderLayerMap.INSTANCE.putBlock(block.getBlock(i+1), RenderLayer.getTranslucent());

                if(block == CompressedItem.LILY_PAD){
                    ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? 2129968 : 7455580, block.getBlock(i+1));
                    ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 2129968, block.getBlock(i+1));
                }
            }
        }
    }
}
