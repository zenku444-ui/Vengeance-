/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public final class zl
extends zb {
    private static final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Blocks Only", true);
    private static final ze c = new ze("Delay", 0.0, 4.0, 0.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb d = new com.vengeance.vengeanceclient.utils.s.zb();

    public zl() {
        super("Fast Place", "Bypasses item use cooldown for faster block placement", -1, za.b);
        this.a(b, c);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        ItemStack class_17992;
        if (this.d()) {
            return;
        }
        if (b.b() && ((class_17992 = zl.a.player.getMainHandStack()).isEmpty() || !(class_17992.getItem() instanceof BlockItem))) {
            return;
        }
        long l = (long)c.a() * 50L;
        if (this.d.a(l, true)) {
            ((MinecraftClientAccessor)a).setItemUseCooldown(0);
        }
    }

    @Override
    public void b() {
        this.d.a();
        super.b();
    }

    @Override
    public void c() {
        this.d.a();
        if (zl.a.player != null) {
            ((MinecraftClientAccessor)a).setItemUseCooldown(4);
        }
        super.c();
    }
}

