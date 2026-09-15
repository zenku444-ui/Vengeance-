/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  org.joml.Matrix3f
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package com.vengeance.vengeanceclient.utils.w.q.q;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class zc
extends MatrixStack {
    private static final MethodHandle a;
    private final boolean b = a != null;
    private final ObjectArrayList<za> c = new ObjectArrayList(8);
    private za d;

    public zc() {
        if (this.b) {
            this.d = new za(new Matrix4f(), new Matrix3f());
            this.c.add((Object)this.d);
        }
    }

    public void translate(float f, float f2, float f3) {
        if (!this.b) {
            super.translate(f, f2, f3);
            return;
        }
        this.d.a.translate(f, f2, f3);
    }

    public void scale(float f, float f2, float f3) {
        if (!this.b) {
            super.scale(f, f2, f3);
            return;
        }
        this.d.a.scale(f, f2, f3);
        if (f == f2 && f2 == f3) {
            if (f != 0.0f) {
                this.d.b.scale(Math.signum(f));
            }
            return;
        }
        float f4 = 1.0f / f;
        float f5 = 1.0f / f2;
        float f6 = 1.0f / f3;
        float f7 = (float)(1.0 / Math.cbrt(f4 * f5 * f6));
        this.d.b.scale(f7 * f4, f7 * f5, f7 * f6);
    }

    public void a(Quaternionf quaternionf) {
        if (!this.b) {
            super.multiply((Quaternionfc)quaternionf);
            return;
        }
        this.d.a.rotate((Quaternionfc)quaternionf);
        this.d.b.rotate((Quaternionfc)quaternionf);
    }

    public void a(Quaternionf quaternionf, float f, float f2, float f3) {
        if (!this.b) {
            super.multiply((Quaternionfc)quaternionf, f, f2, f3);
            return;
        }
        this.d.a.rotateAround((Quaternionfc)quaternionf, f, f2, f3);
        this.d.b.rotate((Quaternionfc)quaternionf);
    }

    public void a(Matrix4f matrix4f) {
        if (!this.b) {
            super.multiplyPositionMatrix((Matrix4fc)matrix4f);
            return;
        }
        this.d.a.mul((Matrix4fc)matrix4f);
    }

    public void push() {
        if (!this.b) {
            super.push();
            return;
        }
        this.d = new za(new Matrix4f((Matrix4fc)this.d.a), new Matrix3f((Matrix3fc)this.d.b));
        this.c.add((Object)this.d);
    }

    public void pop() {
        if (!this.b) {
            super.pop();
            return;
        }
        if (this.c.size() == 1) {
            throw new IllegalStateException("Trying to pop an empty stack");
        }
        this.c.pop();
        this.d = (za)this.c.top();
    }

    public MatrixStack.Entry peek() {
        if (!this.b) {
            return super.peek();
        }
        try {
            return (MatrixStack.Entry)a.invoke(this.d.a, this.d.b);
        }
        catch (Throwable throwable) {
            return super.peek();
        }
    }

    public boolean isEmpty() {
        if (!this.b) {
            return super.isEmpty();
        }
        return this.c.size() == 1;
    }

    public void loadIdentity() {
        if (!this.b) {
            super.loadIdentity();
            return;
        }
        this.d.a.identity();
        this.d.b.identity();
    }

    static {
        MethodHandle methodHandle = null;
        try {
            MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(MatrixStack.Entry.class, MethodHandles.lookup());
            methodHandle = lookup.findConstructor(MatrixStack.Entry.class, MethodType.methodType(Void.TYPE, Matrix4f.class, Matrix3f.class));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        a = methodHandle;
    }

    private record za(Matrix4f a, Matrix3f b) {
        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{za.class, "positionMatrix;normalMatrix", "a", "b"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{za.class, "positionMatrix;normalMatrix", "a", "b"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{za.class, "positionMatrix;normalMatrix", "a", "b"}, this, object);
        }
    }
}

