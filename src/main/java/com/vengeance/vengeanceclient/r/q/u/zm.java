/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Formatting
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.scoreboard.Team
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Formatting;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.Team;

public class zm
extends zb {
    private static zm b;
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Self", false);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Team Check", false);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Show Passives", false);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Show Hostiles", false);
    private final ze g = new ze("Range", 10.0, 200.0, 100.0, 5.0);
    private final com.vengeance.vengeanceclient.r.r.zb h = new com.vengeance.vengeanceclient.r.r.zb("Player Color", new Color(255, 255, 255));
    private final com.vengeance.vengeanceclient.r.r.zb i = new com.vengeance.vengeanceclient.r.r.zb("Passive Color", new Color(0, 255, 0));
    private final com.vengeance.vengeanceclient.r.r.zb j = new com.vengeance.vengeanceclient.r.r.zb("Hostile Color", new Color(255, 0, 0));
    private final Set<Integer> k = new HashSet<Integer>();

    public zm() {
        super("Outline ESP", "Uses Minecraft's glowing effect for entity outlines", za.d);
        b = this;
        this.a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    public static zm n() {
        return b;
    }

    public boolean a(Entity class_12972) {
        if (!this.l() || this.d()) {
            return false;
        }
        return this.d(class_12972);
    }

    public boolean b(Entity class_12972) {
        return this.k.contains(class_12972.getId());
    }

    @EventHandler
    private void onTick(zd zd2) {
        if (this.d() || zm.a.world == null) {
            return;
        }
        try {
            for (Entity class_12972 : zm.a.world.getEntities()) {
                if (this.d(class_12972)) {
                    this.e(class_12972);
                    continue;
                }
                this.c(class_12972);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void c(Entity class_12972) {
        if (!this.k.contains(class_12972.getId())) {
            return;
        }
        if (zm.a.world == null || zm.a.world.getScoreboard() == null) {
            return;
        }
        this.k.remove(class_12972.getId());
        try {
            Team EmptyBlockView;
            String string = "outlineESP_" + class_12972.getId();
            Team MapUpdateS2CPacket = zm.a.world.getScoreboard().getTeam(string);
            if (MapUpdateS2CPacket != null) {
                zm.a.world.getScoreboard().removeScoreHolderFromTeam(class_12972.getNameForScoreboard(), MapUpdateS2CPacket);
                zm.a.world.getScoreboard().removeTeam(MapUpdateS2CPacket);
            }
            if ((EmptyBlockView = class_12972.getScoreboardTeam()) != null && EmptyBlockView.getName().startsWith("outlineESP_")) {
                zm.a.world.getScoreboard().removeScoreHolderFromTeam(class_12972.getNameForScoreboard(), EmptyBlockView);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private boolean d(Entity class_12972) {
        if ((double)zm.a.player.distanceTo(class_12972) > this.g.f()) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity) {
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (class_16572 == zm.a.player && !this.c.b()) {
                return false;
            }
            return !this.d.b() || !this.a(class_16572);
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.e.b();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.f.b();
        }
        return false;
    }

    private boolean a(PlayerEntity class_16572) {
        if (zm.a.player.getScoreboardTeam() == null || class_16572.getScoreboardTeam() == null) {
            return false;
        }
        return zm.a.player.getScoreboardTeam().equals(class_16572.getScoreboardTeam());
    }

    private void e(Entity class_12972) {
        if (zm.a.world == null || zm.a.world.getScoreboard() == null) {
            return;
        }
        this.k.add(class_12972.getId());
        try {
            Team EmptyBlockView;
            String string = "outlineESP_" + class_12972.getId();
            Team MapUpdateS2CPacket = class_12972.getScoreboardTeam();
            if (MapUpdateS2CPacket != null && !MapUpdateS2CPacket.getName().startsWith("outlineESP_")) {
                zm.a.world.getScoreboard().removeScoreHolderFromTeam(class_12972.getNameForScoreboard(), MapUpdateS2CPacket);
            }
            if ((EmptyBlockView = zm.a.world.getScoreboard().getTeam(string)) == null) {
                EmptyBlockView = zm.a.world.getScoreboard().addTeam(string);
            }
            if (class_12972.getScoreboardTeam() != EmptyBlockView) {
                zm.a.world.getScoreboard().addScoreHolderToTeam(class_12972.getNameForScoreboard(), EmptyBlockView);
            }
            Color color = this.f(class_12972);
            EmptyBlockView.setColor(this.a(color));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private Color f(Entity class_12972) {
        if (class_12972 instanceof PlayerEntity) {
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (com.vengeance.vengeanceclient.utils.q.za.c(class_16572.getUuid())) {
                return new Color(128, 0, 128);
            }
            return this.h.h();
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.i.h();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.j.h();
        }
        return this.h.h();
    }

    private Formatting a(Color color) {
        int n = color.getRed();
        int n2 = color.getGreen();
        int n3 = color.getBlue();
        if (n > 200 && n2 < 100 && n3 < 100) {
            return Formatting.RED;
        }
        if (n < 100 && n2 > 200 && n3 < 100) {
            return Formatting.GREEN;
        }
        if (n < 100 && n2 < 100 && n3 > 200) {
            return Formatting.BLUE;
        }
        if (n > 200 && n2 > 200 && n3 < 100) {
            return Formatting.YELLOW;
        }
        if (n > 200 && n2 < 100 && n3 > 200) {
            return Formatting.LIGHT_PURPLE;
        }
        if (n < 100 && n2 > 200 && n3 > 200) {
            return Formatting.AQUA;
        }
        if (n > 200 && n2 > 200 && n3 > 200) {
            return Formatting.WHITE;
        }
        if (n < 100 && n2 < 100 && n3 < 100) {
            return Formatting.DARK_GRAY;
        }
        return Formatting.WHITE;
    }

    @Override
    public void c() {
        if (!this.d() && zm.a.world != null && zm.a.world.getScoreboard() != null) {
            try {
                HashSet<Integer> hashSet = new HashSet<Integer>(this.k);
                for (Entity entity : zm.a.world.getEntities()) {
                    if (!hashSet.contains(entity.getId())) continue;
                    this.c(entity);
                }
                ArrayList<Team> arrayList = new ArrayList<>();
                for (Team EmptyBlockView : zm.a.world.getScoreboard().getTeams()) {
                    if (!EmptyBlockView.getName().startsWith("outlineESP_")) continue;
                    arrayList.add(EmptyBlockView);
                }
                Iterator<Team> iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Team EmptyBlockView = iterator.next();
                    zm.a.world.getScoreboard().removeTeam(EmptyBlockView);
                }
                this.k.clear();
            }
            catch (Exception exception) {
                this.k.clear();
            }
        }
        super.c();
    }
}

