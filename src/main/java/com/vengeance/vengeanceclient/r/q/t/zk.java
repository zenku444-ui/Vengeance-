/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;

public class zk
extends zb {
    private final ze b = new ze("Speed", 1.0, 10.0, 5.0, 0.5);

    public zk() {
        super("Fast Mine", "Mine blocks faster", -1, za.b);
        this.a(new zg[]{this.b});
    }

    public float n() {
        return this.b.b();
    }
}

