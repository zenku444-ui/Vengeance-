/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.p;

import com.vengeance.vengeanceclient.utils.w.s.r.zc;
import com.vengeance.vengeanceclient.utils.w.s.za;

public final class zb
extends za<com.vengeance.vengeanceclient.utils.w.s.q.zb> {
    private zc a;
    private com.vengeance.vengeanceclient.utils.w.s.r.zb b;
    private com.vengeance.vengeanceclient.utils.w.s.r.za c;
    private float d;

    public zb a(zc zc2) {
        this.a = zc2;
        return this;
    }

    public zb a(com.vengeance.vengeanceclient.utils.w.s.r.zb zb2) {
        this.b = zb2;
        return this;
    }

    public zb a(com.vengeance.vengeanceclient.utils.w.s.r.za za2) {
        this.c = za2;
        return this;
    }

    public zb a(float f) {
        this.d = f;
        return this;
    }

    protected com.vengeance.vengeanceclient.utils.w.s.q.zb d() {
        return new com.vengeance.vengeanceclient.utils.w.s.q.zb(this.a, this.b, this.c, this.d);
    }

    @Override
    protected void b() {
        this.a = zc.a;
        this.b = com.vengeance.vengeanceclient.utils.w.s.r.zb.a;
        this.c = com.vengeance.vengeanceclient.utils.w.s.r.za.a;
        this.d = 1.0f;
    }

    @Override
    protected com.vengeance.vengeanceclient.utils.w.s.q.zb c() {
        return this.d();
    }
}

