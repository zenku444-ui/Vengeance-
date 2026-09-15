/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.u;

import com.vengeance.vengeanceclient.utils.u.za;
import java.util.ArrayList;
import java.util.List;

public class zb {
    private static final zb a = new zb();
    private static final long b = 3000L;
    private final List<za> c = new ArrayList<za>();

    public static zb a() {
        return a;
    }

    public void a(com.vengeance.vengeanceclient.r.zb zb2, boolean bl) {
        String string = zb2.i();
        String string2 = bl ? "Enabled" : "Disabled";
        za.za za2 = bl ? za.za.a : za.za.b;
        za za3 = new za(string, string2, za2, 3000L);
        this.c.add(za3);
    }

    public void a(String string) {
        String string2 = "rebuff";
        String string3 = string;
        za za2 = new za(string2, string3, za.za.c, 3000L);
        this.c.add(za2);
    }

    public List<za> b() {
        return this.c;
    }
}

