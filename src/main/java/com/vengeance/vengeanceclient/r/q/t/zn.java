/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public final class zn
extends zb {
    private final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Sound Alert", true);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Notification", true);
    private final ze d = new ze("Volume", 0.1f, 2.0, 1.0, 0.1f);
    private final com.vengeance.vengeanceclient.utils.s.zb e = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    public zn() {
        super("ReBuff Notifier", "Plays a sound when speed or strength effects expire", -1, za.b);
        this.a(this.b, this.c, this.d);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (zn.a.player == null || !this.l()) {
            return;
        }
        boolean bl = zn.a.player.hasStatusEffect(StatusEffects.SPEED);
        boolean bl2 = zn.a.player.hasStatusEffect(StatusEffects.STRENGTH);
        if (!bl && this.g) {
            this.b("Speed");
        }
        if (!bl2 && this.h) {
            this.b("Strength");
        }
        if (this.f && this.e.a(3000L)) {
            this.o();
        }
        this.g = bl;
        this.h = bl2;
    }

    private void b(String string) {
        if (this.b.b() && !this.f) {
            this.n();
        }
        if (this.c.b()) {
            com.vengeance.vengeanceclient.utils.u.zb.a().a(string);
        }
    }

    private void n() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.e.a();
        a.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), (float)this.d.b()));
    }

    private void o() {
        this.f = false;
    }

    @Override
    public void b() {
        super.b();
        this.f = false;
        this.g = false;
        this.h = false;
        this.e.a();
    }

    @Override
    public void c() {
        this.o();
        super.c();
    }
}

