/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.decoration.EndCrystalEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.EntityHitResult;

public final class zi
extends zb {
    public zi() {
        super("Crystal Optimizer", "Makes crystals disappear faster client-side for quicker placement.", -1, za.a);
    }

    @EventHandler
    private void onAttackEvent(com.vengeance.vengeanceclient.p.p.s.zb zb2) {
        boolean bl;
        if (this.d()) {
            return;
        }
        if (zi.a.crosshairTarget == null) {
            return;
        }
        if (zi.a.crosshairTarget.getType() != HitResult.class_240.ENTITY) {
            return;
        }
        HitResult ItemStackParticleEffect = zi.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof EntityHitResult)) {
            return;
        }
        EntityHitResult class_39662 = (EntityHitResult)ItemStackParticleEffect;
        ItemStackParticleEffect = class_39662.getEntity();
        if (!(ItemStackParticleEffect instanceof EndCrystalEntity)) {
            return;
        }
        EndCrystalEntity class_15112 = (EndCrystalEntity)ItemStackParticleEffect;
        StatusEffectInstance class_12932 = zi.a.player.getStatusEffect(StatusEffects.WEAKNESS);
        StatusEffectInstance class_12933 = zi.a.player.getStatusEffect(StatusEffects.STRENGTH);
        ItemStack class_17992 = zi.a.player.getMainHandStack();
        boolean bl2 = bl = class_12932 == null || class_12933 != null && class_12933.getAmplifier() > class_12932.getAmplifier() || class_17992.isIn(ItemTags.SWORDS) || class_17992.isIn(ItemTags.AXES) || class_17992.isIn(ItemTags.PICKAXES) || class_17992.isIn(ItemTags.SHOVELS) || class_17992.isIn(ItemTags.HOES);
        if (!bl) {
            return;
        }
        class_15112.setRemoved(Entity.class_5529.KILLED);
        class_15112.onRemoved();
    }
}

