/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.p;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;

public class za {
    @EventHandler
    public void onMouseClick(com.vengeance.vengeanceclient.p.p.q.zb zb2) {
        if (zb2.b() == 1) {
            int n = zb2.a();
            for (zb zb3 : VengeanceClient.INSTANCE.getModuleManager().b()) {
                boolean bl;
                int n2 = zb3.e();
                if (n2 == -1 || n2 == 0 || !(bl = n2 == n || n2 == -(n + 1) || n2 == -100 - n)) continue;
                zb3.a();
                break;
            }
        }
    }
}

