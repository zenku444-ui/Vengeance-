/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.q;

import com.vengeance.vengeanceclient.r.za;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class zb {
    private static final Map<za, Integer> a = new HashMap<za, Integer>();
    private static final int b = 12;
    private static boolean c = false;

    public static void a() {
        if (c) {
            return;
        }
        a.put(za.a, com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/sword.png"));
        a.put(za.b, com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/user.png"));
        a.put(za.c, com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/accessibility.png"));
        a.put(za.e, com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/harddrive.png"));
        a.put(za.d, com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/eye.png"));
        a.put(za.f, com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/computer.png"));
        c = true;
    }

    public static void a(za za2, float f, float f2, Color color) {
        Integer n;
        if (!c) {
            zb.a();
        }
        if ((n = a.get((Object)za2)) == null || n == -1) {
            return;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(n, f, f2, 12.0f, 12.0f, Color.WHITE);
    }

    public static int b() {
        return 12;
    }
}

