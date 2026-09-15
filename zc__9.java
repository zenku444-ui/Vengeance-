/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.r;

import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.utils.za;

public final class zc
extends zg {
    private final boolean a;
    private final int b;
    private int c;
    private boolean d;
    private boolean e;

    public zc(String string, int n, boolean bl) {
        super(string);
        this.c = n;
        this.b = n;
        this.a = bl;
        this.e = false;
    }

    public void a() {
        this.d = !this.d;
    }

    public void b() {
        this.e = !this.e;
        this.h();
    }

    public void a(int n) {
        this.c = n;
        this.h();
    }

    private void h() {
        za.a().b();
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.e;
    }

    public void a(boolean bl) {
        this.d = bl;
    }

    public void b(boolean bl) {
        this.e = bl;
    }
}

