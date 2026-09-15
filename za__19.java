/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.p;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class za {
    private static final String a = "https://vengeance-auth.vercel.app";
    private static final int b = 0;
    private static final Pattern c = Pattern.compile("VNG-[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}");
    private static za d;
    private static zb e;
    private static ExecutorService f;
    private static boolean g;
    private static String h;
    private static volatile boolean i;
    private static volatile boolean j;
    private static volatile Thread k;
    private static final File l;

    public static void a() {
        if (d == null) {
            d = new za();
        }
    }

    public static za b() {
        if (d == null) {
            za.a();
        }
        return d;
    }

    public boolean c() {
        return true;
    }

    public String d() {
        return "CRACKED-TOKEN";
    }

    public String e() {
        return "Never";
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return "premium";
    }

    public void a(String string, za za2) {
        if (za2 != null) {
            za2.a("CRACKED-TOKEN", "premium");
        }
    }

    public void a(za za2) {
        if (za2 != null) {
            za2.a("CRACKED-TOKEN", "premium");
        }
    }

    public void h() {
    }

    private void i() {
    }

    private void j() {
    }

    private void k() {
    }

    private zb a(String string) {
        return e;
    }

    private String a(Object object, String ... stringArray) {
        return "";
    }

    private long b(Object object, String ... stringArray) {
        return 0L;
    }

    private String b(String string) {
        return "";
    }

    private void l() {
    }

    private void m() {
    }

    private String a(String string, String string2) {
        return "";
    }

    private void n() {
    }

    private void b(za za2) {
        if (za2 != null) {
            za2.a("CRACKED-TOKEN", "premium");
        }
    }

    private void b(String string, za za2) {
        if (za2 != null) {
            za2.a("CRACKED-TOKEN", "premium");
        }
    }

    static {
        e = new zb("CRACKED-KEY", "CRACKED-TOKEN", Long.MAX_VALUE, "premium");
        f = Executors.newSingleThreadExecutor();
        g = true;
        h = null;
        i = false;
        j = false;
        k = null;
        l = new File("vengeance-client/auth.dat");
        za.a();
    }

    public static interface za {
        public void a(String var1, String var2);

        public void a(String var1);
    }

    public static class zb {
        public String a;
        public String b;
        public long c;
        public String d;
        public long e;

        public zb() {
        }

        public zb(String string, long l, String string2) {
            this(null, string, l, string2);
        }

        public zb(String string, String string2, long l, String string3) {
            this.a = string;
            this.b = string2;
            this.c = l;
            this.d = string3;
            this.e = System.currentTimeMillis();
        }
    }
}

