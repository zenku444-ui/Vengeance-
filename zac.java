/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;

public class zac
extends zb {
    public static final ze b = new ze("Chance (%)", 1.0, 100.0, 100.0, 1.0);
    private final ze e = new ze("Ms", 1.0, 500.0, 60.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Only on ground", true);
    boolean c;
    com.vengeance.vengeanceclient.utils.s.zb d = new com.vengeance.vengeanceclient.utils.s.zb();

    public zac() {
        super("WTap", "Makes you automatically WTAP", -1, za.a);
        this.a(this.e, b, this.f);
    }

    @EventHandler
    private void onAttackEvent(com.vengeance.vengeanceclient.p.p.s.zb zb2) {
        if (this.d()) {
            return;
        }
        if (Math.random() * 100.0 > (double)b.b()) {
            return;
        }
        Entity class_12972 = zac.a.targetedEntity;
        if (!zac.a.player.isOnGround() && this.f.b()) {
            return;
        }
        if (class_12972 == null) {
            return;
        }
        if (!class_12972.isAlive()) {
            return;
        }
        if (!com.vengeance.vengeanceclient.utils.r.za.b(87)) {
            return;
        }
        if (zac.a.player.isSprinting()) {
            this.c = true;
            zac.a.options.forwardKey.setPressed(false);
        }
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d()) {
            return;
        }
        if (!com.vengeance.vengeanceclient.utils.r.za.b(87)) {
            return;
        }
        if (this.c && this.d.a(this.e.a(), true)) {
            zac.a.options.forwardKey.setPressed(true);
            this.c = false;
        }
    }
}

