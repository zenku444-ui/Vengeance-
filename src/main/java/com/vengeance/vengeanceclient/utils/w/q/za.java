/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package com.vengeance.vengeanceclient.utils.w.q;

import com.vengeance.vengeanceclient.VengeanceClient;
import java.awt.Font;
import java.io.InputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class za {
    private final Map<FontKey, com.vengeance.vengeanceclient.utils.w.q.p.za> a = new HashMap<FontKey, com.vengeance.vengeanceclient.utils.w.q.p.za>();

    public void a() {
        for (zb zb2 : zb.values()) {
            for (int i = 4; i <= 32; ++i) {
                this.a.put(new FontKey(i, zb2), this.a((float)i, zb2.a()));
            }
        }
    }

    public com.vengeance.vengeanceclient.utils.w.q.p.za a(float f, String string) {
        com.vengeance.vengeanceclient.utils.w.q.p.za za2;
        block9: {
            String string2 = string.endsWith(".ttf") || string.endsWith(".otf") ? string : string + ".ttf";
            String string3 = "assets/vengeance-client/fonts/" + string2;
            InputStream inputStream = VengeanceClient.class.getClassLoader().getResourceAsStream(string3);
            try {
                if (inputStream == null) {
                    throw new IllegalStateException("Missing font resource: " + string3);
                }
                Font[] fontArray = Font.createFonts(Objects.requireNonNull(inputStream));
                za2 = new com.vengeance.vengeanceclient.utils.w.q.p.za(fontArray, f, 256, 2);
                if (inputStream == null) break block9;
            }
            catch (Throwable throwable) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                }
                throw new IllegalStateException("Unable to load font: " + string3, throwable);
            }
            try {
                inputStream.close();
            }
            catch (IOException exception) {
                throw new IllegalStateException("Unable to close font resource: " + string3, exception);
            }
        }
        return za2;
    }

    public com.vengeance.vengeanceclient.utils.w.q.p.za a(int n, zb zb2) {
        return this.a.computeIfAbsent(new FontKey(n, zb2), za2 -> this.a((float)n, zb2.a()));
    }

    public enum zb {
        a("Inter"),
        b("JetbrainsMono"),
        c("Poppins-Medium");
        private final String d;

        private zb(String string2) {
            this.d = string2;
        }

        public String a() {
            return this.d;
        }

    }

    private record FontKey(int a, zb b) {
        @Override
        @NotNull
        public String toString() {
            return "FontKey[size=" + this.a + ", type=" + String.valueOf((Object)this.b) + "]";
        }

    }
}

