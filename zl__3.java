/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.gl.Framebuffer
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.utils.w.zp;
import java.awt.Color;
import java.lang.reflect.Field;
import net.minecraft.client.gl.Framebuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class zl {
    private static final String a = "entity_outline";
    private static final float[] b = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static int c = -1;
    private static int d = -1;
    private static boolean e = false;

    private zl() {
    }

    public static void a() {
        if (e) {
            return;
        }
        int n = zp.a(a, "shaders/post/entity_outline.vsh", "shaders/post/entity_outline.fsh");
        if (n == 0) {
            return;
        }
        c = GL30.glGenVertexArrays();
        d = GL20.glGenBuffers();
        GL30.glBindVertexArray((int)c);
        GL20.glBindBuffer((int)34962, (int)d);
        GL20.glBufferData((int)34962, (float[])b, (int)35044);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)8, (long)0L);
        GL20.glEnableVertexAttribArray((int)0);
        GL20.glBindBuffer((int)34962, (int)0);
        GL30.glBindVertexArray((int)0);
        e = true;
    }

    public static void a(Framebuffer class_2762, Color color, float f, float f2) {
        zl.a(class_2762, color, f, f2, false, 0.2f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(Framebuffer class_2762, Color color, float f, float f2, boolean bl, float f3) {
        if (!e) {
            zl.a();
        }
        if (!e || class_2762 == null) {
            return;
        }
        Integer n = zp.b(a);
        if (n == null || n == 0) {
            return;
        }
        int[] nArray = new int[1];
        int[] nArray2 = new int[1];
        int[] nArray3 = new int[1];
        GL11.glGetIntegerv((int)34229, (int[])nArray);
        GL11.glGetIntegerv((int)35725, (int[])nArray2);
        GL11.glGetIntegerv((int)36006, (int[])nArray3);
        boolean bl2 = GL11.glIsEnabled((int)3042);
        boolean bl3 = GL11.glIsEnabled((int)2929);
        int[] nArray4 = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])nArray4);
        int n2 = nArray4[2];
        int n3 = nArray4[3];
        try {
            GlStateManager._disableDepthTest();
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL30.glBindVertexArray((int)c);
            zp.a(a);
            int n4 = zl.a(class_2762.getColorAttachment());
            if (n4 == -1) {
                return;
            }
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)n4);
            zp.a(a, "DiffuseSampler", 0);
            zp.a(a, "ScreenSize", n2, n3);
            zp.a(a, "OutlineColor", (float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
            zp.a(a, "OutlineWidth", f);
            zp.a(a, "Intensity", f2);
            zp.a(a, "ShowFill", bl ? 1.0f : 0.0f);
            zp.a(a, "FillAlpha", f3);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
        }
        finally {
            GL30.glBindVertexArray((int)nArray[0]);
            GL20.glUseProgram((int)nArray2[0]);
            GL30.glBindFramebuffer((int)36160, (int)nArray3[0]);
            if (bl3) {
                GlStateManager._enableDepthTest();
            } else {
                GlStateManager._disableDepthTest();
            }
            if (!bl2) {
                GlStateManager._disableBlend();
            }
        }
    }

    public static void b() {
        if (c != -1) {
            GL30.glDeleteVertexArrays((int)c);
            c = -1;
        }
        if (d != -1) {
            GL20.glDeleteBuffers((int)d);
            d = -1;
        }
        e = false;
    }

    private static int a(Object object) {
        Object object2;
        if (object == null) {
            return -1;
        }
        for (String string : new String[]{"getGlId", "glId", "getId", "id", "getHandle", "handle"}) {
            try {
                object2 = object.getClass().getMethod(string, new Class[0]).invoke(object, new Object[0]);
                if (!(object2 instanceof Integer)) continue;
                Integer n = (Integer)object2;
                return n;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        for (String string : new String[]{"glId", "id", "handle"}) {
            try {
                object2 = object.getClass().getDeclaredField(string);
                ((Field)object2).setAccessible(true);
                Object object3 = ((Field)object2).get(object);
                if (!(object3 instanceof Integer)) continue;
                Integer n = (Integer)object3;
                return n;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return -1;
    }
}

