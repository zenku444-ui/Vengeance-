/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.systems.RenderSystem;

public final class zd {
    private zd() {
    }

    public static void a() {
        try {
            Class<?> clazz = Class.forName("net.minecraft.client.render.ShaderProgramKeys");
            Object object = clazz.getField("POSITION_COLOR").get(null);
            Class<?> clazz2 = Class.forName("net.minecraft.client.render.ShaderProgramKey");
            RenderSystem.class.getMethod("setShader", clazz2).invoke(null, object);
            return;
        }
        catch (Throwable throwable) {
            try {
                Class<?> clazz = Class.forName("net.minecraft.client.render.GameRenderer");
                Object object = clazz.getMethod("getPositionColorProgram", new Class[0]).invoke(null, new Object[0]);
                Class<?> clazz3 = Class.forName("net.minecraft.client.gl.ShaderProgram");
                RenderSystem.class.getMethod("setShader", clazz3).invoke(null, object);
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            return;
        }
    }

    public static void b() {
        try {
            Class<?> clazz = Class.forName("net.minecraft.client.render.ShaderProgramKeys");
            Object object = clazz.getField("POSITION_TEX_COLOR").get(null);
            Class<?> clazz2 = Class.forName("net.minecraft.client.render.ShaderProgramKey");
            RenderSystem.class.getMethod("setShader", clazz2).invoke(null, object);
            return;
        }
        catch (Throwable throwable) {
            try {
                Class<?> clazz = Class.forName("net.minecraft.client.render.GameRenderer");
                Object object = clazz.getMethod("getPositionTexColorProgram", new Class[0]).invoke(null, new Object[0]);
                Class<?> clazz3 = Class.forName("net.minecraft.client.gl.ShaderProgram");
                RenderSystem.class.getMethod("setShader", clazz3).invoke(null, object);
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            return;
        }
    }
}

