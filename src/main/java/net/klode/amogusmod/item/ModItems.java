package net.klode.amogusmod.item;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.item.custom.SusArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AmogusMod.MOD_ID);

    public static final DeferredItem<Item> SUS_NUGGET = ITEMS.registerItem("sus_nugget", Item::new);

    public static final DeferredItem<Item> SUS_INGOT = ITEMS.registerItem("sus_ingot", Item::new);

    public static final DeferredItem<Item> SUS_SWORD = ITEMS.registerItem("sus_sword",
            properties -> new Item(properties.sword(ModTiers.SUS, 3, -2.4F)));

    public static final DeferredItem<Item> SUS_PICKAXE = ITEMS.registerItem("sus_pickaxe",
            properties -> new Item(properties.pickaxe(ModTiers.SUS, 1, -2.8F)));

    public static final DeferredItem<AxeItem> SUS_AXE = ITEMS.registerItem("sus_axe",
            properties -> new AxeItem(ModTiers.SUS, 5.0F, -3.0F, properties));

    public static final DeferredItem<ShovelItem> SUS_SHOVEL = ITEMS.registerItem("sus_shovel",
            properties -> new ShovelItem(ModTiers.SUS, 1.5F, -3.0F, properties));

    public static final DeferredItem<HoeItem> SUS_HOE = ITEMS.registerItem("sus_hoe",
            properties -> new HoeItem(ModTiers.SUS, -3, 0.0F, properties));

    public static final DeferredItem<SusArmorItem> SUS_HELMET = ITEMS.registerItem("sus_helmet",
            properties -> new SusArmorItem(ModArmorMaterials.SUS, ArmorType.HELMET, properties));

    public static final DeferredItem<SusArmorItem> SUS_CHESTPLATE = ITEMS.registerItem("sus_chestplate",
            properties -> new SusArmorItem(ModArmorMaterials.SUS, ArmorType.CHESTPLATE, properties));

    public static final DeferredItem<SusArmorItem> SUS_LEGGINGS = ITEMS.registerItem("sus_leggings",
            properties -> new SusArmorItem(ModArmorMaterials.SUS, ArmorType.LEGGINGS, properties));

    public static final DeferredItem<SusArmorItem> SUS_BOOTS = ITEMS.registerItem("sus_boots",
            properties -> new SusArmorItem(ModArmorMaterials.SUS, ArmorType.BOOTS, properties));

    public static final DeferredItem<Item> SUS_APPLE = ITEMS.registerItem("sus_apple",
            properties -> new Item(properties.food(ModFoods.SUS_APPLE, ModFoods.SUS_APPLE_EFFECT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
