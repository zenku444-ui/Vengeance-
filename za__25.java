/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.u;

public class za {
    private String a;
    private String b;
    private za c;
    private long d;
    private long e;
    private float f;
    private boolean g;

    public za(String string, String string2, za za2, long l) {
        this.a = string;
        this.b = string2;
        this.c = za2;
        this.e = l;
        this.d = System.currentTimeMillis();
        this.f = 0.0f;
        this.g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() - this.d > this.e;
    }

    public float b() {
        long l = System.currentTimeMillis() - this.d;
        return Math.min(1.0f, (float)l / (float)this.e);
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public za e() {
        return this.c;
    }

    public long f() {
        return this.d;
    }

    public long g() {
        return this.e;
    }

    public float h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public void a(String string) {
        this.a = string;
    }

    public void b(String string) {
        this.b = string;
    }

    public void a(za za2) {
        this.c = za2;
    }

    public void a(long l) {
        this.d = l;
    }

    public void b(long l) {
        this.e = l;
    }

    public void a(float f) {
        this.f = f;
    }

    public void a(boolean bl) {
        this.g = bl;
    }

    public static final class za
    extends Enum<za> {
        public static final /* enum */ za a = new za();
        public static final /* enum */ za b = new za();
        public static final /* enum */ za c = new za();
        private static final /* synthetic */ za[] d;

        public static za[] values() {
            return (za[])d.clone();
        }

        public static za valueOf(String string) {
            return Enum.valueOf(za.class, string);
        }

        private static /* synthetic */ za[] a() {
            return new za[]{a, b, c};
        }

        static {
            d = za.a();
        }
    }
}

