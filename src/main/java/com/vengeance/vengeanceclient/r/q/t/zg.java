/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.util.hit.HitResult;
import net.minecraft.block.BlockState;
import net.minecraft.util.hit.BlockHitResult;

public final class zg
extends zb {
    private static final ze b = new ze("Delay", 0.0, 100.0, 5.0, 1.0);
    private static final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Return To Previous", true);
    private static final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Only When Sneaking", false);
    private static final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Prevent Low Durability", true);
    private static final ze f = new ze("Durability Threshold", 1.0, 100.0, 10.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb g = new com.vengeance.vengeanceclient.utils.s.zb();
    private int h = -1;

    public zg() {
        super("Auto Tool", "Automatically switches to the best tool", -1, za.b);
        this.a(b, c, d, e, f);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d()) {
            return;
        }
        if (d.b() && !zg.a.player.isSneaking()) {
            return;
        }
        if (!zg.a.options.attackKey.isPressed()) {
            if (c.b() && this.h != -1) {
                zg.a.player.getInventory().selectedSlot = this.h;
                this.h = -1;
            }
            return;
        }
        HitResult ItemStackParticleEffect = zg.a.crosshairTarget;
        if (ItemStackParticleEffect == null) {
            return;
        }
        if (ItemStackParticleEffect.getType() == HitResult.class_240.BLOCK) {
            this.a((BlockHitResult)ItemStackParticleEffect);
        }
    }

    private void a(BlockHitResult class_39652) {
        BlockState class_26802 = zg.a.world.getBlockState(class_39652.getBlockPos());
        if (class_26802.getHardness((BlockView)zg.a.world, class_39652.getBlockPos()) < 0.0f) {
            return;
        }
        int n = this.a(class_26802);
        if (n != -1 && n != zg.a.player.getInventory().selectedSlot) {
            this.b(n);
        }
    }

    private void b(int n) {
        if (!this.g.a(b.a())) {
            return;
        }
        if (this.h == -1) {
            this.h = zg.a.player.getInventory().selectedSlot;
        }
        zg.a.player.getInventory().selectedSlot = n;
        this.g.a();
    }

    private int a(BlockState class_26802) {
        int n = -1;
        float f = 0.0f;
        for (int i = 0; i < 9; ++i) {
            float f2;
            ItemStack class_17992 = zg.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || !this.a(class_17992, class_26802) || e.b() && this.b(class_17992) || !((f2 = this.b(class_17992, class_26802)) > f)) continue;
            f = f2;
            n = i;
        }
        return n;
    }

    private boolean a(ItemStack class_17992, BlockState class_26802) {
        return class_17992.isSuitableFor(class_26802) || class_17992.getMiningSpeedMultiplier(class_26802) > 1.0f;
    }

    private float b(ItemStack class_17992, BlockState class_26802) {
        float f = class_17992.getMiningSpeedMultiplier(class_26802);
        float f2 = this.a(class_17992);
        return f * f2;
    }

    private float a(ItemStack class_17992) {
        String string = class_17992.getItem().toString().toLowerCase();
        if (string.contains("netherite")) {
            return 6.0f;
        }
        if (string.contains("diamond")) {
            return 5.0f;
        }
        if (string.contains("iron")) {
            return 4.0f;
        }
        if (string.contains("golden")) {
            return 3.5f;
        }
        if (string.contains("stone")) {
            return 2.0f;
        }
        if (string.contains("wooden")) {
            return 1.5f;
        }
        return 1.0f;
    }

    private boolean b(ItemStack class_17992) {
        if (class_17992.getMaxDamage() <= 0) {
            return false;
        }
        int n = class_17992.getMaxDamage() - class_17992.getDamage();
        return n <= f.a();
    }

    @Override
    public void b() {
        this.g.a();
        this.h = -1;
        super.b();
    }

    @Override
    public void c() {
        if (c.b() && this.h != -1) {
            zg.a.player.getInventory().selectedSlot = this.h;
        }
        this.h = -1;
        super.c();
    }
}

