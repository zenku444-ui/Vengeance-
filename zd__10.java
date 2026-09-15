/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.NativeImageBackedTexture
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.util.math.MatrixStack
 *  org.jetbrains.annotations.ApiStatus$Internal
 *  org.jetbrains.annotations.Contract
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package com.vengeance.vengeanceclient.utils.w.q.q;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.utils.w.q.q.zc;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;
import lombok.NonNull;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class zd {
    @ApiStatus.Internal
    public static final Matrix4f a = new Matrix4f();
    @ApiStatus.Internal
    public static final Matrix4f b = new Matrix4f();
    @ApiStatus.Internal
    public static final Matrix4f c = new Matrix4f();
    private static final zc d = new zc();
    private static final MinecraftClient e = MinecraftClient.getInstance();
    private static final char f = 'a';
    private static final char g = 'z';
    private static final Random h = new Random();

    public static void a() {
        GlStateManager._disableCull();
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
    }

    public static void b() {
        GlStateManager._disableBlend();
        GlStateManager._enableCull();
        GlStateManager._depthFunc((int)515);
    }

    public static int a(int n, int n2, double d) {
        return (int)Math.floor((double)n + (double)(n2 - n) * MathHelper.clamp((double)d, (double)0.0, (double)1.0));
    }

    public static double a(double d, double d2, double d3) {
        return d + (d2 - d) * MathHelper.clamp((double)d3, (double)0.0, (double)1.0);
    }

    @Contract(value="_, _, _ -> new", pure=true)
    public static Color a(@NonNull Color color, @NonNull Color color2, double d) {
        if (color == null) {
            throw new NullPointerException("a is marked non-null but is null");
        }
        if (color2 == null) {
            throw new NullPointerException("b is marked non-null but is null");
        }
        return new Color(zd.a(color.getRed(), color2.getRed(), d), zd.a(color.getGreen(), color2.getGreen(), d), zd.a(color.getBlue(), color2.getBlue(), d), zd.a(color.getAlpha(), color2.getAlpha(), d));
    }

    @Contract(value="_, _, _, _, _ -> new", pure=true)
    public static Color a(@NonNull Color color, int n, int n2, int n3, int n4) {
        if (color == null) {
            throw new NullPointerException("original is marked non-null but is null");
        }
        return new Color(n == -1 ? color.getRed() : n, n2 == -1 ? color.getGreen() : n2, n3 == -1 ? color.getBlue() : n3, n4 == -1 ? color.getAlpha() : n4);
    }

    @Contract(value="_, _ -> new", pure=true)
    public static Vec3d a(@NonNull MatrixStack class_45872, @NonNull Vec3d VanillaChestLootTableGenerator) {
        if (class_45872 == null) {
            throw new NullPointerException("stack is marked non-null but is null");
        }
        if (VanillaChestLootTableGenerator == null) {
            throw new NullPointerException("in is marked non-null but is null");
        }
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        Vector4f vector4f = new Vector4f((float)VanillaChestLootTableGenerator.x, (float)VanillaChestLootTableGenerator.y, (float)VanillaChestLootTableGenerator.z, 1.0f);
        vector4f.mul((Matrix4fc)matrix4f);
        return new Vec3d((double)vector4f.x(), (double)vector4f.y(), (double)vector4f.z());
    }

    public static void a(@NonNull Identifier class_29602, @NonNull BufferedImage bufferedImage) {
        if (class_29602 == null) {
            throw new NullPointerException("i is marked non-null but is null");
        }
        if (bufferedImage == null) {
            throw new NullPointerException("bi is marked non-null but is null");
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)bufferedImage, "png", byteArrayOutputStream);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            ByteBuffer byteBuffer = BufferUtils.createByteBuffer((int)byArray.length).put(byArray);
            byteBuffer.flip();
            NativeImageBackedTexture BundleSelectedItemModel = new NativeImageBackedTexture(zd::g, NativeImage.read((ByteBuffer)byteBuffer));
            MinecraftClient.getInstance().execute(() -> MinecraftClient.getInstance().getTextureManager().registerTexture(class_29602, (AbstractTexture)BundleSelectedItemModel));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static MatrixStack c() {
        if (!d.isEmpty()) {
            throw new IllegalStateException("Supposed \"empty\" stack is not actually empty; someone does not clean up after themselves.");
        }
        d.loadIdentity();
        return d;
    }

    @Contract(value="-> new")
    public static Vec3d d() {
        Camera class_41842 = zd.e.gameRenderer.getCamera();
        float f = (float)Math.PI;
        float f2 = (float)Math.toRadians(-class_41842.getYaw());
        float f3 = (float)Math.toRadians(-class_41842.getPitch());
        float f4 = MathHelper.cos((double)(f2 - f));
        float f5 = MathHelper.sin((double)(f2 - f));
        float f6 = -MathHelper.cos((double)f3);
        float f7 = MathHelper.sin((double)f3);
        return new Vec3d((double)(f5 * f6), (double)f7, (double)(f4 * f6)).add(class_41842.getCameraPos());
    }

    @Contract(value="_ -> new", pure=true)
    public static Vec3d a(@NonNull Vec3d VanillaChestLootTableGenerator) {
        if (VanillaChestLootTableGenerator == null) {
            throw new NullPointerException("pos is marked non-null but is null");
        }
        Camera class_41842 = zd.e.getEntityRenderDispatcher().camera;
        int n = e.getWindow().getFramebufferHeight();
        int[] nArray = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])nArray);
        Vector3f vector3f = new Vector3f();
        double d = VanillaChestLootTableGenerator.x - class_41842.getCameraPos().x;
        double d2 = VanillaChestLootTableGenerator.y - class_41842.getCameraPos().y;
        double d3 = VanillaChestLootTableGenerator.z - class_41842.getCameraPos().z;
        Vector4f vector4f = new Vector4f((float)d, (float)d2, (float)d3, 1.0f).mul((Matrix4fc)c);
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)a);
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)b);
        matrix4f.mul((Matrix4fc)matrix4f2).project(vector4f.x(), vector4f.y(), vector4f.z(), nArray, vector3f);
        return new Vec3d((double)(vector3f.x / (float)e.getWindow().getScaleFactor()), (double)(((float)n - vector3f.y) / (float)e.getWindow().getScaleFactor()), (double)vector3f.z);
    }

    public static boolean b(Vec3d VanillaChestLootTableGenerator) {
        return VanillaChestLootTableGenerator != null && VanillaChestLootTableGenerator.z > -1.0 && VanillaChestLootTableGenerator.z < 1.0;
    }

    @Contract(value="_,_,_ -> new", pure=true)
    public static Vec3d b(double d, double d2, double d3) {
        Camera class_41842 = zd.e.getEntityRenderDispatcher().camera;
        int n = e.getWindow().getScaledHeight();
        int n2 = e.getWindow().getScaledWidth();
        int[] nArray = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])nArray);
        Vector3f vector3f = new Vector3f();
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)a);
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)b);
        matrix4f.mul((Matrix4fc)matrix4f2).mul((Matrix4fc)c).unproject((float)d / (float)n2 * (float)nArray[2], (float)((double)n - d2) / (float)n * (float)nArray[3], (float)d3, nArray, vector3f);
        return new Vec3d((double)vector3f.x, (double)vector3f.y, (double)vector3f.z).add(class_41842.getCameraPos());
    }

    public static int e() {
        return MinecraftClient.getInstance().getWindow().getScaleFactor();
    }

    private static String g() {
        return IntStream.range(0, 32).mapToObj(n -> String.valueOf((char)h.nextInt(97, 123))).collect(Collectors.joining());
    }

    @Contract(value="-> new", pure=true)
    public static Identifier f() {
        return Identifier.of((String)"renderer", (String)("temp/" + zd.g()));
    }
}

