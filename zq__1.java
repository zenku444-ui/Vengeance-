/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.FishingBobberEntity
 *  net.minecraft.entity.projectile.ArrowEntity
 *  net.minecraft.entity.projectile.ProjectileUtil
 *  net.minecraft.entity.projectile.SpectralArrowEntity
 *  net.minecraft.entity.projectile.thrown.SnowballEntity
 *  net.minecraft.entity.projectile.thrown.EggEntity
 *  net.minecraft.entity.projectile.thrown.ExperienceBottleEntity
 *  net.minecraft.entity.projectile.thrown.EnderPearlEntity
 *  net.minecraft.entity.projectile.TridentEntity
 *  net.minecraft.entity.projectile.thrown.PotionEntity
 *  net.minecraft.item.BowItem
 *  net.minecraft.item.CrossbowItem
 *  net.minecraft.item.EggItem
 *  net.minecraft.item.EnderPearlItem
 *  net.minecraft.item.ExperienceBottleItem
 *  net.minecraft.item.FishingRodItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.PotionItem
 *  net.minecraft.item.SnowballItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.world.World
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.w.zr;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.EggItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ExperienceBottleItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.item.SnowballItem;
import net.minecraft.item.TridentItem;
import net.minecraft.world.World;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

public final class zq
extends zb {
    private final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Show Landing Point", true);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Track Thrown", true);
    private final ze d = new ze("Track Duration (s)", 1.0, 10.0, 3.0, 0.5);
    private final ze e = new ze("Line Width", 1.0, 5.0, 2.0, 0.5);
    private final ze f = new ze("Point Size", 2.0, 10.0, 5.0, 0.5);
    private final com.vengeance.vengeanceclient.r.r.zb g = new com.vengeance.vengeanceclient.r.r.zb("Line Color", new Color(255, 255, 255, 200), true);
    private final com.vengeance.vengeanceclient.r.r.zb h = new com.vengeance.vengeanceclient.r.r.zb("Hit Color", new Color(255, 50, 50, 255), true);
    private final com.vengeance.vengeanceclient.r.r.zb i = new com.vengeance.vengeanceclient.r.r.zb("Thrown Color", new Color(100, 200, 255, 200), true);
    private final ze j = new ze("Max Points", 50.0, 500.0, 200.0, 10.0);
    private final Map<Entity, za> k = new HashMap<Entity, za>();

    public zq() {
        super("Trajectories", "Shows projectile trajectory path", -1, com.vengeance.vengeanceclient.r.za.d);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        Object object;
        if (this.d() || zq.a.player == null || zq.a.world == null) {
            return;
        }
        if (this.c.b()) {
            this.n();
        } else {
            this.k.clear();
        }
        if (!com.vengeance.vengeanceclient.utils.w.r.za.c()) {
            return;
        }
        ItemStack class_17992 = zq.a.player.getMainHandStack();
        if (this.b(class_17992) && this.a(class_17992) && !(object = this.c(class_17992)).isEmpty()) {
            this.a((List<Vec3d>)object, this.g.h(), false);
        }
        if (this.c.b()) {
            for (za za3 : this.k.values()) {
                if (za3.a.isEmpty()) continue;
                this.a(za3.a, this.i.h(), true);
            }
        }
        com.vengeance.vengeanceclient.utils.w.r.za.e();
    }

    private boolean a(ItemStack class_17992) {
        Item class_17922 = class_17992.getItem();
        if (class_17922 instanceof BowItem) {
            return zq.a.player.isUsingItem() && zq.a.player.getItemUseTime() > 0;
        }
        if (class_17922 instanceof CrossbowItem) {
            return CrossbowItem.isCharged((ItemStack)class_17992);
        }
        if (class_17922 instanceof TridentItem) {
            return zq.a.player.isUsingItem() && zq.a.player.getItemUseTime() > 0;
        }
        if (class_17922 instanceof SnowballItem || class_17922 instanceof EggItem || class_17922 instanceof EnderPearlItem || class_17922 instanceof ExperienceBottleItem || class_17922 instanceof PotionItem) {
            return true;
        }
        if (class_17922 instanceof FishingRodItem) {
            return zq.a.player.isUsingItem();
        }
        return false;
    }

    private void n() {
        this.k.entrySet().removeIf(entry -> ((za)entry.getValue()).a(this.d.f()) || !((Entity)entry.getKey()).isAlive() || ((Entity)entry.getKey()).isRemoved());
        for (Object object : zq.a.world.getEntities()) {
            if (!this.a((Entity)object) || this.k.containsKey(object) || ((Entity)object).age >= 5 || !(object.squaredDistanceTo((Entity)zq.a.player) < 100.0)) continue;
            this.k.put((Entity)object, new za());
        }
        float f = a.getRenderTickCounter().getTickProgress(true);
        for (Map.Entry entry2 : this.k.entrySet()) {
            Entity class_12972 = (Entity)entry2.getKey();
            za za2 = (za)entry2.getValue();
            Vec3d VanillaChestLootTableGenerator = class_12972.getLerpedPos(f);
            if (!za2.a.isEmpty() && !(za2.a.get(za2.a.size() - 1).squaredDistanceTo(VanillaChestLootTableGenerator) > 0.01)) continue;
            za2.a.add(VanillaChestLootTableGenerator);
            if (za2.a.size() <= this.j.a()) continue;
            za2.a.remove(0);
        }
    }

    private boolean a(Entity class_12972) {
        return class_12972 instanceof ArrowEntity || class_12972 instanceof SpectralArrowEntity || class_12972 instanceof TridentEntity || class_12972 instanceof SnowballEntity || class_12972 instanceof EggEntity || class_12972 instanceof EnderPearlEntity || class_12972 instanceof ExperienceBottleEntity || class_12972 instanceof PotionEntity || class_12972 instanceof FishingBobberEntity;
    }

    private boolean b(ItemStack class_17992) {
        Item class_17922 = class_17992.getItem();
        return class_17922 instanceof BowItem || class_17922 instanceof CrossbowItem || class_17922 instanceof TridentItem || class_17922 instanceof SnowballItem || class_17922 instanceof EggItem || class_17922 instanceof EnderPearlItem || class_17922 instanceof ExperienceBottleItem || class_17922 instanceof PotionItem || class_17922 instanceof FishingRodItem;
    }

    private List<Vec3d> c(ItemStack class_17992) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        Item class_17922 = class_17992.getItem();
        Vec3d VanillaChestLootTableGenerator = zq.a.player.getEyePos();
        Vec3d WallPlayerSkullBlock = this.a(zq.a.player.getPitch(), zq.a.player.getYaw());
        float f = this.a(class_17922, class_17992);
        WallPlayerSkullBlock = WallPlayerSkullBlock.multiply((double)f);
        float f2 = this.a(class_17922);
        float f3 = this.b(class_17922);
        int n = this.j.a();
        for (int i = 0; i < n; ++i) {
            arrayList.add(VanillaChestLootTableGenerator);
            Vec3d VanillaEntityLootTableGenerator = VanillaChestLootTableGenerator.add(WallPlayerSkullBlock);
            HitResult ItemStackParticleEffect = this.a(VanillaChestLootTableGenerator, VanillaEntityLootTableGenerator);
            if (ItemStackParticleEffect != null && ItemStackParticleEffect.getType() != HitResult.class_240.MISS) {
                arrayList.add(ItemStackParticleEffect.getPos());
                break;
            }
            VanillaChestLootTableGenerator = VanillaEntityLootTableGenerator;
            if ((WallPlayerSkullBlock = WallPlayerSkullBlock.multiply((double)f3).add(0.0, (double)(-f2), 0.0)).lengthSquared() < 0.001) break;
        }
        return arrayList;
    }

    private Vec3d a(float f, float f2) {
        float f3 = f * ((float)Math.PI / 180);
        float f4 = -f2 * ((float)Math.PI / 180);
        float f5 = (float)Math.cos(f4);
        float f6 = (float)Math.sin(f4);
        float f7 = (float)Math.cos(f3);
        float f8 = (float)Math.sin(f3);
        return new Vec3d((double)(f6 * f7), (double)(-f8), (double)(f5 * f7));
    }

    private float a(Item class_17922, ItemStack class_17992) {
        if (class_17922 instanceof BowItem) {
            int n = zq.a.player.getItemUseTime();
            float f = BowItem.getPullProgress((int)n);
            return f * 3.0f;
        }
        if (class_17922 instanceof CrossbowItem) {
            return 3.15f;
        }
        if (class_17922 instanceof TridentItem) {
            return 2.5f;
        }
        if (class_17922 instanceof SnowballItem || class_17922 instanceof EggItem || class_17922 instanceof EnderPearlItem) {
            return 1.5f;
        }
        if (class_17922 instanceof ExperienceBottleItem || class_17922 instanceof PotionItem) {
            return 1.0f;
        }
        if (class_17922 instanceof FishingRodItem) {
            return 1.5f;
        }
        return 1.5f;
    }

    private float a(Item class_17922) {
        if (class_17922 instanceof BowItem || class_17922 instanceof CrossbowItem || class_17922 instanceof TridentItem) {
            return 0.05f;
        }
        if (class_17922 instanceof FishingRodItem) {
            return 0.04f;
        }
        return 0.03f;
    }

    private float b(Item class_17922) {
        if (class_17922 instanceof BowItem || class_17922 instanceof CrossbowItem || class_17922 instanceof TridentItem) {
            return 0.99f;
        }
        return 0.99f;
    }

    private HitResult a(Vec3d VanillaChestLootTableGenerator, Vec3d WallPlayerSkullBlock) {
        double d;
        BlockHitResult class_39652 = zq.a.world.raycast(new RaycastContext(VanillaChestLootTableGenerator, WallPlayerSkullBlock, RaycastContext.class_3960.COLLIDER, RaycastContext.class_242.NONE, (Entity)zq.a.player));
        Box HorizontalFacingBlock = new Box(VanillaChestLootTableGenerator, WallPlayerSkullBlock).expand(1.0);
        EntityHitResult class_39662 = ProjectileUtil.getEntityCollision((World)zq.a.world, (Entity)zq.a.player, (Vec3d)VanillaChestLootTableGenerator, (Vec3d)WallPlayerSkullBlock, (Box)HorizontalFacingBlock, class_12972 -> !class_12972.isSpectator() && class_12972 != zq.a.player, (float)0.0f);
        if (class_39662 == null) {
            return class_39652;
        }
        if (class_39652 == null || class_39652.getType() == HitResult.class_240.MISS) {
            return class_39662;
        }
        double d2 = VanillaChestLootTableGenerator.squaredDistanceTo(class_39662.getPos());
        return d2 <= (d = VanillaChestLootTableGenerator.squaredDistanceTo(class_39652.getPos())) ? class_39662 : class_39652;
    }

    private void a(List<Vec3d> list, Color color, boolean bl) {
        Vec3d VanillaChestLootTableGenerator;
        Object object;
        Vec3d WallPlayerSkullBlock;
        if (list.size() < 2) {
            return;
        }
        float f = this.e.b();
        for (int i = 0; i < list.size() - 1; ++i) {
            WallPlayerSkullBlock = list.get(i);
            object = list.get(i + 1);
            Vec3d VanillaEntityLootTableGenerator = zr.a(WallPlayerSkullBlock);
            Vec3d PlayerSkullBlock = zr.a(object);
            if (VanillaEntityLootTableGenerator == null || PlayerSkullBlock == null || !(VanillaEntityLootTableGenerator.z >= 0.0) || !(VanillaEntityLootTableGenerator.z < 1.0) || !(PlayerSkullBlock.z >= 0.0) || !(PlayerSkullBlock.z < 1.0)) continue;
            Color color2 = color;
            if (bl) {
                float f2 = (float)i / (float)list.size();
                color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)((float)color.getAlpha() * f2));
            }
            com.vengeance.vengeanceclient.utils.w.r.za.b((float)VanillaEntityLootTableGenerator.x, (float)VanillaEntityLootTableGenerator.y, (float)PlayerSkullBlock.x, (float)PlayerSkullBlock.y, f, color2);
        }
        if (this.b.b() && !bl && !list.isEmpty() && (WallPlayerSkullBlock = zr.a(VanillaChestLootTableGenerator = list.get(list.size() - 1))) != null && WallPlayerSkullBlock.z >= 0.0 && WallPlayerSkullBlock.z < 1.0) {
            object = this.h.h();
            float f3 = this.f.b();
            com.vengeance.vengeanceclient.utils.w.r.za.a((float)WallPlayerSkullBlock.x, (float)WallPlayerSkullBlock.y, f3 + 2.0f, new Color(0, 0, 0, 150));
            com.vengeance.vengeanceclient.utils.w.r.za.a((float)WallPlayerSkullBlock.x, (float)WallPlayerSkullBlock.y, f3, (Color)object);
        }
    }

    private static class za {
        final List<Vec3d> a = new ArrayList<Vec3d>();
        final long b = System.currentTimeMillis();

        private za() {
        }

        boolean a(double d) {
            return (double)(System.currentTimeMillis() - this.b) / 1000.0 > d;
        }
    }
}

