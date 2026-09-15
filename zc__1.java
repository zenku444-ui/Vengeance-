/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.p.q;

public final class zc
extends Enum<zc> {
    public static final /* enum */ zc a = new zc();
    public static final /* enum */ zc b = new zc();
    private static final /* synthetic */ zc[] c;

    public static zc[] values() {
        return (zc[])c.clone();
    }

    public static zc valueOf(String string) {
        return Enum.valueOf(zc.class, string);
    }

    private static /* synthetic */ zc[] a() {
        return new zc[]{a, b};
    }

    static {
        c = zc.a();
    }
}

