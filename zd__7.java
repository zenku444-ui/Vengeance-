/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.r;

import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.utils.za;
import java.util.Arrays;
import java.util.List;

public class zd
extends zg {
    private final String a;
    private final List<String> b;
    private int c;

    public zd(String string, String string2, String ... stringArray) {
        super(string);
        this.a = string2;
        this.b = Arrays.asList(stringArray);
        this.c = this.b.indexOf(string2);
        if (this.c == -1) {
            this.c = 0;
        }
    }

    public String a() {
        if (this.c < 0 || this.c >= this.b.size()) {
            this.c = 0;
        }
        return this.b.get(this.c);
    }

    public void a(String string) {
        int n = this.b.indexOf(string);
        if (n != -1) {
            this.c = n;
            this.d();
        }
    }

    public void b() {
        this.c = (this.c + 1) % this.b.size();
        this.d();
    }

    public boolean b(String string) {
        return string.equals(this.a());
    }

    private void d() {
        za.a().b();
    }

    public List<String> c() {
        return this.b;
    }
}

