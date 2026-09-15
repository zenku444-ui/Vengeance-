/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.BlockView
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.hit.BlockHitResult;

public class zv
extends zb {
    private final ze b = new ze("Prediction Time", 0.1, 2.0, 0.5, 0.1);
    private final ze c = new ze("Place Delay", 0.0, 200.0, 50.0, 10.0);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Target Players", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Target Mobs", false);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Require Cobweb", true);
    private Entity g = null;
    private long h = 0L;

    public zv() {
        super("Stun Cob", "Predicts player movement and places cobweb", -1, za.a);
        this.a(this.b, this.c, this.d, this.e, this.f);
    }

    @EventHandler
    private void onAttack(com.vengeance.vengeanceclient.p.p.s.za za2) {
        if (this.d()) {
            return;
        }
        Entity class_12972 = za2.a();
        if (class_12972 == null || !this.b(class_12972)) {
            return;
        }
        this.g = class_12972;
        this.h = System.currentTimeMillis();
    }

    @EventHandler
    private void onTick(zd zd2) {
        if (this.d()) {
            return;
        }
        if (this.g == null) {
            return;
        }
        if ((double)(System.currentTimeMillis() - this.h) < this.c.f()) {
            return;
        }
        if (this.f.b() && !this.o()) {
            return;
        }
        Vec3d VanillaChestLootTableGenerator = this.a(this.g);
        if (VanillaChestLootTableGenerator != null) {
            this.a(VanillaChestLootTableGenerator);
        }
        this.g = null;
    }

    private Vec3d a(Entity class_12972) {
        BlockPos class_23382;
        if (!(class_12972 instanceof LivingEntity)) {
            return null;
        }
        Vec3d VanillaChestLootTableGenerator = class_12972.getEntityPos();
        Vec3d WallPlayerSkullBlock = class_12972.getVelocity();
        boolean bl = zv.a.player.isSprinting();
        double d = bl ? 1.5 : 1.0;
        Vec3d VanillaEntityLootTableGenerator = new Vec3d(WallPlayerSkullBlock.x * d, WallPlayerSkullBlock.y, WallPlayerSkullBlock.z * d);
        double d2 = this.b.b();
        double d3 = 0.08;
        double d4 = 0.98;
        Vec3d PlayerSkullBlock = VanillaChestLootTableGenerator;
        Vec3d RedstoneBlock = VanillaEntityLootTableGenerator;
        for (double d5 = 0.0; d5 < d2; d5 += 0.05) {
            RedstoneBlock = new Vec3d(RedstoneBlock.x * d4, RedstoneBlock.y - d3 * 0.05, RedstoneBlock.z * d4);
            PlayerSkullBlock = PlayerSkullBlock.add(RedstoneBlock.multiply(0.05));
            if (!(PlayerSkullBlock.y <= 0.0)) continue;
            PlayerSkullBlock = new Vec3d(PlayerSkullBlock.x, 0.0, PlayerSkullBlock.z);
            break;
        }
        if (this.a(class_23382 = new BlockPos((int)Math.floor(PlayerSkullBlock.x), (int)Math.floor(PlayerSkullBlock.y), (int)Math.floor(PlayerSkullBlock.z)))) {
            return new Vec3d((double)class_23382.getX() + 0.5, (double)class_23382.getY(), (double)class_23382.getZ() + 0.5);
        }
        return null;
    }

    private boolean a(BlockPos class_23382) {
        if (zv.a.world == null) {
            return false;
        }
        if (!zv.a.world.getBlockState(class_23382).isAir()) {
            return false;
        }
        if (!zv.a.world.getBlockState(class_23382.down()).isSolidBlock((BlockView)zv.a.world, class_23382.down())) {
            return false;
        }
        double d = zv.a.player.getEntityPos().distanceTo(new Vec3d((double)class_23382.getX() + 0.5, (double)class_23382.getY(), (double)class_23382.getZ() + 0.5));
        return d <= 4.5;
    }

    private void a(Vec3d VanillaChestLootTableGenerator) {
        BlockPos class_23382 = new BlockPos((int)Math.floor(VanillaChestLootTableGenerator.x), (int)Math.floor(VanillaChestLootTableGenerator.y), (int)Math.floor(VanillaChestLootTableGenerator.z));
        if (!this.a(class_23382)) {
            return;
        }
        int n = this.n();
        if (n == -1) {
            return;
        }
        int n2 = zv.a.player.getInventory().selectedSlot;
        zv.a.player.getInventory().selectedSlot = n;
        zv.a.interactionManager.interactBlock(zv.a.player, Hand.MAIN_HAND, new BlockHitResult(VanillaChestLootTableGenerator, Direction.UP, class_23382, false));
        zv.a.player.getInventory().selectedSlot = n2;
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zv.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.COBWEB) continue;
            return i;
        }
        return -1;
    }

    private boolean o() {
        return this.n() != -1;
    }

    private boolean b(Entity class_12972) {
        if (class_12972 == null || class_12972 == zv.a.player || class_12972 == zv.a.cameraEntity) {
            return false;
        }
        if (!(class_12972 instanceof LivingEntity)) {
            return false;
        }
        LivingEntity class_13092 = (LivingEntity)class_12972;
        if (!class_13092.isAlive() || class_13092.isDead()) {
            return false;
        }
        if (com.vengeance.vengeanceclient.utils.q.za.c(class_12972.getUuid())) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity) {
            return this.d.b();
        }
        return this.e.b();
    }

    @Override
    public void b() {
        this.g = null;
        this.h = 0L;
    }

    @Override
    public void c() {
        this.g = null;
        this.h = 0L;
    }
}

