package gg.twinhead.compresseditems.datagen;

import gg.twinhead.compresseditems.CompressedItem;
import gg.twinhead.compresseditems.CompressedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
public class LangDatagen extends FabricLanguageProvider {

    protected LangDatagen(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(CompressedItems.GROUP, "Compressed Blocks");

        for (CompressedItem block: CompressedItem.values()) {
            for (int i = 0; i < block.getMaxCompression(); i++) {
                translationBuilder.add("block.compressed_items." + block.toString(i+1), formatName(block, i+1));
            }
        }

    }

    public String formatName(CompressedItem block, int compression){
        String[] parts = block.toString(compression).split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: parts) {
            if(!s.contains("block"))
                stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).append(" ");
        }
        stringBuilder.replace(stringBuilder.length() - CompressedItems.intToRoman(compression).length()- 1, stringBuilder.length() - 1, CompressedItems.intToRoman(compression).toUpperCase());
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }
}
