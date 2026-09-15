/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.vengeance.vengeanceclient.mixin.HandledScreenAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zf;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public final class zd
extends zb {
    public static final zf b = new zf("Delay (MS)", 1.0, 1000.0, 200.0, 400.0, 0.5);
    public static final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Ignore Offhand", false);
    private final ze e = new ze("Base Delay", 50.0, 1000.0, 200.0, 1.0);
    private final ze f = new ze("Variation", 10.0, 1000.0, 150.0, 1.0);
    private final ze g = new ze("SD Threshold", 1.0, 500.0, 80.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb h = new com.vengeance.vengeanceclient.utils.s.zb();
    private final Random i = new Random();
    private final List<Long> j = new ArrayList<Long>();
    private final List<Double> k = new ArrayList<Double>();
    private int l = 0;
    private boolean m = false;

    public zd() {
        super("Hover Totem", "Puts a totem in your offhand and hotbar once hovered", -1, za.e);
        this.a(b, c, this.e, this.f, this.g);
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.s.zd zd2) {
        if (this.d()) {
            return;
        }
        this.o();
        if (this.m && this.n() && zd.a.currentScreen instanceof InventoryScreen) {
            this.m = false;
            zd.a.player.closeHandledScreen();
        }
    }

    private boolean n() {
        if (this.d()) {
            return true;
        }
        ItemStack class_17992 = zd.a.player.getOffHandStack();
        boolean bl = class_17992.getItem() == Items.TOTEM_OF_UNDYING || c.b();
        boolean bl2 = this.p();
        return bl && bl2;
    }

    private void o() {
        boolean bl;
        if (this.d()) {
            return;
        }
        Screen class_4372 = zd.a.currentScreen;
        if (!(class_4372 instanceof InventoryScreen)) {
            return;
        }
        InventoryScreen RealmsConnection = (InventoryScreen)class_4372;
        class_4372 = ((HandledScreenAccessor)RealmsConnection).getFocusedSlot();
        if (class_4372 == null) {
            return;
        }
        ItemStack class_17992 = class_4372.getStack();
        if (class_17992.getItem() != Items.TOTEM_OF_UNDYING) {
            return;
        }
        if (class_4372.getIndex() < 9) {
            return;
        }
        ItemStack class_17993 = zd.a.player.getOffHandStack();
        boolean bl2 = class_17993.isEmpty() || class_17993.getItem() != Items.TOTEM_OF_UNDYING && !c.b();
        boolean bl3 = bl = !this.p();
        if (!bl2 && !bl) {
            return;
        }
        long l = this.q();
        if (this.h.a(l, true)) {
            assert (zd.a.player != null);
            assert (zd.a.interactionManager != null);
            if (bl2) {
                zd.a.interactionManager.clickSlot(zd.a.player.currentScreenHandler.syncId, class_4372.getIndex(), 40, SlotActionType.SWAP, (PlayerEntity)zd.a.player);
            } else {
                zd.a.interactionManager.clickSlot(zd.a.player.currentScreenHandler.syncId, class_4372.getIndex(), 0, SlotActionType.QUICK_MOVE, (PlayerEntity)zd.a.player);
            }
        }
    }

    private boolean p() {
        if (this.d()) {
            return false;
        }
        return zd.a.player.getInventory().main.subList(0, 9).stream().anyMatch(class_17992 -> class_17992.getItem() == Items.TOTEM_OF_UNDYING);
    }

    private long q() {
        double d;
        ++this.l;
        long l = this.e.a();
        int n = this.f.a();
        double d2 = this.g.f();
        long l2 = (long)((this.i.nextDouble() - 0.5) * (double)n * 2.0);
        l2 += System.currentTimeMillis() % 97L - 48L;
        if (this.l % (3 + this.i.nextInt(3)) == 0) {
            l2 += this.i.nextBoolean() ? (long)this.i.nextInt(n) : (long)(-this.i.nextInt(n / 2));
        }
        double d3 = d = this.k.isEmpty() ? 0.0 : (Double)this.k.getLast();
        if (d < d2 * 0.75) {
            l2 += (long)((this.i.nextDouble() - 0.5) * ((double)n * 1.5));
        }
        long l3 = Math.max(80L, Math.min(2000L, l + l2));
        this.j.add(l3);
        if (this.j.size() > 10) {
            this.j.removeFirst();
        }
        this.r();
        return l3;
    }

    private double a(List<Long> list) {
        return list.stream().mapToDouble(Long::doubleValue).average().orElse(0.0);
    }

    private double b(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    private void r() {
        if (this.j.size() < 2) {
            return;
        }
        double d = this.a(this.j);
        double d2 = 0.0;
        for (long l : this.j) {
            d2 += Math.pow((double)l - d, 2.0);
        }
        double d3 = Math.sqrt(d2 /= (double)this.j.size());
        this.k.add(d3);
        if (this.k.size() > 10) {
            this.k.removeFirst();
        }
    }

    @Override
    public void b() {
        this.h.a();
        super.b();
    }

    @Override
    public void c() {
        this.h.a();
        this.m = false;
        super.c();
    }
}

