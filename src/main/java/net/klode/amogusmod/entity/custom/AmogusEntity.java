package net.klode.amogusmod.entity.custom;

import net.klode.amogusmod.entity.variant.AmogusVariant;
import net.klode.amogusmod.sound.ModSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AmogusEntity extends Monster implements GeoEntity {
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.amogus.walk");
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.amogus.idle");

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(AmogusEntity.class, EntityDataSerializers.INT);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public AmogusEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.5f)
                .add(Attributes.MOVEMENT_SPEED, 1.0f)
                .add(Attributes.ATTACK_KNOCKBACK, 2.5f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0f));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return switch (this.random.nextInt(5)) {
            case 0 -> ModSounds.AMOGUS_AMBIENT_1.get();
            case 1 -> ModSounds.AMOGUS_AMBIENT_2.get();
            case 2 -> ModSounds.AMOGUS_AMBIENT_3.get();
            case 3 -> ModSounds.AMOGUS_AMBIENT_4.get();
            default -> ModSounds.AMOGUS_AMBIENT_5.get();
        };
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.AMOGUS_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    /* VARIANT */
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        EntitySpawnReason spawnReason, @Nullable SpawnGroupData spawnGroupData) {
        AmogusVariant variant = Util.getRandom(AmogusVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnReason, spawnGroupData);
    }

    public AmogusVariant getVariant() {
        return AmogusVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(AmogusVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.entityData.set(DATA_ID_TYPE_VARIANT, input.getIntOr("Variant", 0));
    }

    @Override
    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE_VARIANT, 0);
    }

    /* ANIMATIONS */
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("controller", 0,
                test -> test.setAndContinue(test.isMoving() ? WALK : IDLE)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
