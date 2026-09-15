/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package com.vengeance.vengeanceclient.utils.w.q.p;

import com.vengeance.vengeanceclient.utils.w.q.p.zc;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

record zb(int a, int b, int c, int d, char e, zc f) {
    @Override
    @NotNull
    public String toString() {
        return "Glyph[u=" + this.a + ", v=" + this.b + ", width=" + this.c + ", height=" + this.d + ", value=" + this.e + ", owner=" + String.valueOf(this.f) + "]";
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zb.class, "u;v;width;height;value;owner", "a", "b", "c", "d", "e", "f"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zb.class, "u;v;width;height;value;owner", "a", "b", "c", "d", "e", "f"}, this, object);
    }
}

