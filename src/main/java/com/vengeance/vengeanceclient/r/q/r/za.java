/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BowItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.BlockHitResult;

public final class za
extends zb {
    private final zc b = new zc("Key", 67, true);
    private final ze c = new ze("Delay", 50.0, 500.0, 150.0, 25.0);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Silent", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Switch Back", true);
    private final ze f = new ze("Switch Delay", 100.0, 1000.0, 250.0, 50.0);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Auto Bow", true);
    private final ze h = new ze("Bow Window", 500.0, 2000.0, 1000.0, 100.0);
    private boolean i;
    private boolean j;
    private int k = -1;
    private long l;
    private long m;
    private za$za n = za$za.a;

    public za() {
        super("Cart Key", "Places rail + TNT cart, auto switches to bow", -1, com.vengeance.vengeanceclient.r.za.e);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d() || za.a.currentScreen != null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        boolean bl2 = za.a.options.useKey.isPressed();
        long l = System.currentTimeMillis();
        if (bl && !this.i && this.n == za$za.a && this.n()) {
            this.k = za.a.player.getInventory().selectedSlot;
            this.n = za$za.b;
            this.l = l;
        }
        this.i = bl;
        switch (this.n.ordinal()) {
            case 0: {
                break;
            }
            case 1: {
                if (l - this.l < (long)this.c.a()) break;
                this.a(l);
                break;
            }
            case 2: {
                if (l - this.l < (long)this.c.a()) break;
                this.b(l);
                break;
            }
            case 3: {
                if (l - this.l < (long)this.f.a()) break;
                this.o();
                break;
            }
            case 4: {
                if (bl2) {
                    this.p();
                    break;
                }
                if (l - this.m < (long)this.h.a()) break;
                this.s();
                break;
            }
            case 5: {
                if (bl2 || !this.j) break;
                this.q();
            }
        }
    }

    private boolean n() {
        HitResult ItemStackParticleEffect = za.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof BlockHitResult)) {
            return false;
        }
        BlockHitResult class_39652 = (BlockHitResult)ItemStackParticleEffect;
        BlockPos blockPos = class_39652.getBlockPos().offset(class_39652.getSide());
        return za.a.world != null && za.a.player != null && za.a.player.getEntityPos().distanceTo(blockPos.toCenterPos()) <= 4.5 && za.a.world.getBlockState(blockPos).isAir() && this.a(Items.RAIL) && this.a(Items.TNT_MINECART);
    }

    private void a(long l) {
        if (this.b(Items.RAIL)) {
                this.n = za$za.c;
            this.l = l;
        } else {
            this.s();
        }
    }

    private void b(long l) {
        if (this.b(Items.TNT_MINECART)) {
            if (this.g.b()) {
                this.n = za$za.e;
                this.m = l;
            } else if (this.e.b() && this.k != -1) {
                this.n = za$za.d;
                this.l = l;
            } else {
                this.s();
            }
        } else {
            this.s();
        }
    }

    private void o() {
        if (this.k != -1) {
            za.a.player.getInventory().selectedSlot = this.k;
        }
        this.s();
    }

    private void p() {
        int n = this.r();
        if (n != -1) {
            za.a.player.getInventory().selectedSlot = n;
            this.n = za$za.f;
            this.j = true;
        } else {
            this.s();
        }
    }

    private void q() {
        this.j = false;
        if (this.e.b() && this.k != -1) {
            int n = this.k;
            this.s();
            new Thread(() -> {
                try {
                    Thread.sleep(100L);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                if (za.a.player != null) {
                    za.a.player.getInventory().selectedSlot = n;
                }
            }).start();
        } else {
            this.s();
        }
    }

    private boolean a(Item class_17922) {
        return this.c(class_17922) != -1;
    }

    private boolean b(Item class_17922) {
        int n = this.c(class_17922);
        if (n == -1) {
            return false;
        }
        if (this.d.b()) {
            int n2 = za.a.player.getInventory().selectedSlot;
            za.a.player.getInventory().selectedSlot = n;
            ((MinecraftClientAccessor)a).invokeDoItemUse();
            za.a.player.getInventory().selectedSlot = n2;
        } else {
            za.a.player.getInventory().selectedSlot = n;
            ((MinecraftClientAccessor)a).invokeDoItemUse();
        }
        return true;
    }

    private int c(Item class_17922) {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = za.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922) continue;
            return i;
        }
        return -1;
    }

    private int r() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = za.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || !(class_17992.getItem() instanceof BowItem)) continue;
            return i;
        }
        return -1;
    }

    private void s() {
        this.n = za$za.a;
        this.k = -1;
        this.j = false;
    }

    @Override
    public void b() {
        this.i = false;
        this.s();
        super.b();
    }

    @Override
    public void c() {
        this.s();
        super.c();
    }

    private enum za$za {
        a, b, c, d, e, f
    }
}

