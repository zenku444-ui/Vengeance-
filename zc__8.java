/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;

public class zc
extends zb {
    private static zc b;
    private static final ze c;

    public zc() {
        super("Aspect Ratio", "Changes the game's aspect ratio", za.d);
        this.a(new zg[]{c});
        b = this;
    }

    public static zc n() {
        return b;
    }

    public static float o() {
        if (b != null && b.l()) {
            return (float)c.f();
        }
        return -1.0f;
    }

    public static boolean p() {
        return b != null && b.l();
    }

    static {
        c = new ze("Ratio", 0.5, 3.0, 1.78, 0.01);
    }
}

