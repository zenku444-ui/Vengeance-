/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.p;

import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class zd {
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    public static final zd a = new zd(0, 0, 0, 0);
    public static final zd b = new zd(-1, -1, -1, -1);

    public zd(Color color, Color color2, Color color3, Color color4) {
        this(color.getRGB(), color2.getRGB(), color3.getRGB(), color4.getRGB());
    }

    public zd(Color color) {
        this(color, color, color, color);
    }

    public zd(int n) {
        this(n, n, n, n);
    }

    public zd(int n, int n2, int n3, int n4) {
        this.c = n;
        this.d = n2;
        this.e = n3;
        this.f = n4;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    @Override
    public String toString() {
        return "zd[c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + "]";
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(this.c);
        result = 31 * result + Integer.hashCode(this.d);
        result = 31 * result + Integer.hashCode(this.e);
        result = 31 * result + Integer.hashCode(this.f);
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zd)) {
            return false;
        }
        zd other = (zd)object;
        return this.c == other.c && this.d == other.d && this.e == other.e && this.f == other.f;
    }
}

