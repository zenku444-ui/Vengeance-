/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.client.MinecraftClient
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.MinecraftClient;

public class zh
extends zb {
    public zh() {
        super("Teams", "Stops you from targeting teammates", za.e);
    }

    public static boolean a(Entity class_12972) {
        zh zh2 = VengeanceClient.INSTANCE.getModuleManager().a(zh.class).get();
        if (!zh2.l()) {
            return false;
        }
        if (class_12972 == null || class_12972.getName() == null || !(class_12972 instanceof LivingEntity)) {
            return false;
        }
        try {
            MinecraftClient class_3102 = MinecraftClient.getInstance();
            if (class_3102.player == null || class_3102.player.getScoreboardTeam() == null) {
                return false;
            }
            return class_3102.player.isTeammate(class_12972);
        }
        catch (IllegalStateException illegalStateException) {
            return false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}

