/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.r.zf;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;

public final class zm
extends zb {
    private static zm c;
    public static final zf b;

    public zm() {
        super("Hitboxes", "Expands player hitboxes for easier targeting (BLATANT)", -1, za.a);
        this.a(new zg[]{b});
        c = this;
    }

    public static zm n() {
        return c;
    }

    public static float o() {
        if (c != null && c.l()) {
            return (float)b.c();
        }
        return 0.0f;
    }

    static {
        b = new zf("Expansion", 0.0, 2.0, 0.3, 0.3, 0.01);
    }
}

