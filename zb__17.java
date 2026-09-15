/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Library
 *  com.sun.jna.Native
 */
package com.vengeance.vengeanceclient.utils.r.p;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface zb
extends Library {
    public static final zb a = (zb)Native.load((String)"user32", zb.class);
    public static final int b = 2;
    public static final int c = 4;

    public void a(int var1, int var2, int var3, int var4, int var5);
}

