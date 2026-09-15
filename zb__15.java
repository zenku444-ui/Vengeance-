/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.fabricmc.loader.api.FabricLoader
 */
package com.vengeance.vengeanceclient.utils.jvm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import net.fabricmc.loader.api.FabricLoader;

public final class zb {
    private static final String a = "vengeance-client";

    public static void a() {
        File file = FabricLoader.getInstance().getConfigDir().toFile();
        File file2 = new File(file, "modmenu.json");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            JsonObject jsonObject;
            FileReader fileReader;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if (file2.exists()) {
                try {
                    fileReader = new FileReader(file2, StandardCharsets.UTF_8);
                    try {
                        jsonObject = (JsonObject)gson.fromJson((Reader)fileReader, JsonObject.class);
                        if (jsonObject == null) {
                            jsonObject = new JsonObject();
                        }
                    }
                    finally {
                        fileReader.close();
                    }
                }
                catch (Exception exception) {
                    jsonObject = new JsonObject();
                }
            } else {
                jsonObject = new JsonObject();
            }
            if (jsonObject.has("hidden_mods") && jsonObject.get("hidden_mods").isJsonArray()) {
                fileReader = jsonObject.getAsJsonArray("hidden_mods");
            } else {
                fileReader = new JsonArray();
                jsonObject.add("hidden_mods", (JsonElement)fileReader);
            }
            HashSet<String> hashSet = new HashSet<String>();
            Object object = fileReader.iterator();
            while (object.hasNext()) {
                JsonElement jsonElement = (JsonElement)object.next();
                if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) continue;
                hashSet.add(jsonElement.getAsString());
            }
            if (hashSet.contains(a)) {
                return;
            }
            fileReader.add(a);
            object = new FileWriter(file2, StandardCharsets.UTF_8);
            try {
                gson.toJson((JsonElement)jsonObject, (Appendable)object);
                ((OutputStreamWriter)object).flush();
            }
            finally {
                ((OutputStreamWriter)object).close();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

