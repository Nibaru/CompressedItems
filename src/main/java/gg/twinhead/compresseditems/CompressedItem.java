package gg.twinhead.compresseditems;

import gg.twinhead.compresseditems.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public enum CompressedItem {
    //Foodstuffs
    APPLE(Items.APPLE),
    BREAD(Items.BREAD),
    PORKCHOP(Items.PORKCHOP),
    COOKED_PORKCHOP(Items.COOKED_PORKCHOP),
    GOLDEN_APPLE(Items.GOLDEN_APPLE),
    COD(Items.COD),
    COOKED_COD(Items.COOKED_COD),
    SALMON(Items.SALMON),
    COOKED_SALMON(Items.COOKED_SALMON),
    TROPICAL_FISH(Items.TROPICAL_FISH),
    PUFFERFISH(Items.PUFFERFISH),
    COOKIE(Items.COOKIE),
    BEEF(Items.BEEF),
    COOKED_BEEF(Items.COOKED_BEEF),
    CHICKEN(Items.CHICKEN),
    COOKED_CHICKEN(Items.COOKED_CHICKEN),
    CARROT(Items.CARROT),
    GOLDEN_CARROT(Items.GOLDEN_CARROT),
    POTATO(Items.POTATO),
    BAKED_POTATO(Items.BAKED_POTATO),
    PUMPKIN_PIE(Items.PUMPKIN_PIE),
    RABBIT(Items.RABBIT),
    COOKED_RABBIT(Items.COOKED_RABBIT),
    MUTTON(Items.MUTTON),
    COOKED_MUTTON(Items.COOKED_MUTTON),
    BEETROOT(Items.BEETROOT),
    GLOW_BERRIES(Items.GLOW_BERRIES),
    SWEET_BERRIES(Items.SWEET_BERRIES),
    CHORUS_FRUIT(Items.CHORUS_FRUIT),
    POPPED_CHORUS_FRUIT(Items.POPPED_CHORUS_FRUIT),


    //Mob Drops
    ROTTEN_FLESH(Items.ROTTEN_FLESH),
    SPIDER_EYE(Items.SPIDER_EYE),
    STRING(Items.STRING),
    GUNPOWDER(Items.GUNPOWDER),
    SCUTE(Items.SCUTE),
    FEATHER(Items.FEATHER),
    LEATHER(Items.LEATHER),
    EGG(Items.EGG),
    BONE(Items.BONE),
    RABBIT_FOOT(Items.RABBIT_FOOT),

    //MISC
    ENDER_PEARL(Items.ENDER_PEARL),
    SADDLE(Items.SADDLE),
    POWERED_RAIL(Blocks.POWERED_RAIL),
    DETECTOR_RAIL(Blocks.DETECTOR_RAIL),
    RAIL(Blocks.RAIL),
    ACTIVATOR_RAIL(Blocks.ACTIVATOR_RAIL),
    MINECART(Items.MINECART),
    CHEST_MINECART(Items.CHEST_MINECART),
    FURNACE_MINECART(Items.FURNACE_MINECART),
    TNT_MINECART(Items.TNT_MINECART),
    HOPPER_MINECART(Items.HOPPER_MINECART),
    SUGAR(Items.SUGAR),
    TURTLE_EGG(Items.TURTLE_EGG),
    ARROW(Items.ARROW),
    BOOK(Items.BOOK),
    PHANTOM_MEMBRANE(Items.PHANTOM_MEMBRANE),
    HEART_OF_THE_SEA(Items.HEART_OF_THE_SEA),
    TOTEM_OF_UNDYING(Items.TOTEM_OF_UNDYING),
    GLASS_BOTTLE(Items.GLASS_BOTTLE),
    NAME_TAG(Items.NAME_TAG),
    LEAD(Items.LEAD),

    //SEEDS
    WHEAT_SEEDS(Items.WHEAT_SEEDS),
    BEETROOT_SEEDS(Items.BEETROOT_SEEDS),
    MELON_SEEDS(Items.MELON_SEEDS),
    PUMPKIN_SEEDS(Items.PUMPKIN_SEEDS),

    //PLANTS
    BAMBOO(Items.BAMBOO),
    SUGAR_CANE(Blocks.SUGAR_CANE),
    KELP(Blocks.KELP),
    OAK_SAPLING(Blocks.OAK_SAPLING),
    SPRUCE_SAPLING(Blocks.SPRUCE_SAPLING),
    BIRCH_SAPLING(Blocks.BIRCH_SAPLING),
    JUNGLE_SAPLING(Blocks.JUNGLE_SAPLING),
    ACACIA_SAPLING(Blocks.ACACIA_SAPLING),
    DARK_OAK_SAPLING(Blocks.DARK_OAK_SAPLING),
    MANGROVE_PROPAGULE(Blocks.MANGROVE_PROPAGULE),
    CRIMSON_FUNGUS(Blocks.CRIMSON_FUNGUS),
    WARPED_FUNGUS(Blocks.WARPED_FUNGUS),
    DANDELION(Blocks.DANDELION),
    POPPY(Blocks.POPPY),
    BLUE_ORCHID(Blocks.BLUE_ORCHID),
    ALLIUM(Blocks.ALLIUM),
    AZURE_BLUET(Blocks.AZURE_BLUET),
    RED_TULIP(Blocks.RED_TULIP),
    ORANGE_TULIP(Blocks.ORANGE_TULIP),
    WHITE_TULIP(Blocks.WHITE_TULIP),
    PINK_TULIP(Blocks.PINK_TULIP),
    OXEYE_DAISY(Blocks.OXEYE_DAISY),
    CORNFLOWER(Blocks.CORNFLOWER),
    LILY_OF_THE_VALLEY(Blocks.LILY_OF_THE_VALLEY),
    WITHER_ROSE(Blocks.WITHER_ROSE),
    SUNFLOWER(Blocks.SUNFLOWER),
    LILAC(Blocks.LILAC),
    ROSE_BUSH(Blocks.ROSE_BUSH),
    PEONY(Blocks.PEONY),
    BROWN_MUSHROOM(Blocks.BROWN_MUSHROOM),
    RED_MUSHROOM(Blocks.RED_MUSHROOM),
    LILY_PAD(Blocks.LILY_PAD),
    VINE(Blocks.VINE),
    GLOW_LICHEN(Blocks.GLOW_LICHEN),
    DEAD_BUSH(Blocks.DEAD_BUSH),
    SEAGRASS(Blocks.SEAGRASS),
    ;


    private final int COMPRESSION = 5;
    private final Item craftingItem;
    private final Block craftingBlock;

    CompressedItem(Item craftingItem){
        this.craftingItem = craftingItem;
        this.craftingBlock = null;
    }

    CompressedItem(Block craftingBlock){
        this.craftingBlock = craftingBlock;
        this.craftingItem = null;
    }

    public int getMaxCompression() {
        return COMPRESSION;
    }

    public String toString(int compression){
        return this.name().toLowerCase() + "_" + CompressedItems.intToRoman(compression);
    }

    public String toString(){
        return this.name().toLowerCase();
    }

    public Block getBlock(int i){
        return BlockRegistry.BLOCKS.get(this.toString(i));
    }

    public Item getCraftingItem() {
        return craftingItem == null ? craftingBlock.asItem() : craftingItem;
    }

    public Identifier getTextureIdentifier(){
        String namespace = craftingItem == null ? "block/" : "item/";
        return switch (this){
            case SUNFLOWER -> new Identifier("minecraft",  namespace + "sunflower_front");
            case LILAC, PEONY, ROSE_BUSH -> new Identifier("minecraft",  namespace + this + "_top");
            default -> new Identifier("minecraft",  namespace + this);
        };
    }
}
