/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class zj
extends zb {
    private final zc b = new zc("Hotswap Key", 71, false);
    private final ze c = new ze("Swap Delay (MS)", 50.0, 500.0, 150.0, 25.0);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Auto Switch Back", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Silent Swap", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Toggle Mode", true);
    private final com.vengeance.vengeanceclient.utils.s.zb g = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean h = false;
    private boolean i = false;
    private int j = -1;
    private ItemStack k = ItemStack.EMPTY;
    private boolean l = true;
    private za m = za.a;

    public zj() {
        super("Elytra HotSwap", "Quickly swap to elytra and equip it, or swap back to chestplate", -1, com.vengeance.vengeanceclient.r.za.a);
        this.a(this.b, this.c, this.d, this.e, this.f);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.h) {
            this.n();
        }
        this.h = bl;
        if (!this.i) {
            return;
        }
        if (!this.g.a(this.c.a())) {
            return;
        }
        switch (this.m.ordinal()) {
            case 1: {
                this.o();
                break;
            }
            case 2: {
                this.p();
                break;
            }
            case 3: {
                this.s();
            }
        }
    }

    private void n() {
        if (this.i) {
            return;
        }
        boolean bl = this.w();
        if (this.f.b() && bl) {
            this.l = false;
            int n = this.v();
            if (n == -1 && this.k.isEmpty()) {
                return;
            }
        } else {
            this.l = true;
            int n = this.u();
            if (n == -1) {
                return;
            }
            if (!bl) {
                this.k = zj.a.player.getEquippedStack(EquipmentSlot.CHEST).copy();
            }
        }
        this.i = true;
        this.j = zj.a.player.getInventory().selectedSlot;
        this.m = za.b;
        this.g.a();
    }

    private void o() {
        int n = this.l ? this.u() : this.v();
        if (n == -1) {
            if (!this.l && !this.k.isEmpty()) {
                this.m = za.c;
                this.g.a();
                return;
            }
            this.t();
            return;
        }
        if (!this.e.b()) {
            zj.a.player.getInventory().selectedSlot = n;
        }
        this.m = za.c;
        this.g.a();
    }

    private void p() {
        if (this.l) {
            this.q();
        } else {
            this.r();
        }
        if (this.d.b() && !this.e.b()) {
            this.m = za.d;
        } else {
            this.t();
        }
        this.g.a();
    }

    private void q() {
        int n;
        int n2 = n = this.e.b() ? this.u() : zj.a.player.getInventory().selectedSlot;
        if (n == -1) {
            this.t();
            return;
        }
        ItemStack class_17992 = zj.a.player.getInventory().getStack(n);
        if (class_17992.isEmpty() || class_17992.getItem() != Items.ELYTRA) {
            this.t();
            return;
        }
        if (this.e.b()) {
            int n3 = zj.a.player.getInventory().selectedSlot;
            zj.a.player.getInventory().selectedSlot = n;
            if (zj.a.interactionManager != null) {
                ((MinecraftClientAccessor)a).invokeDoItemUse();
            }
            zj.a.player.getInventory().selectedSlot = n3;
        } else if (zj.a.interactionManager != null) {
            ((MinecraftClientAccessor)a).invokeDoItemUse();
        }
    }

    private void r() {
        ItemStack class_17992;
        int n = this.v();
        if (n != -1 && !(class_17992 = zj.a.player.getInventory().getStack(n)).isEmpty() && this.a(class_17992)) {
            if (this.e.b()) {
                int n2 = zj.a.player.getInventory().selectedSlot;
                zj.a.player.getInventory().selectedSlot = n;
                if (zj.a.interactionManager != null) {
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                }
                zj.a.player.getInventory().selectedSlot = n2;
            } else if (zj.a.interactionManager != null) {
                ((MinecraftClientAccessor)a).invokeDoItemUse();
            }
            return;
        }
        if (!this.k.isEmpty()) {
            zj.a.player.getInventory().setStack(36 + zj.a.player.getInventory().selectedSlot, this.k.copy());
            if (zj.a.interactionManager != null) {
                ((MinecraftClientAccessor)a).invokeDoItemUse();
            }
            this.k = ItemStack.EMPTY;
        }
    }

    private void s() {
        if (this.j != -1) {
            zj.a.player.getInventory().selectedSlot = this.j;
        }
        this.t();
    }

    private void t() {
        this.i = false;
        this.m = za.a;
        this.j = -1;
        this.l = true;
    }

    private int u() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zj.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != Items.ELYTRA) continue;
            return i;
        }
        return -1;
    }

    private int v() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zj.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || !this.a(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private boolean a(ItemStack class_17992) {
        if (class_17992.isEmpty()) {
            return false;
        }
        return class_17992.getItem() == Items.DIAMOND_CHESTPLATE || class_17992.getItem() == Items.IRON_CHESTPLATE || class_17992.getItem() == Items.GOLDEN_CHESTPLATE || class_17992.getItem() == Items.LEATHER_CHESTPLATE || class_17992.getItem() == Items.CHAINMAIL_CHESTPLATE || class_17992.getItem() == Items.NETHERITE_CHESTPLATE;
    }

    private boolean w() {
        ItemStack class_17992 = zj.a.player.getEquippedStack(EquipmentSlot.CHEST);
        return !class_17992.isEmpty() && class_17992.getItem() == Items.ELYTRA;
    }

    @Override
    public void b() {
        this.h = false;
        this.i = false;
        this.j = -1;
        this.k = ItemStack.EMPTY;
        this.l = true;
        this.m = za.a;
        super.b();
    }

    @Override
    public void c() {
        if (this.i) {
            this.t();
        }
        this.k = ItemStack.EMPTY;
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }

    @Override
    public void a(int n) {
    }

    private static final class za
    extends Enum<za> {
        public static final /* enum */ za a = new za();
        public static final /* enum */ za b = new za();
        public static final /* enum */ za c = new za();
        public static final /* enum */ za d = new za();
        private static final /* synthetic */ za[] e;

        public static za[] values() {
            return (za[])e.clone();
        }

        public static za valueOf(String string) {
            return Enum.valueOf(za.class, string);
        }

        private static /* synthetic */ za[] a() {
            return new za[]{a, b, c, d};
        }

        static {
            e = za.a();
        }
    }
}

