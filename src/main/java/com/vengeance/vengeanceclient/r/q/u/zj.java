/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.client.option.SimpleOption
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.client.option.SimpleOption;

public class zj
extends zb {
    private static final double b = 16.0;
    private static final int c = 220;
    private Double d = null;

    public zj() {
        super("Full Bright", "Removes darkness", za.d);
    }

    @Override
    public void b() {
        super.b();
        this.n();
    }

    @EventHandler
    private void onTick(zd zd2) {
        this.n();
        this.o();
    }

    private void n() {
        if (a != null && zj.a.options != null) {
            try {
                SimpleOption class_71722 = zj.a.options.getGamma();
                if (this.d == null) {
                    this.d = (Double)class_71722.getValue();
                }
                class_71722.setValue(16.0);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    private void o() {
        if (a == null || zj.a.player == null) {
            return;
        }
        try {
            zj.a.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0, false, false));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Override
    public void c() {
        super.c();
        if (a != null && zj.a.options != null && this.d != null) {
            try {
                zj.a.options.getGamma().setValue(this.d);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        this.d = null;
    }
}

