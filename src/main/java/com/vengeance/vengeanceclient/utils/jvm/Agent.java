/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.jvm;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.net.URI;
import java.net.URL;

public class Agent {
    public static void premain(String string, Instrumentation instrumentation) {
        try {
            Agent.injectMod();
        }
        catch (Exception exception) {
            System.err.println("Failed to inject mod via agent: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    private static void injectMod() throws Exception {
        String string = Agent.getCurrentJarPath();
        if (string == null) {
            throw new Exception("Could not determine JAR file path");
        }
        File file = new File(string);
        if (!file.exists()) {
            throw new Exception("JAR file does not exist: " + string);
        }
        String string2 = System.getProperty("fabric.addMods");
        if (string2 == null || string2.isEmpty()) {
            System.setProperty("fabric.addMods", string);
        } else {
            System.setProperty("fabric.addMods", string2 + File.pathSeparator + string);
        }
        System.out.println("[Vengeance Client Agent] Successfully injected mod: " + string);
    }

    private static String getCurrentJarPath() {
        try {
            URI uRI;
            URL uRL = Agent.class.getProtectionDomain().getCodeSource().getLocation();
            String string = uRL.toString();
            if (string.startsWith("jar:file:")) {
                int n = string.indexOf(33);
                string = n >= 0 ? string.substring(9, n) : string.substring(9);
                uRI = new URI(string);
            } else {
                uRI = uRL.toURI();
            }
            File file = new File(uRI);
            String string2 = file.getAbsolutePath();
            System.out.println("[Vengeance Client Agent] Detected JAR path: " + string2);
            return string2;
        }
        catch (Exception exception) {
            System.err.println("[Vengeance Client Agent] Error getting JAR path: " + exception.getMessage());
            exception.printStackTrace();
            return null;
        }
    }
}

