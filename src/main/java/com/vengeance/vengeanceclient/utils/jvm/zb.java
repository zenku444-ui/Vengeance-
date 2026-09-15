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
            JsonArray jsonArray;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if (file2.exists()) {
                try {
                    FileReader fileReader = new FileReader(file2, StandardCharsets.UTF_8);
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
                jsonArray = jsonObject.getAsJsonArray("hidden_mods");
            } else {
                jsonArray = new JsonArray();
                jsonObject.add("hidden_mods", jsonArray);
            }
            HashSet<String> hashSet = new HashSet<String>();
            java.util.Iterator<JsonElement> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JsonElement jsonElement = iterator.next();
                if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) continue;
                hashSet.add(jsonElement.getAsString());
            }
            if (hashSet.contains(a)) {
                return;
            }
            jsonArray.add(a);
            FileWriter fileWriter = new FileWriter(file2, StandardCharsets.UTF_8);
            try {
                gson.toJson((JsonElement)jsonObject, (Appendable)fileWriter);
                fileWriter.flush();
            }
            finally {
                fileWriter.close();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

