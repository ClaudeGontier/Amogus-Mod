package net.klode.amogusmod.item;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.sound.ModSounds;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public class ModArmorMaterials {
    private static final ResourceKey<? extends Registry<EquipmentAsset>> EQUIPMENT_ASSET_ROOT =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> SUS_ASSET =
            ResourceKey.create(EQUIPMENT_ASSET_ROOT, AmogusMod.id("sus"));

    public static final ArmorMaterial SUS = new ArmorMaterial(33,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 11);
            }), 10, ModSounds.BOOM, 2.0F, 0.0F, ModTiers.SUS_REPAIRABLE, SUS_ASSET);
}
