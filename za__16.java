/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r;

public final class za
extends Enum<za> {
    public static final /* enum */ za a = new za("Combat");
    public static final /* enum */ za b = new za("Player");
    public static final /* enum */ za c = new za("Movement");
    public static final /* enum */ za d = new za("Render");
    public static final /* enum */ za e = new za("Misc");
    public static final /* enum */ za f = new za("Client");
    public static final /* enum */ za g = new za("Config");
    public static final /* enum */ za h = new za("Credits");
    private final String i;
    private static final /* synthetic */ za[] j;

    public static za[] values() {
        return (za[])j.clone();
    }

    public static za valueOf(String string) {
        return Enum.valueOf(za.class, string);
    }

    private za(String string2) {
        this.i = string2;
    }

    public String a() {
        return this.i;
    }

    private static /* synthetic */ za[] b() {
        return new za[]{a, b, c, d, e, f, g, h};
    }

    static {
        j = za.b();
    }
}

