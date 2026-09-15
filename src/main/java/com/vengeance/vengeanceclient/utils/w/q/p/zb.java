/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package com.vengeance.vengeanceclient.utils.w.q.p;

import com.vengeance.vengeanceclient.utils.w.q.p.zc;
import org.jetbrains.annotations.NotNull;

record zb(int a, int b, int c, int d, char e, zc f) {
    @Override
    @NotNull
    public String toString() {
        return "Glyph[u=" + this.a + ", v=" + this.b + ", width=" + this.c + ", height=" + this.d + ", value=" + this.e + ", owner=" + String.valueOf(this.f) + "]";
    }

}

