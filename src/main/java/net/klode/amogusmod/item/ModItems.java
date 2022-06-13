package net.klode.amogusmod.item;

import net.klode.amogusmod.AmogusMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AmogusMod.MOD_ID);

    public static final RegistryObject<Item> SUS_INGOT = ITEMS.register("sus_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_NUGGET = ITEMS.register("sus_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_SWORD = ITEMS.register("sus_sword",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_PICKAXE = ITEMS.register("sus_pickaxe",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_AXE = ITEMS.register("sus_axe",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_SHOVEL = ITEMS.register("sus_shovel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_HOE = ITEMS.register("sus_hoe",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_HELMET = ITEMS.register("sus_helmet",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_CHESTPLATE = ITEMS.register("sus_chestplate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_LEGGINGS = ITEMS.register("sus_leggings",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_BOOTS = ITEMS.register("sus_boots",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_APPLE = ITEMS.register("sus_apple",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
