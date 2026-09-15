/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class zj
extends zb {
    private static final ze b = new ze("Chance %", 1.0, 100.0, 75.0, 1.0);

    public zj() {
        super("Fast Exp", "Bypasses item use cooldown for faster experience bottle throwing", -1, za.b);
        this.a(new zg[]{b});
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        if (zj.a.currentScreen != null) {
            return;
        }
        ItemStack class_17992 = zj.a.player.getMainHandStack();
        if (class_17992.isEmpty() || class_17992.getItem() != Items.EXPERIENCE_BOTTLE) {
            return;
        }
        if (!com.vengeance.vengeanceclient.utils.r.za.b(1)) {
            return;
        }
        if (b.f() >= Math.random() * 100.0) {
            ((MinecraftClientAccessor)a).invokeDoItemUse();
        }
    }
}

