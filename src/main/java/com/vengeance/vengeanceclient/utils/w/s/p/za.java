/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.p;

import com.vengeance.vengeanceclient.utils.w.s.r.zb;
import com.vengeance.vengeanceclient.utils.w.s.r.zc;

public final class za
extends com.vengeance.vengeanceclient.utils.w.s.za<com.vengeance.vengeanceclient.utils.w.s.q.za> {
    private zc a;
    private zb b;
    private com.vengeance.vengeanceclient.utils.w.s.r.za c;
    private float d;
    private float e;

    public za a(zc zc2) {
        this.a = zc2;
        return this;
    }

    public za a(zb zb2) {
        this.b = zb2;
        return this;
    }

    public za a(com.vengeance.vengeanceclient.utils.w.s.r.za za2) {
        this.c = za2;
        return this;
    }

    public za a(float f) {
        this.d = f;
        return this;
    }

    public za b(float f) {
        this.e = f;
        return this;
    }

    protected com.vengeance.vengeanceclient.utils.w.s.q.za d() {
        return new com.vengeance.vengeanceclient.utils.w.s.q.za(this.a, this.b, this.c, this.d, this.e);
    }

    @Override
    protected void b() {
        this.a = zc.a;
        this.b = zb.a;
        this.c = com.vengeance.vengeanceclient.utils.w.s.r.za.a;
        this.d = 1.0f;
        this.e = 1.0f;
    }

    @Override
    protected com.vengeance.vengeanceclient.utils.w.s.q.za c() {
        return this.d();
    }
}

