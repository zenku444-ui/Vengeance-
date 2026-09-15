/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.entity.EntityRenderManager
 */
package com.vengeance.vengeanceclient.utils.w;

import net.minecraft.entity.Entity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderManager;

public final class zc {
    private zc() {
    }

    public static void a(EntityRenderManager TrialSpawnerDetectionParticle, Entity class_12972, double d, double d2, double d3, float f, float f2, MatrixStack class_45872, VertexConsumerProvider class_45972, int n) {
        try {
            TrialSpawnerDetectionParticle.getClass().getMethod("render", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, MatrixStack.class, VertexConsumerProvider.class, Integer.TYPE).invoke((Object)TrialSpawnerDetectionParticle, class_12972, d, d2, d3, Float.valueOf(f), class_45872, class_45972, n);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            TrialSpawnerDetectionParticle.getClass().getMethod("render", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE, MatrixStack.class, VertexConsumerProvider.class, Integer.TYPE).invoke((Object)TrialSpawnerDetectionParticle, class_12972, d, d2, d3, Float.valueOf(f), Float.valueOf(f2), class_45872, class_45972, n);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

