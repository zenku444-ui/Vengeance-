/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.p;

import com.vengeance.vengeanceclient.utils.w.p.zc;
import com.vengeance.vengeanceclient.utils.w.p.zd;
import com.vengeance.vengeanceclient.utils.w.p.ze;
import com.vengeance.vengeanceclient.utils.w.p.zf;
import java.awt.Color;

public final class za {
    private zf a = zf.a;
    private ze b = ze.a;
    private zd c = zd.b;
    private float d = 1.0f;
    private float e = 0.0f;

    public za a(zf zf2) {
        this.a = zf2;
        return this;
    }

    public za a(float f, float f2) {
        this.a = new zf(f, f2);
        return this;
    }

    public za a(ze ze2) {
        this.b = ze2;
        return this;
    }

    public za a(float f) {
        this.b = new ze(f);
        return this;
    }

    public za a(zd zd2) {
        this.c = zd2;
        return this;
    }

    public za a(Color color) {
        this.c = new zd(color);
        return this;
    }

    public za b(float f) {
        this.d = f;
        return this;
    }

    public za c(float f) {
        this.e = f;
        return this;
    }

    public zc a() {
        zc zc2 = new zc(this.a, this.b, this.c, this.d, this.e);
        this.c();
        return zc2;
    }

    private void c() {
        this.a = zf.a;
        this.b = ze.a;
        this.c = zd.b;
        this.d = 1.0f;
        this.e = 0.0f;
    }

    public static za b() {
        return new za();
    }
}

