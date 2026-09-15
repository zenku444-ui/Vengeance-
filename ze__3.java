/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.q.s;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;

public final class ze
extends zb {
    public ze() {
        super("Sprint", "Makes you automatically sprint", -1, za.c);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d()) {
            return;
        }
        if (((Boolean)ze.a.options.getSprintToggled().getValue()).booleanValue()) {
            ze.a.options.getSprintToggled().setValue((Object)false);
        }
        ze.a.options.sprintKey.setPressed(true);
    }
}

