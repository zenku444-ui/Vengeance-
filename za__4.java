/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package com.vengeance.vengeanceclient.p.p.t;

import com.vengeance.vengeanceclient.p.q.zb;
import net.minecraft.client.gui.DrawContext;

public class za
implements zb {
    private DrawContext a;
    private int b;
    private int c;

    public za(DrawContext class_3322, int n, int n2) {
        this.a = class_3322;
        this.b = n;
        this.c = n2;
    }

    public DrawContext a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void a(DrawContext class_3322) {
        this.a = class_3322;
    }

    public void a(int n) {
        this.b = n;
    }

    public void b(int n) {
        this.c = n;
    }
}

