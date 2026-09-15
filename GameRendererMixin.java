/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.client.render.RenderTickCounter
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package com.vengeance.vengeanceclient.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.p.p.t.zb;
import com.vengeance.vengeanceclient.r.q.u.zc;
import com.vengeance.vengeanceclient.utils.w.q.q.zd;
import com.vengeance.vengeanceclient.utils.w.zr;
import java.lang.reflect.Method;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.RenderTickCounter;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={GameRenderer.class})
public class GameRendererMixin {
    @ModifyArgs(method={"getBasicProjectionMatrix(F)Lorg/joml/Matrix4f;"}, at=@At(value="INVOKE", target="Lorg/joml/Matrix4f;perspective(FFFF)Lorg/joml/Matrix4f;"))
    private void modifyAspectRatio(Args args) {
        float f = zc.o();
        if (f > 0.0f) {
            args.set(1, (Object)Float.valueOf(f));
        }
    }

    @Inject(method={"renderWorld(Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="HEAD")})
    private void renderHand(RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        Camera class_41842 = class_3102.gameRenderer.getCamera();
        float f = class_97792.getTickProgress(true);
        MatrixStack class_45872 = new MatrixStack();
        class_45872.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(class_41842.getPitch()));
        class_45872.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(class_41842.getYaw() + 180.0f));
        Vec3d VanillaChestLootTableGenerator = class_41842.getCameraPos();
        class_45872.translate(-VanillaChestLootTableGenerator.x, -VanillaChestLootTableGenerator.y, -VanillaChestLootTableGenerator.z);
        GameRendererMixin.captureProjectionData(class_3102, class_45872, f);
        VengeanceClient.INSTANCE.getEventBus().post(new zb(class_45872));
    }

    private static void captureProjectionData(MinecraftClient class_3102, MatrixStack class_45872, float f) {
        Matrix4f matrix4f;
        Matrix4f matrix4f2 = GameRendererMixin.invokeGameRendererProjection(class_3102.gameRenderer, f);
        if (matrix4f2 == null) {
            matrix4f2 = GameRendererMixin.invokeRenderSystemMatrix("getProjectionMatrix");
        }
        if (matrix4f2 != null) {
            zr.a.set((Matrix4fc)matrix4f2);
            zd.a.set((Matrix4fc)matrix4f2);
        }
        if ((matrix4f = GameRendererMixin.invokeRenderSystemMatrix("getModelViewMatrix")) != null) {
            zr.b.set((Matrix4fc)matrix4f);
            zd.b.set((Matrix4fc)matrix4f);
        }
        Matrix4f matrix4f3 = class_45872.peek().getPositionMatrix();
        zr.c.set((Matrix4fc)matrix4f3);
        zd.c.set((Matrix4fc)matrix4f3);
    }

    private static Matrix4f invokeGameRendererProjection(GameRenderer class_7572, float f) {
        try {
            Method method = GameRenderer.class.getDeclaredMethod("getProjectionMatrix", Float.TYPE);
            method.setAccessible(true);
            Object object = method.invoke((Object)class_7572, Float.valueOf(f));
            if (object instanceof Matrix4f) {
                Matrix4f matrix4f = (Matrix4f)object;
                return new Matrix4f((Matrix4fc)matrix4f);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            return new Matrix4f((Matrix4fc)class_7572.getBasicProjectionMatrix(70.0f));
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Matrix4f invokeRenderSystemMatrix(String string) {
        try {
            Object object = RenderSystem.class.getMethod(string, new Class[0]).invoke(null, new Object[0]);
            if (object instanceof Matrix4f) {
                Matrix4f matrix4f = (Matrix4f)object;
                return new Matrix4f((Matrix4fc)matrix4f);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return null;
    }
}

