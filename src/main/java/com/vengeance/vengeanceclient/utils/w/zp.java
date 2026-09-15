/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.resource.Resource
 *  org.lwjgl.opengl.GL20
 */
package com.vengeance.vengeanceclient.utils.w;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import org.lwjgl.opengl.GL20;

public class zp {
    private static final Map<String, Integer> a = new HashMap<String, Integer>();
    private static final Map<String, Integer> b = new HashMap<String, Integer>();
    private static final Map<String, Integer> c = new HashMap<String, Integer>();

    public static int a(String string, String string2, String string3) {
        if (a.containsKey(string)) {
            return a.get(string);
        }
        int n = zp.a(string2, 35633);
        int n2 = zp.a(string3, 35632);
        if (n == 0 || n2 == 0) {
            return 0;
        }
        int n3 = GL20.glCreateProgram();
        GL20.glAttachShader((int)n3, (int)n);
        GL20.glAttachShader((int)n3, (int)n2);
        GL20.glLinkProgram((int)n3);
        if (GL20.glGetProgrami((int)n3, (int)35714) == 0) {
            System.err.println("Failed to link shader program: " + GL20.glGetProgramInfoLog((int)n3));
            GL20.glDeleteProgram((int)n3);
            return 0;
        }
        b.put(string, n);
        c.put(string, n2);
        a.put(string, n3);
        return n3;
    }

    private static int a(String string, int n) {
        try {
            String string2;
            Identifier class_29602 = Identifier.of((String)"vengeance-client", (String)string);
            Resource class_32982 = MinecraftClient.getInstance().getResourceManager().getResource(class_29602).orElse(null);
            if (class_32982 == null) {
                System.err.println("Could not find shader: " + string);
                return 0;
            }
            try (InputStream inputStream = class_32982.getInputStream();){
                string2 = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
            int n2 = GL20.glCreateShader((int)n);
            GL20.glShaderSource((int)n2, (CharSequence)string2);
            GL20.glCompileShader((int)n2);
            if (GL20.glGetShaderi((int)n2, (int)35713) == 0) {
                System.err.println("Failed to compile shader " + string + ": " + GL20.glGetShaderInfoLog((int)n2));
                GL20.glDeleteShader((int)n2);
                return 0;
            }
            return n2;
        }
        catch (IOException iOException) {
            System.err.println("Failed to load shader " + string + ": " + iOException.getMessage());
            return 0;
        }
    }

    public static void a(String string) {
        Integer n = a.get(string);
        if (n != null) {
            GL20.glUseProgram((int)n);
        }
    }

    public static void a() {
        GL20.glUseProgram((int)0);
    }

    public static int a(String string, String string2) {
        Integer n = a.get(string);
        if (n != null) {
            return GL20.glGetUniformLocation((int)n, (CharSequence)string2);
        }
        return -1;
    }

    public static void a(String string, String string2, float f, float f2) {
        int n = zp.a(string, string2);
        if (n != -1) {
            GL20.glUniform2f((int)n, (float)f, (float)f2);
        }
    }

    public static void a(String string, String string2, float f) {
        int n = zp.a(string, string2);
        if (n != -1) {
            GL20.glUniform1f((int)n, (float)f);
        }
    }

    public static void a(String string, String string2, float f, float f2, float f3, float f4) {
        int n = zp.a(string, string2);
        if (n != -1) {
            GL20.glUniform4f((int)n, (float)f, (float)f2, (float)f3, (float)f4);
        }
    }

    public static void a(String string, String string2, int n) {
        int n2 = zp.a(string, string2);
        if (n2 != -1) {
            GL20.glUniform1i((int)n2, (int)n);
        }
    }

    public static Integer b(String string) {
        return a.get(string);
    }

    public static void b() {
        for (int n : a.values()) {
            GL20.glDeleteProgram((int)n);
        }
        for (int n : b.values()) {
            GL20.glDeleteShader((int)n);
        }
        for (int n : c.values()) {
            GL20.glDeleteShader((int)n);
        }
        a.clear();
        b.clear();
        c.clear();
    }
}

