/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.render.RenderLayers
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.BuiltBuffer
 */
package com.vengeance.vengeanceclient.utils.w.q.q;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;

public final class za {
    private za() {
    }

    public static void a(BufferBuilder class_2872) {
        try (BuiltBuffer class_98012 = class_2872.end();){
            try {
                za.a(class_98012.getDrawParameters().mode()).draw(class_98012);
            }
            catch (Throwable throwable) {
                try {
                    Class<?> clazz = Class.forName("net.minecraft.client.render.BufferRenderer");
                    clazz.getMethod("drawWithGlobalProgram", BuiltBuffer.class).invoke(null, class_98012);
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
            }
        }
    }

    public static void a(BufferBuilder class_2872, RenderLayer class_19212) {
        try (BuiltBuffer class_98012 = class_2872.end();){
            class_19212.draw(class_98012);
        }
    }

    private static RenderLayer a(VertexFormat.DrawMode class_55962) {
        return switch (class_55962) {
            case DEBUG_LINES -> RenderLayers.linesTranslucent();
            case TRIANGLES -> RenderLayers.debugFilledBox();
            case TRIANGLE_FAN -> RenderLayers.debugTriangleFan();
            case QUADS -> RenderLayers.debugQuads();
            default -> RenderLayers.debugQuads();
        };
    }
}

