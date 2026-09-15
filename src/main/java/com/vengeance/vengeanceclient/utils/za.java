/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.q.p.zb;
import java.util.Timer;
import java.util.TimerTask;

public class za {
    private static final za a = new za();
    private static final long b = 1000L;
    private Timer c = new Timer("AutoSave-Timer", true);
    private TimerTask d;

    private za() {
    }

    public static za a() {
        return a;
    }

    public void b() {
        try {
            if (!zb.ah()) {
                return;
            }
            if (VengeanceClient.INSTANCE == null || VengeanceClient.INSTANCE.getProfileManager() == null) {
                return;
            }
            if (this.d != null) {
                this.d.cancel();
            }
            this.d = new TimerTask(){

                @Override
                public void run() {
                    try {
                        VengeanceClient.INSTANCE.getProfileManager().a("default", true);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            };
            this.c.schedule(this.d, 1000L);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.cancel();
        }
    }
}

