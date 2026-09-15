/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.r;

import com.vengeance.vengeanceclient.r.r.zg;

public class za
extends zg {
    private boolean a;

    public za(String string, boolean bl) {
        super(string);
        this.a = bl;
    }

    public void a() {
        this.a = !this.a;
        this.c();
    }

    public boolean b() {
        return this.a;
    }

    public void a(boolean bl) {
        this.a = bl;
        this.c();
    }

    private void c() {
        com.vengeance.vengeanceclient.utils.za.a().b();
    }
}

