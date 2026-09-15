/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.client.gl.Framebuffer
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.mixin.WorldRendererAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gl.Framebuffer;

public class zf
extends zb {
    private static zf b;
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Self", false);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Show Players", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Show Passives", false);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Show Hostiles", false);
    private final ze g = new ze("Range", 10.0, 200.0, 100.0, 5.0);
    private final ze h = new ze("Outline Width", 1.0, 10.0, 3.0, 1.0);
    private final ze i = new ze("Intensity", 0.1, 2.0, 1.0, 0.1);
    private final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Show Fill", true);
    private final ze k = new ze("Fill Alpha", 0.0, 255.0, 50.0, 5.0);
    private final com.vengeance.vengeanceclient.r.r.zb l = new com.vengeance.vengeanceclient.r.r.zb("Player Color", new Color(255, 50, 50));
    private final com.vengeance.vengeanceclient.r.r.zb m = new com.vengeance.vengeanceclient.r.r.zb("Friend Color", new Color(50, 255, 50));
    private final com.vengeance.vengeanceclient.r.r.zb n = new com.vengeance.vengeanceclient.r.r.zb("Passive Color", new Color(50, 255, 50));
    private final com.vengeance.vengeanceclient.r.r.zb o = new com.vengeance.vengeanceclient.r.r.zb("Hostile Color", new Color(255, 165, 0));
    private final Set<Entity> p = new HashSet<Entity>();

    public zf() {
        super("Custom Outline", "Custom post-processed outline ESP", za.d);
        b = this;
        this.a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    public static zf n() {
        return b;
    }

    public boolean a(Entity class_12972) {
        if (!this.l() || this.d()) {
            return false;
        }
        return this.c(class_12972);
    }

    public void o() {
        this.p.clear();
        if (this.d() || zf.a.world == null) {
            return;
        }
        for (Entity class_12972 : zf.a.world.getEntities()) {
            if (!(class_12972 instanceof LivingEntity) || !this.c(class_12972)) continue;
            this.p.add(class_12972);
        }
    }

    public Set<Entity> p() {
        return this.p;
    }

    private boolean c(Entity class_12972) {
        if (!(class_12972 instanceof LivingEntity)) {
            return false;
        }
        if (zf.a.player == null) {
            return false;
        }
        if (zf.a.player.squaredDistanceTo(class_12972) > this.g.f() * this.g.f()) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity) {
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (class_16572 == zf.a.player && !this.c.b()) {
                return false;
            }
            return this.d.b();
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.e.b();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.f.b();
        }
        return false;
    }

    public Color b(Entity class_12972) {
        if (class_12972 instanceof PlayerEntity) {
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (com.vengeance.vengeanceclient.utils.q.za.c(class_16572.getUuid())) {
                return this.m.h();
            }
            return this.l.h();
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.n.h();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.o.h();
        }
        return this.l.h();
    }

    public float q() {
        return this.h.b();
    }

    public float r() {
        return this.i.b();
    }

    public boolean s() {
        return this.j.b();
    }

    public float t() {
        return this.k.b() / 255.0f;
    }

    public Framebuffer u() {
        if (zf.a.worldRenderer == null) {
            return null;
        }
        return ((WorldRendererAccessor)zf.a.worldRenderer).getEntityOutlineFramebuffer();
    }
}

