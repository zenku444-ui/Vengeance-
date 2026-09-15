/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package com.vengeance.vengeanceclient.utils.jvm;

import java.lang.management.ManagementFactory;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.MinecraftClient;

public class za {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final List<String> b = Arrays.asList("net.java.dev.jna", "org.python", "jdk.nashorn", "org.mozilla.javascript", "bsh", "javassist", "cfr", "procyon", "jadx", "jd-gui", "jd-core", "enjarify", " Krakatau", "luyten", " FernFlower", " CFR");
    private static final List<String> c = Arrays.asList("-agentlib:jdwp", "-Xrunjdwp", "-Xdebug", "-javaagent:");

    public static boolean a() {
        if (a.get()) {
            return false;
        }
        try {
            if (za.c()) {
                za.a("Debugger detected");
                return false;
            }
            if (za.d()) {
                za.a("Decompiler detected");
                return false;
            }
            if (za.e()) {
                za.a("Suspicious classes detected");
                return false;
            }
            return true;
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static boolean c() {
        try {
            for (String string : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
                for (String string2 : c) {
                    if (!string.toLowerCase().contains(string2.toLowerCase())) continue;
                    return true;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    private static boolean d() {
        try {
            ClassLoader classLoader = za.class.getClassLoader();
            for (String string : b) {
                try {
                    Class.forName(string, false, classLoader);
                    return true;
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    private static boolean e() {
        try {
            Package[] packageArray = Package.getPackages();
            int n = 0;
            for (Package package_ : packageArray) {
                String string = package_.getName().toLowerCase();
                if (!string.contains("decompiler") && !string.contains("disassembler") && !string.contains("instrumentation")) continue;
                ++n;
            }
            return n > 3;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static void a(String string) {
        a.set(true);
        try {
            if (MinecraftClient.getInstance() != null) {
                MinecraftClient.getInstance().execute(() -> {
                    try {
                        if (MinecraftClient.getInstance().currentScreen != null) {
                            MinecraftClient.getInstance().currentScreen.close();
                        }
                        MinecraftClient.getInstance().stop();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                });
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            Thread.sleep(100L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        System.exit(1);
    }

    public static String b() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("vengeance-client");
            stringBuilder.append("-v1.0");
            stringBuilder.append("-release");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(stringBuilder.toString().getBytes());
            StringBuilder stringBuilder2 = new StringBuilder();
            for (byte by : byArray) {
                String string = Integer.toHexString(0xFF & by);
                if (string.length() == 1) {
                    stringBuilder2.append('0');
                }
                stringBuilder2.append(string);
            }
            return stringBuilder2.substring(0, 16);
        }
        catch (Exception exception) {
            return "fallback";
        }
    }

    public static boolean b(String string) {
        String string2 = za.b();
        return string2.equals(string);
    }
}

