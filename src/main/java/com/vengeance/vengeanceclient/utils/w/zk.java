/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package com.vengeance.vengeanceclient.utils.w;

import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

public final class zk {
    public static void a(DrawContext class_3322, zb zb2) {
        for (zc zc2 : zb2.a) {
            com.vengeance.vengeanceclient.utils.w.zi.a(class_3322, zc2.b(), zc2.c(), zc2.d(), zc2.e(), 0, 1, new Color(255, 0, 0, 100));
        }
    }

    public static void a(DrawContext class_3322, zd zd2) {
        for (ze ze2 : zd2.a) {
            com.vengeance.vengeanceclient.utils.w.zi.a(class_3322, ze2.b(), ze2.c(), ze2.d(), ze2.e(), 0, 1, new Color(0, 255, 0, 100));
        }
    }

    private zk() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static class zb {
        private final List<zc> a = new ArrayList<zc>();
        private zb$Mode b = zb$Mode.a;
        private zc$Mode c = zc$Mode.a;
        private za$Align d = za$Align.a;
        private int e = 0;
        private zg f = new zg(0);

        public zb a(zb$Mode zb2) {
            this.b = zb2;
            return this;
        }

        public zb a(zc$Mode zc2) {
            this.c = zc2;
            return this;
        }

        public zb a(za$Align za2) {
            this.d = za2;
            return this;
        }

        public zb a(int n) {
            this.e = n;
            return this;
        }

        public zb b(int n) {
            this.f = new zg(n);
            return this;
        }

        public zb a(int n, int n2, int n3, int n4) {
            this.f = new zg(n, n2, n3, n4);
            return this;
        }

        public zb a(zc zc2) {
            this.a.add(zc2);
            return this;
        }

        public void b(int n, int n2, int n3, int n4) {
            if (this.a.isEmpty()) {
                return;
            }
            int n5 = n + this.f.d;
            int n6 = n2 + this.f.a;
            int n7 = n3 - this.f.d - this.f.b;
            int n8 = n4 - this.f.a - this.f.c;
            boolean bl = this.b == zb$Mode.a || this.b == zb$Mode.c;
            int n9 = bl ? n7 : n8;
            int n10 = bl ? n8 : n7;
            int n11 = 0;
            int n12 = 0;
            for (zc object2 : this.a) {
                n11 = bl ? (n11 += object2.f()) : (n11 += object2.g());
                n12 += object2.h;
            }
            int n13 = Math.max(0, n9 - (n11 += this.e * (this.a.size() - 1)));
            int[] nArray = this.a(n9, n11, n13);
            for (int i = 0; i < this.a.size(); ++i) {
                int n14;
                int n15;
                int n16;
                int n17;
                zc zc2 = this.a.get(i);
                int n18 = nArray[i];
                int n19 = this.a(zc2, n10);
                if (bl) {
                    n17 = n5 + n18;
                    n16 = n6 + n19;
                    n15 = zc2.f();
                    if (zc2.h > 0 && n13 > 0) {
                        n15 += n13 * zc2.h / n12;
                    }
                    n14 = this.d == za$Align.d ? n10 : zc2.g();
                } else {
                    n17 = n5 + n19;
                    n16 = n6 + n18;
                    n15 = this.d == za$Align.d ? n10 : zc2.f();
                    n14 = zc2.g();
                    if (zc2.h > 0 && n13 > 0) {
                        n14 += n13 * zc2.h / n12;
                    }
                }
                zc2.a(n17, n16, n15, n14);
            }
        }

        private int[] a(int n, int n2, int n3) {
            int[] nArray = new int[this.a.size()];
            switch (this.c.ordinal()) {
                case 0: {
                    int n4 = 0;
                    for (int i = 0; i < this.a.size(); ++i) {
                        nArray[i] = n4;
                        n4 += (this.b == zb$Mode.a ? this.a.get(i).f() : this.a.get(i).g()) + this.e;
                    }
                    break;
                }
                case 1: {
                    int n5 = n - n2;
                    for (int i = 0; i < this.a.size(); ++i) {
                        nArray[i] = n5;
                        n5 += (this.b == zb$Mode.a ? this.a.get(i).f() : this.a.get(i).g()) + this.e;
                    }
                    break;
                }
                case 2: {
                    int n6 = (n - n2) / 2;
                    for (int i = 0; i < this.a.size(); ++i) {
                        nArray[i] = n6;
                        n6 += (this.b == zb$Mode.a ? this.a.get(i).f() : this.a.get(i).g()) + this.e;
                    }
                    break;
                }
                case 3: {
                    if (this.a.size() == 1) {
                        nArray[0] = 0;
                        break;
                    }
                    int n7 = n3 / (this.a.size() - 1);
                    int n8 = 0;
                    for (int i = 0; i < this.a.size(); ++i) {
                        nArray[i] = n8;
                        n8 += (this.b == zb$Mode.a ? this.a.get(i).f() : this.a.get(i).g()) + this.e + n7;
                    }
                    break;
                }
                case 4: {
                    int n9 = n3 / this.a.size();
                    int n10 = n9 / 2;
                    for (int i = 0; i < this.a.size(); ++i) {
                        nArray[i] = n10;
                        n10 += (this.b == zb$Mode.a ? this.a.get(i).f() : this.a.get(i).g()) + this.e + n9;
                    }
                    break;
                }
                case 5: {
                    int n11;
                    int n12 = n11 = n3 / (this.a.size() + 1);
                    for (int i = 0; i < this.a.size(); ++i) {
                        nArray[i] = n12;
                        n12 += (this.b == zb$Mode.a ? this.a.get(i).f() : this.a.get(i).g()) + this.e + n11;
                    }
                    break;
                }
            }
            return nArray;
        }

        private int a(zc zc2, int n) {
            boolean bl = this.b == zb$Mode.a || this.b == zb$Mode.c;
            int n2 = bl ? zc2.g() : zc2.f();
            switch (this.d.ordinal()) {
                case 0: {
                    return 0;
                }
                case 1: {
                    return n - n2;
                }
                case 2: {
                    return (n - n2) / 2;
                }
                case 3: {
                    return 0;
                }
            }
            return 0;
        }

        public static final class zb$Mode
        extends Enum<zb$Mode> {
            public static final /* enum */ zb$Mode a = new zb$Mode();
            public static final /* enum */ zb$Mode b = new zb$Mode();
            public static final /* enum */ zb$Mode c = new zb$Mode();
            public static final /* enum */ zb$Mode d = new zb$Mode();
            private static final /* synthetic */ zb$Mode[] e;

            public static zb$Mode[] values() {
                return (zb$Mode[])e.clone();
            }

            public static zb$Mode valueOf(String string) {
                return Enum.valueOf(zb$Mode.class, string);
            }

            private static /* synthetic */ zb$Mode[] a() {
                return new zb$Mode[]{a, b, c, d};
            }

            static {
                e = zb.a();
            }
        }

        public static final class zc$Mode
        extends Enum<zc$Mode> {
            public static final /* enum */ zc$Mode a = new zc$Mode();
            public static final /* enum */ zc$Mode b = new zc$Mode();
            public static final /* enum */ zc$Mode c = new zc$Mode();
            public static final /* enum */ zc$Mode d = new zc$Mode();
            public static final /* enum */ zc$Mode e = new zc$Mode();
            public static final /* enum */ zc$Mode f = new zc$Mode();
            private static final /* synthetic */ zc$Mode[] g;

            public static zc$Mode[] values() {
                return (zc$Mode[])g.clone();
            }

            public static zc$Mode valueOf(String string) {
                return Enum.valueOf(zc$Mode.class, string);
            }

            private static /* synthetic */ zc$Mode[] a() {
                return new zc$Mode[]{a, b, c, d, e, f};
            }

            static {
                g = zc.a();
            }
        }

        public static final class za$Align
        extends Enum<za$Align> {
            public static final /* enum */ za$Align a = new za$Align();
            public static final /* enum */ za$Align b = new za$Align();
            public static final /* enum */ za$Align c = new za$Align();
            public static final /* enum */ za$Align d = new za$Align();
            private static final /* synthetic */ za$Align[] e;

            public static za$Align[] values() {
                return (za$Align[])e.clone();
            }

            public static za$Align valueOf(String string) {
                return Enum.valueOf(za$Align.class, string);
            }

            private static /* synthetic */ za$Align[] a() {
                return new za$Align[]{a, b, c, d};
            }

            static {
                e = za.a();
            }
        }
    }

    public static class zc {
        private final int a;
        private final int b;
        private final Runnable c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h = 0;
        private int i = 1;

        public zc(int n, int n2, Runnable runnable) {
            this.a = n;
            this.b = n2;
            this.c = runnable;
        }

        public zc a(int n) {
            this.h = n;
            return this;
        }

        public zc b(int n) {
            this.i = n;
            return this;
        }

        public void a(int n, int n2, int n3, int n4) {
            this.d = n;
            this.e = n2;
            this.f = n3;
            this.g = n4;
        }

        public void a() {
            if (this.c != null) {
                this.c.run();
            }
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public int d() {
            return this.f;
        }

        public int e() {
            return this.g;
        }

        public int f() {
            return this.a;
        }

        public int g() {
            return this.b;
        }
    }

    public static class zd {
        private final List<ze> a = new ArrayList<ze>();
        private final int b;
        private final int c;
        private int d = 0;
        private int e = 0;
        private zg f = new zg(0);

        public zd(int n, int n2) {
            this.b = n;
            this.c = n2;
        }

        public zd a(int n) {
            this.d = n;
            this.e = n;
            return this;
        }

        public zd a(int n, int n2) {
            this.d = n;
            this.e = n2;
            return this;
        }

        public zd b(int n) {
            this.f = new zg(n);
            return this;
        }

        public zd a(ze ze2) {
            this.a.add(ze2);
            return this;
        }

        public void a(int n, int n2, int n3, int n4) {
            int n5 = n + this.f.d;
            int n6 = n2 + this.f.a;
            int n7 = n3 - this.f.d - this.f.b;
            int n8 = n4 - this.f.a - this.f.c;
            int n9 = (n7 - this.d * (this.b - 1)) / this.b;
            int n10 = (n8 - this.e * (this.c - 1)) / this.c;
            for (ze ze2 : this.a) {
                if (ze2.a >= this.b || ze2.b >= this.c) continue;
                int n11 = n5 + ze2.a * (n9 + this.d);
                int n12 = n6 + ze2.b * (n10 + this.e);
                int n13 = n9 + (n9 + this.d) * (ze2.h - 1);
                int n14 = n10 + (n10 + this.e) * (ze2.i - 1);
                ze2.a(n11, n12, n13, n14);
            }
        }

        public void a() {
            for (ze ze2 : this.a) {
                ze2.a();
            }
        }
    }

    public static class ze {
        private final int a;
        private final int b;
        private final Runnable c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h = 1;
        private int i = 1;

        public ze(int n, int n2, Runnable runnable) {
            this.a = n;
            this.b = n2;
            this.c = runnable;
        }

        public ze a(int n, int n2) {
            this.h = n;
            this.i = n2;
            return this;
        }

        public void a(int n, int n2, int n3, int n4) {
            this.d = n;
            this.e = n2;
            this.f = n3;
            this.g = n4;
        }

        public void a() {
            if (this.c != null) {
                this.c.run();
            }
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public int d() {
            return this.f;
        }

        public int e() {
            return this.g;
        }
    }

    public static class zi {
        public static int a(int n, int n2, int n3) {
            return n * n3 / n2;
        }

        public static int a(int n, float f) {
            return Math.round((float)n * f);
        }

        public static zj a(zj zj2, int n, int n2) {
            float f = (float)n / 1920.0f;
            float f2 = (float)n2 / 1080.0f;
            float f3 = Math.min(f, f2);
            return new zj(Math.round((float)zj2.a * f3), Math.round((float)zj2.b * f3));
        }

        public static int a(int n, int n2) {
            if (n2 <= 1366) {
                return n - 2;
            }
            if (n2 <= 1920) {
                return n;
            }
            if (n2 <= 2560) {
                return n + 2;
            }
            return n + 4;
        }
    }

    public record zf(int a, int b, int c, int d) {
        public zf(int n) {
            this(n, n, n, n);
        }

        public zf(int n, int n2) {
            this(n, n2, n, n2);
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{zf.class, "top;right;bottom;left", "a", "b", "c", "d"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zf.class, "top;right;bottom;left", "a", "b", "c", "d"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zf.class, "top;right;bottom;left", "a", "b", "c", "d"}, this, object);
        }
    }

    public record zg(int a, int b, int c, int d) {
        public zg(int n) {
            this(n, n, n, n);
        }

        public zg(int n, int n2) {
            this(n, n2, n, n2);
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{zg.class, "top;right;bottom;left", "a", "b", "c", "d"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zg.class, "top;right;bottom;left", "a", "b", "c", "d"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zg.class, "top;right;bottom;left", "a", "b", "c", "d"}, this, object);
        }
    }

    public record zj(int a, int b) {
        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{zj.class, "width;height", "a", "b"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zj.class, "width;height", "a", "b"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zj.class, "width;height", "a", "b"}, this, object);
        }
    }

    public record zh(int a, int b) {
        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{zh.class, "x;y", "a", "b"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zh.class, "x;y", "a", "b"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zh.class, "x;y", "a", "b"}, this, object);
        }
    }

    public static class za {
        public static final za a = new za(za$Horizontal.a, zb$Vertical.a);
        public static final za b = new za(za$Horizontal.b, zb$Vertical.a);
        public static final za c = new za(za$Horizontal.c, zb$Vertical.a);
        public static final za d = new za(za$Horizontal.a, zb$Vertical.b);
        public static final za e = new za(za$Horizontal.b, zb$Vertical.b);
        public static final za f = new za(za$Horizontal.c, zb$Vertical.b);
        public static final za g = new za(za$Horizontal.a, zb$Vertical.c);
        public static final za h = new za(za$Horizontal.b, zb$Vertical.c);
        public static final za i = new za(za$Horizontal.c, zb$Vertical.c);
        private final za$Horizontal j;
        private final zb$Vertical k;
        private final int l;
        private final int m;

        public za(za$Horizontal za2, zb$Vertical zb2) {
            this(za2, zb2, 0, 0);
        }

        public za(za$Horizontal za2, zb$Vertical zb2, int n, int n2) {
            this.j = za2;
            this.k = zb2;
            this.l = n;
            this.m = n2;
        }

        public zh a(int n, int n2, int n3, int n4) {
            return new zh(switch (this.j.ordinal()) {
                case 0 -> this.l;
                case 1 -> (n - n3) / 2 + this.l;
                case 2 -> n - n3 - this.l;
                default -> this.l;
            }, switch (this.k.ordinal()) {
                case 0 -> this.m;
                case 1 -> (n2 - n4) / 2 + this.m;
                case 2 -> n2 - n4 - this.m;
                default -> this.m;
            });
        }

        public static final class za$Horizontal
        extends Enum<za$Horizontal> {
            public static final /* enum */ za$Horizontal a = new za$Horizontal();
            public static final /* enum */ za$Horizontal b = new za$Horizontal();
            public static final /* enum */ za$Horizontal c = new za$Horizontal();
            private static final /* synthetic */ za$Horizontal[] d;

            public static za$Horizontal[] values() {
                return (za$Horizontal[])d.clone();
            }

            public static za$Horizontal valueOf(String string) {
                return Enum.valueOf(za$Horizontal.class, string);
            }

            private static /* synthetic */ za$Horizontal[] a() {
                return new za$Horizontal[]{a, b, c};
            }

            static {
                d = za.a();
            }
        }

        public static final class zb$Vertical
        extends Enum<zb$Vertical> {
            public static final /* enum */ zb$Vertical a = new zb$Vertical();
            public static final /* enum */ zb$Vertical b = new zb$Vertical();
            public static final /* enum */ zb$Vertical c = new zb$Vertical();
            private static final /* synthetic */ zb$Vertical[] d;

            public static zb$Vertical[] values() {
                return (zb$Vertical[])d.clone();
            }

            public static zb$Vertical valueOf(String string) {
                return Enum.valueOf(zb$Vertical.class, string);
            }

            private static /* synthetic */ zb$Vertical[] a() {
                return new zb$Vertical[]{a, b, c};
            }

            static {
                d = zb.a();
            }
        }
    }
}

