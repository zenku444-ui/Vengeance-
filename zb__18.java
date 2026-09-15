/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.s;

public final class zb {
    private long a = System.currentTimeMillis();

    public void a() {
        this.a = System.currentTimeMillis();
    }

    public long b() {
        return System.currentTimeMillis() - this.a;
    }

    public boolean a(long l) {
        return this.b() >= l;
    }

    public boolean a(long l, boolean bl) {
        if (this.b() >= l) {
            if (bl) {
                this.a();
            }
            return true;
        }
        return false;
    }

    public long c() {
        return this.a;
    }
}

