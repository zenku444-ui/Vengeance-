/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.util.math.MathHelper
 *  org.joml.Matrix3x2fStack
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.q.p.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix3x2fStack;

public final class zp
extends com.vengeance.vengeanceclient.r.zb {
    private static final int b = 120;
    private static final int c = 40;
    private static final int d = 6;
    private static final int e = 28;
    private static final int f = 14;
    private static final int g = 0;
    private static final float h = 12.0f;
    private static final float i = 6.0f;
    private static final float j = 3.0f;
    private static final float k = 9.0f;
    private static final float l = 3.0f;
    private static final float m = 0.875f;
    private static final float n = 3.5f;
    private static final int o = 1000;
    private static final float p = 200.0f;
    private static final double q = 8.0;
    private static final Color r = new Color(20, 20, 25);
    private static final Color s = new Color(30, 30, 35);
    private static final Color t = new Color(15, 15, 20);
    private static final Color u = new Color(255, 255, 255, 255);
    private final ze v = new ze("Transparency", 0.0, 255.0, 200.0, 5.0);
    private final com.vengeance.vengeanceclient.r.r.za x = new com.vengeance.vengeanceclient.r.r.za("Blur", true);
    private final ze y = new ze("Blur Radius", 1.0, 30.0, 12.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za z = new com.vengeance.vengeanceclient.r.r.za("Gradient Health", true);
    private final com.vengeance.vengeanceclient.r.r.za aa = new com.vengeance.vengeanceclient.r.r.za("Show Armor", true);
    private final com.vengeance.vengeanceclient.r.r.za ab = new com.vengeance.vengeanceclient.r.r.za("Show Item", true);
    private final com.vengeance.vengeanceclient.r.r.za ac = new com.vengeance.vengeanceclient.r.r.za("Particles", true);
    private final ze ad = new ze("Particle Count", 5.0, 30.0, 15.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.w.ze ae = new com.vengeance.vengeanceclient.utils.w.ze(20.0f, 100.0f, 120.0f, 40.0f);
    private final Deque<za> af = new ArrayDeque<za>();
    private float ag = 1.0f;
    private float ah = 1.0f;

    public zp() {
        super("Target HUD", "Displays information about the current combat target", -1, com.vengeance.vengeanceclient.r.za.d);
        this.a(this.v, this.x, this.y, this.z, this.aa, this.ab, this.ac, this.ad);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (!this.n()) {
            return;
        }
        PlayerEntity class_16572 = this.o();
        if (class_16572 == null && zp.a.currentScreen == null) {
            return;
        }
        this.ae.a();
        zb zb2 = new zb(class_16572);
        this.a(za2, zb2);
    }

    private boolean n() {
        return zp.a.player != null && zp.a.world != null;
    }

    private void a(com.vengeance.vengeanceclient.p.p.t.za za2, zb zb2) {
        float f = this.ae.b();
        float f2 = this.ae.c();
        int n = this.a(zb2);
        this.ae.c(n);
        this.a(za2, f, f2, n);
        this.a(zb2, f, f2);
        if (this.ac.b()) {
            this.a(za2.a().getScaledWindowWidth(), za2.a().getScaledWindowHeight());
        }
        if (zb2.a != null) {
            this.b(za2.a(), zb2.a, f, f2);
            if (this.aa.b() || this.ab.b()) {
                this.a(za2.a(), zb2.a, f + 120.0f - 2.0f, f2);
            }
        }
    }

    private int a(zb zb2) {
        int n = 0;
        if (zb2.a != null) {
            if (this.ab.b() && !zb2.a.getMainHandStack().isEmpty()) {
                ++n;
            }
            if (this.aa.b()) {
                for (EquipmentSlot class_13042 : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                    if (zb2.a.getEquippedStack(class_13042).isEmpty()) continue;
                    ++n;
                }
            }
        }
        return 120 + (n > 0 ? n * 14 + 4 : 0);
    }

    private void a(com.vengeance.vengeanceclient.p.p.t.za za2, float f, float f2, int n) {
        if (this.x.b()) {
            com.vengeance.vengeanceclient.utils.w.p.zb.a(za2.a().getMatrices(), f, f2, (float)n, 40.0f, 12.0f, Color.WHITE, (float)this.y.f());
        }
        int n2 = this.v.a();
        Color color = this.ae.d() ? new Color(s.getRed(), s.getGreen(), s.getBlue(), Math.min(255, n2 + 30)) : new Color(r.getRed(), r.getGreen(), r.getBlue(), this.x.b() ? n2 / 2 : n2);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, (float)n, 40.0f, 12.0f, color);
        if (this.ae.d()) {
            Color color2 = this.p();
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, (float)n, 40.0f, 12.0f, 2.0f, color2);
        }
    }

    private void a(zb zb2, float f, float f2) {
        float f3 = f + 6.0f;
        float f4 = f3 + 28.0f + 6.0f;
        float f5 = f2 + 6.0f + 6.0f;
        float f6 = 74.0f;
        int n = com.vengeance.vengeanceclient.utils.w.r.za.g();
        com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.b, f4, f5, 9.0f, u, n);
        this.a(zb2, f4, f5 + 10.0f, f6);
    }

    private void a(zb zb2, float f, float f2, float f3) {
        int n = this.v.a();
        int n2 = Math.min(255, n + 20);
        Color color = new Color(t.getRed(), t.getGreen(), t.getBlue(), n2);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 6.0f, 3.0f, color);
        this.a(zb2.c);
        float f4 = f3 * this.ag;
        if (f4 > 0.0f) {
            if (this.z.b()) {
                this.a(f, f2, f4);
            } else {
                Color color2 = this.p();
                com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f4, 6.0f, 3.0f, color2);
            }
        }
    }

    private void a(float f, float f2, float f3) {
        Color color = this.p();
        Color color2 = new Color(0, 0, 0);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 6.0f, 3.0f, color, color2);
    }

    private void a(float f) {
        float f2 = a.getRenderTickCounter().getTickProgress(true) / 20.0f;
        if (Math.abs(f - this.ah) > 0.001f) {
            this.ah = f;
        }
        if (this.ag > this.ah) {
            this.ag = Math.max(this.ah, this.ag - 3.0f * f2);
        } else if (this.ag < this.ah) {
            this.ag = Math.min(this.ah, this.ag + 3.0f * f2);
        }
    }

    private void a(DrawContext class_3322, PlayerEntity class_16572, float f, float f2) {
        ItemStack class_17992 = class_16572.getMainHandStack();
        float f3 = f;
        float f4 = f2 + 13.0f;
        if (this.ab.b() && !class_17992.isEmpty()) {
            this.a(class_3322, class_17992, f3, f4);
            f3 += 14.0f;
        }
        if (this.aa.b()) {
            ItemStack[] armorStacks = new ItemStack[]{class_16572.getEquippedStack(EquipmentSlot.HEAD), class_16572.getEquippedStack(EquipmentSlot.CHEST), class_16572.getEquippedStack(EquipmentSlot.LEGS), class_16572.getEquippedStack(EquipmentSlot.FEET)};
            for (ItemStack armorStack : armorStacks) {
                if (armorStack.isEmpty()) continue;
                this.a(class_3322, armorStack, f3, f4);
                f3 += 14.0f;
            }
        }
    }

    private void a(DrawContext class_3322, ItemStack class_17992, float f, float f2) {
        class_3322.getMatrices().pushMatrix();
        class_3322.getMatrices().translate(f, f2);
        class_3322.getMatrices().scale(0.875f, 0.875f);
        class_3322.drawItem(class_17992, 0, 0);
        class_3322.getMatrices().popMatrix();
    }

    @EventHandler
    private void onAttack(com.vengeance.vengeanceclient.p.p.s.za za2) {
        Entity class_12972;
        if (!this.ac.b() || !((class_12972 = za2.a()) instanceof LivingEntity)) {
            return;
        }
        LivingEntity class_13092 = (LivingEntity)class_12972;
        this.a(class_13092);
    }

    private void a(LivingEntity class_13092) {
        float f = this.ae.b();
        float f2 = this.ae.c();
        float f3 = f + 6.0f;
        float f4 = f3 + 28.0f + 6.0f;
        float f5 = f2 + 6.0f + 6.0f;
        float f6 = 74.0f;
        float f7 = Math.max(class_13092.getMaxHealth(), 1.0f);
        float f8 = MathHelper.clamp((float)class_13092.getHealth(), (float)0.0f, (float)f7);
        float f9 = MathHelper.clamp((float)(f8 / f7), (float)0.0f, (float)1.0f);
        float f10 = f6 * f9;
        float f11 = f4 + f10;
        float f12 = f5 + 10.0f + 3.0f;
        Color color = this.p();
        int n = this.ad.a();
        long l = System.currentTimeMillis();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < n; ++i) {
            float f13 = (float)(threadLocalRandom.nextDouble() * Math.PI * 2.0);
            float f14 = 50.0f + threadLocalRandom.nextFloat() * 100.0f;
            float f15 = (float)Math.cos(f13) * f14;
            float f16 = (float)Math.sin(f13) * f14;
            float f17 = 2.0f + threadLocalRandom.nextFloat() * 3.0f;
            this.af.addLast(new za(f11, f12, f15, f16, f17, color, l));
        }
    }

    private void a(int n, int n2) {
        long l = System.currentTimeMillis();
        float f = a.getRenderTickCounter().getTickProgress(true) / 20.0f;
        Iterator<za> iterator = this.af.iterator();
        while (iterator.hasNext()) {
            za za2 = iterator.next();
            if (l - za2.g > 1000L) {
                iterator.remove();
                continue;
            }
            za2.a += za2.c * f;
            za2.b += za2.d * f;
            za2.d += 200.0f * f;
            float f2 = (float)(l - za2.g) / 1000.0f;
            int n3 = (int)((1.0f - f2) * (float)za2.f.getAlpha());
            if (n3 <= 0) continue;
            Color color = new Color(za2.f.getRed(), za2.f.getGreen(), za2.f.getBlue(), n3);
            com.vengeance.vengeanceclient.utils.w.r.za.a(za2.a, za2.b, za2.e, color);
        }
    }

    private PlayerEntity o() {
        PlayerEntity class_16572;
        if (zp.a.player == null || zp.a.world == null) {
            return null;
        }
        Entity class_12972 = zp.a.targetedEntity;
        if (class_12972 instanceof PlayerEntity && (class_16572 = (PlayerEntity)class_12972).isAlive() && class_16572 != zp.a.player && !class_16572.isSpectator()) {
            return class_16572;
        }
        class_16572 = null;
        double d = Double.MAX_VALUE;
        for (PlayerEntity class_16573 : zp.a.world.getPlayers()) {
            double d2;
            if (class_16573 == zp.a.player || !class_16573.isAlive() || class_16573.isSpectator() || !((d2 = (double)zp.a.player.distanceTo((Entity)class_16573)) <= 8.0) || !(d2 < d)) continue;
            class_16572 = class_16573;
            d = d2;
        }
        return class_16572;
    }

    private void b(DrawContext class_3322, PlayerEntity class_16572, float f, float f2) {
        Identifier class_29602 = this.a(class_16572);
        if (class_29602 == null) {
            return;
        }
        int n = (int)(f + 6.0f);
        int n2 = (int)(f2 + 6.0f);
        Matrix3x2fStack matrix3x2fStack = class_3322.getMatrices();
        matrix3x2fStack.pushMatrix();
        class_3322.enableScissor(n, n2, n + 28, n2 + 28);
        matrix3x2fStack.translate((float)n, (float)n2);
        matrix3x2fStack.scale(3.5f, 3.5f);
        class_3322.drawTexture(RenderPipelines.GUI_TEXTURED, class_29602, 0, 0, 8.0f, 8.0f, 8, 8, 64, 64);
        class_3322.drawTexture(RenderPipelines.GUI_TEXTURED, class_29602, 0, 0, 40.0f, 8.0f, 8, 8, 64, 64);
        class_3322.disableScissor();
        matrix3x2fStack.popMatrix();
    }

    private Identifier a(PlayerEntity class_16572) {
        return null;
    }

    private Color p() {
        return zd.n();
    }

    private static class zb {
        final PlayerEntity a;
        final String b;
        final float c;

        zb(PlayerEntity class_16572) {
            this.a = class_16572;
            String string = this.b = class_16572 != null ? class_16572.getName().getString() : "Target";
            if (class_16572 != null) {
                float f = Math.max(class_16572.getMaxHealth(), 1.0f);
                float f2 = MathHelper.clamp((float)class_16572.getHealth(), (float)0.0f, (float)f);
                this.c = MathHelper.clamp((float)(f2 / f), (float)0.0f, (float)1.0f);
            } else {
                this.c = 0.75f;
            }
        }
    }

    private static class za {
        float a;
        float b;
        float c;
        float d;
        float e;
        Color f;
        long g;

        za(float f, float f2, float f3, float f4, float f5, Color color, long l) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = color;
            this.g = l;
        }
    }
}

