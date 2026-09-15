/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.t;

import com.vengeance.vengeanceclient.VengeanceClient;

public final class ze {
    public static boolean a() {
        return VengeanceClient.mc.options.forwardKey.isPressed() || VengeanceClient.mc.options.backKey.isPressed() || VengeanceClient.mc.options.leftKey.isPressed() || VengeanceClient.mc.options.rightKey.isPressed();
    }

    private ze() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

