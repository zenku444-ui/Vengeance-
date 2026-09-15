/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.decoration.EndCrystalEntity
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
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
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

public final class zd
extends zb {
    private final zc b = new zc("Crystal Key", 3, false);
    private final ze c = new ze("Delay (MS)", 1.0, 200.0, 50.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Anti Suicide", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Auto Switch", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Switch Back", true);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Anti Weakness", true);
    private final com.vengeance.vengeanceclient.utils.s.zb h = new com.vengeance.vengeanceclient.utils.s.zb();
    private int i = -1;

    public zd() {
        super("Auto Crystal", "Hold key to spam crystals", -1, za.a);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        if (zd.a.currentScreen != null) {
            return;
        }
        if (!com.vengeance.vengeanceclient.utils.r.za.b(this.b.e())) {
            return;
        }
        if (this.h.a(this.c.a())) {
            this.n();
            this.h.a();
        }
    }

    private void n() {
        EntityHitResult class_39662;
        Entity class_12972;
        if (this.d.b() && !zd.a.player.isOnGround()) {
            return;
        }
        HitResult ItemStackParticleEffect = zd.a.crosshairTarget;
        if (ItemStackParticleEffect instanceof EntityHitResult && (class_12972 = (class_39662 = (EntityHitResult)ItemStackParticleEffect).getEntity()) instanceof EndCrystalEntity endCrystal) {
            if (!endCrystal.isRemoved() && endCrystal.isAlive() && zd.a.world.getEntityById(endCrystal.getId()) != null && zd.a.player.getEntityPos().distanceTo(endCrystal.getEntityPos()) <= 4.5) {
                if (this.g.b() && zd.a.player.hasStatusEffect(StatusEffects.WEAKNESS)) {
                    com.vengeance.vengeanceclient.utils.t.zd.b();
                }
                ((MinecraftClientAccessor)a).invokeDoAttack();
            }
            return;
        }
        ItemStackParticleEffect = zd.a.crosshairTarget;
        if (ItemStackParticleEffect instanceof BlockHitResult) {
            BlockHitResult blockHit = (BlockHitResult)ItemStackParticleEffect;
            BlockPos blockPos = blockHit.getBlockPos();
            BlockPos offsetPos = blockPos.offset(blockHit.getSide());
            if (this.a(blockPos) && this.b(offsetPos)) {
                if (this.e.b() && this.o()) {
                    com.vengeance.vengeanceclient.utils.t.zd.a(Items.END_CRYSTAL);
                }
                if (zd.a.player.getMainHandStack().getItem() == Items.END_CRYSTAL) {
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                }
            }
        }
    }

    private boolean o() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zd.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != Items.END_CRYSTAL) continue;
            return true;
        }
        return false;
    }

    private boolean a(BlockPos class_23382) {
        if (zd.a.world == null) {
            return false;
        }
        Block class_22482 = zd.a.world.getBlockState(class_23382).getBlock();
        return class_22482 == Blocks.OBSIDIAN || class_22482 == Blocks.BEDROCK;
    }

    private boolean b(BlockPos class_23382) {
        if (zd.a.world == null) {
            return false;
        }
        if (zd.a.player.getEntityPos().distanceTo(Vec3d.ofCenter((Vec3i)class_23382)) > 4.5) {
            return false;
        }
        if (!zd.a.world.getBlockState(class_23382).isAir()) {
            return false;
        }
        if (!zd.a.world.getBlockState(class_23382.up()).isAir()) {
            return false;
        }
        BlockPos class_23383 = zd.a.player.getBlockPos();
        return !class_23382.equals((Object)class_23383) && !class_23382.equals((Object)class_23383.up());
    }

    @Override
    public void b() {
        super.b();
        if (this.e.b()) {
            this.i = zd.a.player.getInventory().selectedSlot;
        }
        this.h.a();
    }

    @Override
    public void c() {
        super.c();
        if (this.f.b() && this.i != -1) {
            zd.a.player.getInventory().selectedSlot = this.i;
        }
        this.i = -1;
    }

    @Override
    public int e() {
        return -1;
    }
}

