package net.klode.amogusmod.item;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.item.custom.SusArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
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
            () -> new SwordItem(ModTiers.SUS, 3, -2.4F,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_PICKAXE = ITEMS.register("sus_pickaxe",
            () -> new PickaxeItem(ModTiers.SUS, 1, -2.8F,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_AXE = ITEMS.register("sus_axe",
            () -> new AxeItem(ModTiers.SUS, 5.0F, -3.0F,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_SHOVEL = ITEMS.register("sus_shovel",
            () -> new ShovelItem(ModTiers.SUS, 1.5F, -3.0F,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_HOE = ITEMS.register("sus_hoe",
            () -> new HoeItem(ModTiers.SUS, -3, 0.0F,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_HELMET = ITEMS.register("sus_helmet",
            () -> new SusArmorItem(ModArmorMaterials.SUS, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));
    
    public static final RegistryObject<Item> SUS_CHESTPLATE = ITEMS.register("sus_chestplate",
            () -> new SusArmorItem(ModArmorMaterials.SUS, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));
    
    public static final RegistryObject<Item> SUS_LEGGINGS = ITEMS.register("sus_leggings",
            () -> new SusArmorItem(ModArmorMaterials.SUS, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));
    
    public static final RegistryObject<Item> SUS_BOOTS = ITEMS.register("sus_boots",
            () -> new SusArmorItem(ModArmorMaterials.SUS, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB)));

    public static final RegistryObject<Item> SUS_APPLE = ITEMS.register("sus_apple",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMOGUS_TAB).food(ModFoods.SUS_APPLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
