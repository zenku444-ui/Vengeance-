/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.q.q;

public class zl {
    private static final ThreadLocal<Boolean> a = ThreadLocal.withInitial(() -> false);

    public static void a(boolean bl) {
        a.set(bl);
    }

    public static boolean a() {
        return a.get();
    }
}

