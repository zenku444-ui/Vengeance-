/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.decoration.EndCrystalEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.t.zd;
import java.util.List;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

public final class zo
extends zb {
    private final zc b = new zc("Crystal Key", 3, false);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Anti Suicide", true);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Anti Weakness", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Stop On Kill", false);
    private final ze f = new ze("Place Chance (%)", 0.0, 100.0, 100.0, 1.0);
    private final ze g = new ze("Break Chance (%)", 0.0, 100.0, 100.0, 1.0);
    private final ze h = new ze("Min Break Delay (MS)", 10.0, 500.0, 50.0, 1.0);
    private final ze i = new ze("Max Break Delay (MS)", 10.0, 500.0, 100.0, 1.0);
    private final ze j = new ze("Min Place Delay (MS)", 10.0, 500.0, 30.0, 1.0);
    private final ze k = new ze("Max Place Delay (MS)", 10.0, 500.0, 80.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb l = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb m = new com.vengeance.vengeanceclient.utils.s.zb();
    private final Random n = new Random();
    private boolean o = false;
    private boolean p = false;
    private int q = -1;
    private boolean r = false;
    private long s;
    private long t;

    public zo() {
        super("Key Crystal", "Automatically places and explodes crystals and obsidian for PvP", -1, za.a);
        this.a(this.b, this.f, this.g, this.e, this.h, this.i, this.j, this.k, this.c, this.d);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        boolean bl;
        if (this.d() || zo.a.currentScreen != null) {
            return;
        }
        if (this.h.b() >= this.i.b()) {
            this.h.a(this.i.b() - 1.0f);
        }
        if (this.j.b() >= this.k.b()) {
            this.j.a(this.k.b() - 1.0f);
        }
        if ((bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e())) && !this.o) {
            this.n();
        } else if (!bl && this.o) {
            this.o();
        }
        this.o = bl;
        if (this.p) {
            this.q();
        }
    }

    private void n() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.q = zo.a.player.getInventory().selectedSlot;
        this.r = false;
        this.p();
    }

    private void o() {
        if (!this.p) {
            return;
        }
        if (this.q != -1) {
            zo.a.player.getInventory().selectedSlot = this.q;
        }
        this.p = false;
        this.q = -1;
        this.r = false;
        this.p();
    }

    private void p() {
        this.l.a();
        this.m.a();
        int n = this.h.a();
        int n2 = this.i.a();
        int n3 = this.j.a();
        int n4 = this.k.a();
        if (n >= n2) {
            n2 = n + 1;
            this.i.a(n2);
        }
        if (n3 >= n4) {
            n4 = n3 + 1;
            this.k.a(n4);
        }
        this.s = n + this.n.nextInt(n2 - n);
        this.t = n3 + this.n.nextInt(n4 - n3);
    }

    private void q() {
        Entity class_12972;
        EntityHitResult class_39662;
        if (this.c.b() && !zo.a.player.isOnGround()) {
            return;
        }
        if (this.e.b() && this.r()) {
            return;
        }
        int n = this.n.nextInt(100) + 1;
        HitResult ItemStackParticleEffect = zo.a.crosshairTarget;
        if (ItemStackParticleEffect instanceof EntityHitResult) {
            class_39662 = (EntityHitResult)ItemStackParticleEffect;
            if (this.l.a(this.s) && (class_12972 = class_39662.getEntity()) instanceof EndCrystalEntity) {
                ItemStackParticleEffect = (EndCrystalEntity)class_12972;
                if (n <= this.g.a()) {
                    if (zo.a.player.getEntityPos().distanceTo(ItemStackParticleEffect.getEntityPos()) <= 6.0) {
                        if (this.d.b() && zo.a.player.hasStatusEffect(StatusEffects.WEAKNESS)) {
                            zd.b();
                        }
                        ((MinecraftClientAccessor)a).invokeDoAttack();
                        this.l.a();
                        this.s = this.n.nextLong(this.h.a(), this.i.a());
                    }
                    return;
                }
            }
        }
        if ((ItemStackParticleEffect = zo.a.crosshairTarget) instanceof BlockHitResult) {
            class_39662 = (BlockHitResult)ItemStackParticleEffect;
            if (this.m.a(this.t)) {
                BlockPos class_23382;
                ItemStackParticleEffect = class_39662.getBlockPos();
                class_12972 = ItemStackParticleEffect.offset(class_39662.getSide());
                if (this.b((BlockPos)ItemStackParticleEffect) && this.c((BlockPos)class_12972) && n <= this.f.a()) {
                    if (this.a(Items.END_CRYSTAL)) {
                        zd.a(Items.END_CRYSTAL);
                        ((MinecraftClientAccessor)a).invokeDoItemUse();
                        this.m.a();
                        this.t = this.n.nextLong(this.j.a(), this.k.a());
                    }
                } else if (this.a((BlockPos)class_12972) && !this.r && !zo.a.world.getBlockState(class_23382 = class_12972.down()).isAir() && this.a(Items.OBSIDIAN)) {
                    zd.a(Items.OBSIDIAN);
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                    this.r = true;
                    this.m.a();
                    this.t = this.n.nextLong(this.j.a(), this.k.a());
                }
            }
        }
    }

    private boolean a(Item class_17922) {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zo.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922) continue;
            return true;
        }
        return false;
    }

    private boolean a(BlockPos class_23382) {
        if (zo.a.world == null) {
            return false;
        }
        if (zo.a.player.getEntityPos().distanceTo(Vec3d.ofCenter((Vec3i)class_23382)) > 4.5) {
            return false;
        }
        if (!zo.a.world.getBlockState(class_23382).isAir()) {
            return false;
        }
        BlockPos class_23383 = zo.a.player.getBlockPos();
        return !class_23382.equals((Object)class_23383) && !class_23382.equals((Object)class_23383.up());
    }

    private boolean b(BlockPos class_23382) {
        if (zo.a.world == null) {
            return false;
        }
        Block class_22482 = zo.a.world.getBlockState(class_23382).getBlock();
        return class_22482 == Blocks.OBSIDIAN || class_22482 == Blocks.BEDROCK;
    }

    private boolean c(BlockPos class_23382) {
        if (zo.a.world == null) {
            return false;
        }
        if (zo.a.player.getEntityPos().distanceTo(Vec3d.ofCenter((Vec3i)class_23382)) > 4.5) {
            return false;
        }
        if (!zo.a.world.getBlockState(class_23382).isAir()) {
            return false;
        }
        if (!zo.a.world.getBlockState(class_23382.up()).isAir()) {
            return false;
        }
        BlockPos class_23383 = zo.a.player.getBlockPos();
        return !class_23382.equals((Object)class_23383) && !class_23382.equals((Object)class_23383.up()) && !class_23382.up().equals((Object)class_23383) && !class_23382.up().equals((Object)class_23383.up());
    }

    private boolean r() {
        if (zo.a.world == null) {
            return false;
        }
        List list = zo.a.world.getPlayers();
        for (Entity class_12972 : list) {
            if (class_12972 == zo.a.player || !class_12972.isRemoved() && !(((LivingEntity)class_12972).getHealth() <= 0.0f) || !(class_12972.squaredDistanceTo((Entity)zo.a.player) < 36.0)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void c() {
        super.c();
        this.o();
    }

    @Override
    public int e() {
        return -1;
    }
}

