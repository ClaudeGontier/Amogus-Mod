package net.klode.amogusmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier SUS = new ForgeTier(3, 1561, 8f,
            3f, 10, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.SUS_INGOT.get()));
}
