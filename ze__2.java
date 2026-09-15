/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.text.Text
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.text.Text;
import net.minecraft.util.hit.EntityHitResult;

public final class ze
extends zb {
    public ze() {
        super("Middle Click Friend", "Middle click on players to add/remove them from friends list", -1, za.e);
    }

    @EventHandler
    private void onMouseClick(com.vengeance.vengeanceclient.p.p.q.zb zb2) {
        if (zb2.a() == 2 && zb2.b() == 1) {
            EntityHitResult class_39662;
            Entity class_12972;
            if (this.d()) {
                return;
            }
            HitResult ItemStackParticleEffect = ze.a.crosshairTarget;
            if (ItemStackParticleEffect != null && ItemStackParticleEffect.getType() == HitResult.class_240.ENTITY && (class_12972 = (class_39662 = (EntityHitResult)ItemStackParticleEffect).getEntity()) instanceof PlayerEntity) {
                PlayerEntity class_16572 = (PlayerEntity)class_12972;
                if (class_16572 == ze.a.player) {
                    return;
                }
                com.vengeance.vengeanceclient.utils.q.za.d(class_16572.getUuid());
                if (com.vengeance.vengeanceclient.utils.q.za.c(class_16572.getUuid())) {
                    ze.a.player.sendMessage((Text)Text.literal((String)("\u00a7a" + class_16572.getName().getString() + " added to friends")), false);
                } else {
                    ze.a.player.sendMessage((Text)Text.literal((String)("\u00a7c" + class_16572.getName().getString() + " removed from friends")), false);
                }
            }
        }
    }
}

