package net.klode.amogusmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab AMOGUS_TAB = new CreativeModeTab("amogustab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.COARSE_DIRT);
        }
    };

}
