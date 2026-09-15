/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.q;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class za {
    private static final Set<UUID> a = new HashSet<UUID>();

    public static void a(UUID uUID) {
        a.add(uUID);
    }

    public static void b(UUID uUID) {
        a.remove(uUID);
    }

    public static boolean c(UUID uUID) {
        return a.contains(uUID);
    }

    public static void d(UUID uUID) {
        if (za.c(uUID)) {
            za.b(uUID);
        } else {
            za.a(uUID);
        }
    }

    public static Set<UUID> a() {
        return new HashSet<UUID>(a);
    }

    public static void b() {
        a.clear();
    }
}

