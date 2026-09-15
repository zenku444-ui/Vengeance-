/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class za {
    private static final Map<String, za$Animation> a = new ConcurrentHashMap<String, za$Animation>();

    public static float a(String string, float f, long l, zd zd2) {
        za$Animation za2 = a.get(string);
        if (za2 == null) {
            za2 = new za$Animation(0.0f, f, l, zd2);
            a.put(string, za2);
        } else if (za2.d != f) {
            za2.a(f);
        }
        return za2.a();
    }

    public static float a(String string, float f, long l) {
        return za.a(string, f, l, zc.f);
    }

    public static boolean a(String string) {
        za$Animation za2 = a.get(string);
        return za2 == null || za2.b();
    }

    public static void b(String string) {
        a.remove(string);
    }

    public static void a() {
        a.clear();
    }

    public static float a(String string, float f) {
        float f2 = (float)System.currentTimeMillis() * 0.001f * f;
        return 0.5f + 0.5f * (float)Math.sin(f2);
    }

    public static float a(String string, float f, float f2, float f3) {
        float f4 = (float)System.currentTimeMillis() * 0.001f * f + f3;
        return f2 * (float)Math.sin(f4);
    }

    private za() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static class za$Animation {
        private final long a;
        private final zd b;
        private float c;
        private float d;
        private float e;
        private long f;
        private boolean g;
        private Runnable h;

        public za$Animation(float f, float f2, long l, zd zd2) {
            this.c = f;
            this.d = f2;
            this.e = f;
            this.f = System.currentTimeMillis();
            this.a = l;
            this.b = zd2;
            this.g = false;
        }

        public float a() {
            if (this.g) {
                return this.e;
            }
            long l = System.currentTimeMillis() - this.f;
            float f = Math.min(1.0f, (float)l / (float)this.a);
            if (f >= 1.0f) {
                this.e = this.d;
                this.g = true;
                if (this.h != null) {
                    this.h.run();
                }
            } else {
                float f2 = this.b.apply(f);
                this.e = this.c + (this.d - this.c) * f2;
            }
            return this.e;
        }

        public boolean b() {
            return this.g;
        }

        public void a(float f) {
            this.c = this.e;
            this.d = f;
            this.f = System.currentTimeMillis();
            this.g = false;
        }
    }

    @FunctionalInterface
    public static interface zd {
        public float apply(float var1);
    }

    public static class zc {
        public static final zd a = f -> f;
        public static final zd b = f -> f * f;
        public static final zd c = f -> 1.0f - (1.0f - f) * (1.0f - f);
        public static final zd d = f -> f < 0.5f ? 2.0f * f * f : 1.0f - 2.0f * (1.0f - f) * (1.0f - f);
        public static final zd e = f -> f * f * f;
        public static final zd f = f -> 1.0f - (float)Math.pow(1.0f - f, 3.0);
        public static final zd g = f -> f < 0.5f ? 4.0f * f * f * f : 1.0f - (float)Math.pow(-2.0f * f + 2.0f, 3.0) / 2.0f;
        public static final zd h = f -> f * f * f * f;
        public static final zd i = f -> 1.0f - (float)Math.pow(1.0f - f, 4.0);
        public static final zd j = f -> f < 0.5f ? 8.0f * f * f * f * f : 1.0f - (float)Math.pow(-2.0f * f + 2.0f, 4.0) / 2.0f;
        public static final zd k = f -> 1.0f - (float)Math.cos((double)f * Math.PI / 2.0);
        public static final zd l = f -> (float)Math.sin((double)f * Math.PI / 2.0);
        public static final zd m = f -> -((float)Math.cos(Math.PI * (double)f) - 1.0f) / 2.0f;
        public static final zd n = f -> f == 0.0f ? 0.0f : (float)Math.pow(2.0, 10.0f * (f - 1.0f));
        public static final zd o = f -> f == 1.0f ? 1.0f : 1.0f - (float)Math.pow(2.0, -10.0f * f);
        public static final zd p = f -> {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return f < 0.5f ? (float)Math.pow(2.0, 20.0f * f - 10.0f) / 2.0f : (2.0f - (float)Math.pow(2.0, -20.0f * f + 10.0f)) / 2.0f;
        };
        public static final zd q = f -> 1.0f - (float)Math.sqrt(1.0f - f * f);
        public static final zd r = f -> (float)Math.sqrt(1.0f - (f - 1.0f) * (f - 1.0f));
        public static final zd s = f -> f < 0.5f ? (1.0f - (float)Math.sqrt(1.0f - 4.0f * f * f)) / 2.0f : ((float)Math.sqrt(1.0f - (-2.0f * f + 2.0f) * (-2.0f * f + 2.0f)) + 1.0f) / 2.0f;
        public static final zd t = f -> {
            float f2 = 1.70158f;
            float f3 = f2 + 1.0f;
            return f3 * f * f * f - f2 * f * f;
        };
        public static final zd u = f -> {
            float f2 = 1.70158f;
            float f3 = f2 + 1.0f;
            return 1.0f + f3 * (float)Math.pow(f - 1.0f, 3.0) + f2 * (float)Math.pow(f - 1.0f, 2.0);
        };
        public static final zd v = f -> {
            float f2 = 1.70158f;
            float f3 = f2 * 1.525f;
            return f < 0.5f ? (float)Math.pow(2.0f * f, 2.0) * ((f3 + 1.0f) * 2.0f * f - f3) / 2.0f : ((float)Math.pow(2.0f * f - 2.0f, 2.0) * ((f3 + 1.0f) * (f * 2.0f - 2.0f) + f3) + 2.0f) / 2.0f;
        };
        public static final zd w = f -> {
            float f2 = 2.0943952f;
            return f == 0.0f ? 0.0f : (f == 1.0f ? 1.0f : -((float)Math.pow(2.0, 10.0f * f - 10.0f)) * (float)Math.sin((f * 10.0f - 10.75f) * f2));
        };
        public static final zd x = f -> {
            float f2 = 2.0943952f;
            return f == 0.0f ? 0.0f : (f == 1.0f ? 1.0f : (float)Math.pow(2.0, -10.0f * f) * (float)Math.sin((f * 10.0f - 0.75f) * f2) + 1.0f);
        };
        public static final zd y = f -> {
            float f2 = 1.3962635f;
            return f == 0.0f ? 0.0f : (f == 1.0f ? 1.0f : (f < 0.5f ? -((float)Math.pow(2.0, 20.0f * f - 10.0f) * (float)Math.sin((20.0f * f - 11.125f) * f2)) / 2.0f : (float)Math.pow(2.0, -20.0f * f + 10.0f) * (float)Math.sin((20.0f * f - 11.125f) * f2) / 2.0f + 1.0f));
        };
        public static final zd z = f -> {
            float f2 = 7.5625f;
            float f3 = 2.75f;
            if (f < 1.0f / f3) {
                return f2 * f * f;
            }
            if (f < 2.0f / f3) {
                return f2 * (f -= 1.5f / f3) * f + 0.75f;
            }
            if ((double)f < 2.5 / (double)f3) {
                return f2 * (f -= 2.25f / f3) * f + 0.9375f;
            }
            return f2 * (f -= 2.625f / f3) * f + 0.984375f;
        };
        public static final zd aa = f -> 1.0f - z.apply(1.0f - f);
        public static final zd ab = f -> f < 0.5f ? (1.0f - z.apply(1.0f - 2.0f * f)) / 2.0f : (1.0f + z.apply(2.0f * f - 1.0f)) / 2.0f;
    }

    public record ze(float a, float b, long c, long d, zd e) {
        public ze(float f, float f2, long l) {
            this(f, f2, l, 0L, zc.f);
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{ze.class, "startValue;targetValue;duration;delay;easing", "a", "b", "c", "d", "e"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ze.class, "startValue;targetValue;duration;delay;easing", "a", "b", "c", "d", "e"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ze.class, "startValue;targetValue;duration;delay;easing", "a", "b", "c", "d", "e"}, this, object);
        }
    }

    public static class zb {
        private final String a;
        private final ze[] b;
        private int c;
        private long d;
        private boolean e;

        public zb(String string, ze ... zeArray) {
            this.a = string;
            this.b = zeArray;
            this.c = 0;
            this.d = System.currentTimeMillis();
            this.e = false;
        }

        public float a() {
            if (this.e) {
                return this.b[this.b.length - 1].b;
            }
            long l = System.currentTimeMillis() - this.d;
            long l2 = 0L;
            for (int i = 0; i < this.c; ++i) {
                l2 += this.b[i].d + this.b[i].c;
            }
            if (l < l2 + this.b[this.c].d) {
                return this.c == 0 ? this.b[0].a : this.b[this.c - 1].b;
            }
            String string = this.a + "_step_" + this.c;
            float f = za.a(string, this.b[this.c].b, this.b[this.c].c, this.b[this.c].e);
            if (za.a(string)) {
                ++this.c;
                if (this.c >= this.b.length) {
                    this.e = true;
                }
            }
            return f;
        }

        public boolean b() {
            return this.e;
        }

        public void c() {
            this.c = 0;
            this.d = System.currentTimeMillis();
            this.e = false;
            for (int i = 0; i < this.b.length; ++i) {
                za.b(this.a + "_step_" + i);
            }
        }
    }
}

