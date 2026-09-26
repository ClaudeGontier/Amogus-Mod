package net.klode.amogusmod.item;

import net.klode.amogusmod.AmogusMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ModTiers {
    public static final TagKey<Item> SUS_REPAIRABLE =
            TagKey.create(Registries.ITEM, AmogusMod.id("sus_repairable"));

    public static final ToolMaterial SUS = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1561, 8f, 3f, 10, SUS_REPAIRABLE);
}
