package net.klode.amogusmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties SUS_APPLE = new FoodProperties.Builder().nutrition(4).saturationModifier(1.2f)
            .alwaysEdible().build();

    public static final Consumable SUS_APPLE_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 127), 1f)).build();
}
