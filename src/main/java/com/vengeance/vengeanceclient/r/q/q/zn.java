/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.property.Property
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.RespawnAnchorBlock
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.RespawnAnchorBlock;

public final class zn
extends zb {
    private final zc b = new zc("Anchor Key", 88, false);
    private final ze c = new ze("Delay (MS)", 1.0, 500.0, 50.0, 1.0);
    private final ze d = new ze("Restore Delay", 1.0, 20.0, 2.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb e = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean f = false;
    private boolean g = false;
    private int h = -1;
    private boolean i = false;
    private boolean j = false;
    private int k = 0;

    public zn() {
        super("Key Anchor", "Automatically places and explodes respawn anchors for PvP", -1, za.a);
        this.a(this.b, this.c, this.d);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d() || !this.l()) {
            return;
        }
        if (zn.a.currentScreen != null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.f) {
            this.n();
        } else if (!bl && this.f) {
            this.o();
        } else if (!bl) {
            this.i = false;
        }
        this.f = bl;
        if (this.g && this.e.a(this.c.a())) {
            this.p();
            this.e.a();
        }
        if (this.j) {
            if (this.k <= 0) {
                this.r();
                this.j = false;
            } else {
                --this.k;
            }
        }
    }

    private void n() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.h = zn.a.player.getInventory().selectedSlot;
        this.i = false;
        this.e.a();
    }

    private void o() {
        if (!this.g) {
            return;
        }
        if (this.h != -1) {
            zn.a.player.getInventory().selectedSlot = this.h;
        }
        this.g = false;
        this.h = -1;
        this.j = false;
        this.k = 0;
    }

    private void p() {
        HitResult ItemStackParticleEffect = zn.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof BlockHitResult)) {
            return;
        }
        BlockHitResult class_39652 = (BlockHitResult)ItemStackParticleEffect;
        BlockPos blockPos = class_39652.getBlockPos();
        BlockState class_26802 = zn.a.world.getBlockState(blockPos);
        if (class_26802.isAir()) {
            return;
        }
        if (class_26802.getBlock() == Blocks.RESPAWN_ANCHOR) {
            int n = (Integer)class_26802.get((Property)RespawnAnchorBlock.CHARGES);
            if (n > 0) {
                if (this.a(Items.TOTEM_OF_UNDYING) || this.q()) {
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                    this.s();
                    this.i = true;
                }
            } else if (this.a(Items.GLOWSTONE)) {
                ((MinecraftClientAccessor)a).invokeDoItemUse();
                this.i = true;
            }
            return;
        }
        BlockPos class_23382 = blockPos.offset(class_39652.getSide());
        if (this.a(class_23382) && !this.i && this.a(Items.RESPAWN_ANCHOR)) {
            this.i = true;
            ((MinecraftClientAccessor)a).invokeDoItemUse();
        }
    }

    private boolean a(BlockPos class_23382) {
        if (zn.a.world == null || zn.a.player == null) {
            return false;
        }
        if (zn.a.player.getEntityPos().distanceTo(Vec3d.ofCenter((Vec3i)class_23382)) > 4.5) {
            return false;
        }
        if (!zn.a.world.getBlockState(class_23382).isAir()) {
            return false;
        }
        BlockPos class_23383 = zn.a.player.getBlockPos();
        return !class_23382.equals((Object)class_23383) && !class_23382.equals((Object)class_23383.up());
    }

    private boolean a(Item class_17922) {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zn.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922) continue;
            zn.a.player.getInventory().selectedSlot = i;
            return true;
        }
        return false;
    }

    private boolean q() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zn.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || !class_17992.isIn(ItemTags.SWORDS)) continue;
            zn.a.player.getInventory().selectedSlot = i;
            return true;
        }
        return false;
    }

    private void r() {
        if (this.h != -1) {
            zn.a.player.getInventory().selectedSlot = this.h;
        }
    }

    private void s() {
        if (this.h != -1) {
            this.j = true;
            this.k = this.d.a();
        }
    }

    @Override
    public void b() {
        this.f = false;
        this.g = false;
        this.h = -1;
        this.i = false;
        this.j = false;
        this.k = 0;
        this.e.a();
        super.b();
    }

    @Override
    public void c() {
        this.o();
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }
}

