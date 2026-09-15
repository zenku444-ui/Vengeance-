/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.s;

import java.security.SecureRandom;

public final class za {
    private static final SecureRandom a = new SecureRandom();

    public static double a(double d, double d2) {
        if (d >= d2) {
            d -= 1.0;
        }
        return a.nextDouble(d, d2);
    }

    private za() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

