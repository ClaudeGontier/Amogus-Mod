package net.klode.amogusmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SUS_APPLE = new FoodProperties.Builder().nutrition(4).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 5, 127), 1f).alwaysEat().build();
}
