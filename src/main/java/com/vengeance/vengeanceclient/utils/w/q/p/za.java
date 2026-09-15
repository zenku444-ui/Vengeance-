/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  it.unimi.dsi.fastutil.chars.Char2IntArrayMap
 *  it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap
 *  it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  it.unimi.dsi.fastutil.objects.ObjectList
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.util.math.MatrixStack
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.lwjgl.opengl.GL11
 */
package com.vengeance.vengeanceclient.utils.w.q.p;

import com.google.common.base.Preconditions;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.q.p.zb;
import com.vengeance.vengeanceclient.utils.w.q.p.zc;
import com.vengeance.vengeanceclient.utils.w.zd;
import it.unimi.dsi.fastutil.chars.Char2IntArrayMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.awt.Color;
import java.awt.Font;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL11;

public class za
implements Closeable {
    private static final Char2IntArrayMap a = new Char2IntArrayMap(){
        {
            this.put('0', 0);
            this.put('1', 170);
            this.put('2', 43520);
            this.put('3', 43690);
            this.put('4', 0xAA0000);
            this.put('5', 0xAA00AA);
            this.put('6', 0xFFAA00);
            this.put('7', 0xAAAAAA);
            this.put('8', 0x555555);
            this.put('9', 0x5555FF);
            this.put('A', 0x55FF55);
            this.put('B', 0x55FFFF);
            this.put('C', 0xFF5555);
            this.put('D', 0xFF55FF);
            this.put('E', 0xFFFF55);
            this.put('F', 0xFFFFFF);
        }
    };
    private static final Object2ObjectArrayMap<Identifier, ObjectList<za>> b = new Object2ObjectArrayMap();
    private final float c;
    private final ObjectList<zc> d = new ObjectArrayList();
    private final Char2ObjectArrayMap<zb> e = new Char2ObjectArrayMap();
    private final int f;
    private final int g;
    private int h = 0;
    private Font[] i;
    private int j = -1;

    public za(Font[] fontArray, float f, int n, int n2) {
        Preconditions.checkArgument((fontArray.length > 0 ? 1 : 0) != 0, (Object)"fonts.length == 0");
        Preconditions.checkArgument((n > 4 ? 1 : 0) != 0, (Object)"Unreasonable charactersPerPage count");
        Preconditions.checkArgument((n2 > 0 ? 1 : 0) != 0, (Object)"paddingBetweenCharacters > 0");
        this.c = f;
        this.f = n;
        this.g = n2;
        this.a(fontArray, f);
    }

    public za(Font[] fontArray, float f) {
        this(fontArray, f, 256, 5);
    }

    private static int a(int n, int n2) {
        return n2 * (int)Math.floor((double)n / (double)n2);
    }

    public static String a(String string) {
        char[] cArray = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (c == '\u00a7') {
                ++i;
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void a() {
        int n = com.vengeance.vengeanceclient.utils.w.q.q.zd.e();
        if (n != this.j) {
            this.close();
            this.a(this.i, this.c);
        }
    }

    private void a(Font[] fontArray, float f) {
        this.h = this.j = com.vengeance.vengeanceclient.utils.w.q.q.zd.e();
        this.i = new Font[fontArray.length];
        for (int i = 0; i < fontArray.length; ++i) {
            this.i[i] = fontArray[i].deriveFont(f * (float)this.h);
        }
    }

    private zc a(char c, char c2) {
        zc zc2 = new zc(c, c2, this.i, com.vengeance.vengeanceclient.utils.w.q.q.zd.f(), this.g);
        this.d.add(zc2);
        return zc2;
    }

    private zb a(char c) {
        for (zc zc2 : this.d) {
            if (!zc2.b(c)) continue;
            return zc2.a(c);
        }
        int n = za.a(c, this.f);
        zc22 = this.a((char)n, (char)(n + this.f));
        return zc22.a(c);
    }

    private zb b(char c) {
        return (zb)this.e.computeIfAbsent(c, this::a);
    }

    public void a(MatrixStack class_45872, String string, float f, float f2, Color color) {
        Object object2;
        float f3 = (float)color.getRed() / 255.0f;
        float f4 = (float)color.getGreen() / 255.0f;
        float f5 = (float)color.getBlue() / 255.0f;
        float f6 = (float)color.getAlpha() / 255.0f;
        this.a();
        float f7 = f3;
        float f8 = f4;
        float f9 = f5;
        class_45872.push();
        class_45872.translate(f, f2, 0.0f);
        class_45872.scale(1.0f / (float)this.h, 1.0f / (float)this.h, 1.0f);
        zd.b();
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        char[] cArray = string.toCharArray();
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean bl = false;
        int n = 0;
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (bl) {
                bl = false;
                char c2 = Character.toUpperCase(c);
                if (a.containsKey(c2)) {
                    int n2 = a.get(c2);
                    int[] rgb = com.vengeance.vengeanceclient.utils.w.q.q.zb.c(n2);
                        f7 = (float)rgb[0] / 255.0f;
                        f8 = (float)rgb[1] / 255.0f;
                        f9 = (float)rgb[2] / 255.0f;
                    continue;
                }
                if (c2 != 'R') continue;
                f7 = f3;
                f8 = f4;
                f9 = f5;
                continue;
            }
            if (c == '\u00a7') {
                bl = true;
                continue;
            }
            if (c == '\n') {
                f11 += this.c(string.substring(n, i)) * (float)this.h;
                f10 = 0.0f;
                n = i + 1;
                continue;
            }
            zb zb2 = this.b(c);
            if (zb2.e() != ' ') {
                Identifier class_29602 = zb2.f().d;
                object2 = new za$DrawEntry(f10, f11, f7, f8, f9, zb2);
                ((ObjectList)b.computeIfAbsent((Object)class_29602, object -> new ObjectArrayList())).add(object2);
            }
            f10 += (float)zb2.c();
        }
        for (Identifier class_29603 : b.keySet()) {
            GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
            List list = (List)b.get((Object)class_29603);
            BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                object2 = (za$DrawEntry)iterator.next();
                float f12 = object2.a;
                float f13 = object2.b;
                float f14 = object2.c;
                float f15 = object2.d;
                float f16 = object2.e;
                zb zb3 = object2.f;
                zc zc2 = zb3.f();
                float f17 = zb3.c();
                float f18 = zb3.d();
                float f19 = (float)zb3.a() / (float)zc2.f;
                float f20 = (float)zb3.b() / (float)zc2.g;
                float f21 = (float)(zb3.a() + zb3.c()) / (float)zc2.f;
                float f22 = (float)(zb3.b() + zb3.d()) / (float)zc2.g;
                class_2872.vertex((Matrix4fc)matrix4f, f12 + 0.0f, f13 + f18, 0.0f).texture(f19, f22).color(f14, f15, f16, f6);
                class_2872.vertex((Matrix4fc)matrix4f, f12 + f17, f13 + f18, 0.0f).texture(f21, f22).color(f14, f15, f16, f6);
                class_2872.vertex((Matrix4fc)matrix4f, f12 + f17, f13 + 0.0f, 0.0f).texture(f21, f20).color(f14, f15, f16, f6);
                class_2872.vertex((Matrix4fc)matrix4f, f12 + 0.0f, f13 + 0.0f, 0.0f).texture(f19, f20).color(f14, f15, f16, f6);
            }
            com.vengeance.vengeanceclient.utils.w.q.q.za.a(class_2872);
        }
        class_45872.pop();
        b.clear();
    }

    public void b(MatrixStack class_45872, String string, float f, float f2, Color color) {
        this.a(class_45872, string, f - this.b(string) / 2.0f, f2, color);
    }

    public float b(String string) {
        char[] cArray = za.a(string).toCharArray();
        float f = 0.0f;
        float f2 = 0.0f;
        for (char c : cArray) {
            if (c == '\n') {
                f2 = Math.max(f, f2);
                f = 0.0f;
                continue;
            }
            zb zb2 = this.b(c);
            f += (float)zb2.c() / (float)this.h;
        }
        return Math.max(f, f2);
    }

    public float c(String string) {
        char[] cArray = za.a(string).toCharArray();
        if (cArray.length == 0) {
            cArray = new char[]{' '};
        }
        float f = 0.0f;
        float f2 = 0.0f;
        for (char c : cArray) {
            if (c == '\n') {
                if (f == 0.0f) {
                    f = (float)this.b(' ').d() / (float)this.h;
                }
                f2 += f;
                f = 0.0f;
                continue;
            }
            zb zb2 = this.b(c);
            f = Math.max((float)zb2.d() / (float)this.h, f);
        }
        return f + f2;
    }

    @Override
    public void close() {
        for (zc zc2 : this.d) {
            zc2.a();
        }
        this.d.clear();
        this.e.clear();
    }

    record za$DrawEntry(float a, float b, float c, float d, float e, zb f) {
        @Override
        @NotNull
        public String toString() {
            return "DrawEntry[atX=" + this.a + ", atY=" + this.b + ", r=" + this.c + ", g=" + this.d + ", b=" + this.e + ", toDraw=" + String.valueOf(this.f) + "]";
        }

    }
}

