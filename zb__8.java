/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.hit.HitResult$Type
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.za;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.hit.HitResult;

public final class zb
extends com.vengeance.vengeanceclient.r.zb {
    public zb() {
        super("Anti Miss", "Makes you not miss", -1, za.a);
    }

    @EventHandler
    private void onAttackEvent(com.vengeance.vengeanceclient.p.p.s.za za2) {
        if (this.d()) {
            return;
        }
        assert (zb.a.crosshairTarget != null);
        if (zb.a.crosshairTarget.getType().equals((Object)HitResult.class_240.MISS)) {
            za2.c();
        }
    }
}

