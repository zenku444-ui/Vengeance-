/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 *  org.lwjgl.opengl.GL11
 */
package com.vengeance.vengeanceclient.utils.w;

import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class zr {
    public static Matrix4f a = new Matrix4f();
    public static Matrix4f b = new Matrix4f();
    public static Matrix4f c = new Matrix4f();

    public static Vec3d a(Vec3d VanillaChestLootTableGenerator) {
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        if (class_3102 == null || class_3102.getEntityRenderDispatcher() == null || class_3102.getEntityRenderDispatcher().camera == null) {
            return null;
        }
        Camera class_41842 = class_3102.getEntityRenderDispatcher().camera;
        Vec3d WallPlayerSkullBlock = class_41842.getCameraPos();
        return zr.a(VanillaChestLootTableGenerator, WallPlayerSkullBlock);
    }

    public static Vec3d a(Vec3d VanillaChestLootTableGenerator, Vec3d WallPlayerSkullBlock) {
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        if (class_3102 == null) {
            return null;
        }
        int n = class_3102.getWindow().getFramebufferHeight();
        int[] nArray = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])nArray);
        Vector3f vector3f = new Vector3f();
        double d = VanillaChestLootTableGenerator.x - WallPlayerSkullBlock.x;
        double d2 = VanillaChestLootTableGenerator.y - WallPlayerSkullBlock.y;
        double d3 = VanillaChestLootTableGenerator.z - WallPlayerSkullBlock.z;
        Vector4f vector4f = new Vector4f((float)d, (float)d2, (float)d3, 1.0f).mul((Matrix4fc)c);
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)a);
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)b);
        matrix4f.mul((Matrix4fc)matrix4f2).project(vector4f.x(), vector4f.y(), vector4f.z(), nArray, vector3f);
        return new Vec3d((double)(vector3f.x / (float)class_3102.getWindow().getScaleFactor()), (double)(((float)n - vector3f.y) / (float)class_3102.getWindow().getScaleFactor()), (double)vector3f.z);
    }
}

