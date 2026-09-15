/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.math.MathHelper
 *  org.lwjgl.glfw.GLFW
 */
package com.vengeance.vengeanceclient.utils.w;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;

public class ze {
    private float a;
    private float b;
    private float c;
    private float d;
    private boolean e = false;
    private float f = 0.0f;
    private float g = 0.0f;

    public ze(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public void a() {
        boolean bl;
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        if (class_3102.mouse == null || class_3102.getWindow() == null) {
            return;
        }
        if (class_3102.currentScreen == null) {
            this.e = false;
            return;
        }
        double d = class_3102.mouse.getX() * (double)class_3102.getWindow().getScaledWidth() / (double)class_3102.getWindow().getWidth();
        double d2 = class_3102.mouse.getY() * (double)class_3102.getWindow().getScaledHeight() / (double)class_3102.getWindow().getHeight();
        boolean bl2 = bl = GLFW.glfwGetMouseButton((long)class_3102.getWindow().getHandle(), (int)0) == 1;
        if (bl) {
            if (!this.e && this.a(d, d2)) {
                this.e = true;
                this.f = (float)(d - (double)this.a);
                this.g = (float)(d2 - (double)this.b);
            }
            if (this.e) {
                this.a = (float)d - this.f;
                this.b = (float)d2 - this.g;
                this.a = MathHelper.clamp((float)this.a, (float)0.0f, (float)((float)class_3102.getWindow().getScaledWidth() - this.c));
                this.b = MathHelper.clamp((float)this.b, (float)0.0f, (float)((float)class_3102.getWindow().getScaledHeight() - this.d));
            }
        } else {
            this.e = false;
        }
    }

    public boolean a(double d, double d2) {
        return d >= (double)this.a && d <= (double)(this.a + this.c) && d2 >= (double)this.b && d2 <= (double)(this.b + this.d);
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public void a(float f) {
        this.a = f;
    }

    public void b(float f) {
        this.b = f;
    }

    public boolean d() {
        return this.e;
    }

    public float e() {
        return this.c;
    }

    public float f() {
        return this.d;
    }

    public void c(float f) {
        this.c = f;
    }

    public void d(float f) {
        this.d = f;
    }
}

