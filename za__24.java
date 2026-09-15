/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Formatting
 *  net.minecraft.text.Text
 *  net.minecraft.text.Style
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.TextColor
 */
package com.vengeance.vengeanceclient.utils.t;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.utils.zb;
import java.awt.Color;
import java.util.Objects;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.text.MutableText;
import net.minecraft.text.TextColor;

public final class za
implements zb {
    private static final MutableText a = Text.empty().setStyle(Style.EMPTY.withFormatting(Formatting.GRAY));

    public static void a(String string) {
        za.a((Text)Text.literal((String)string));
    }

    public static void a(Text class_25612) {
        za.a(class_25612.copy().withColor(za.a.a()), true);
    }

    public static void b(String string) {
        za.b((Text)Text.literal((String)string));
    }

    public static void b(Text class_25612) {
        if (Objects.isNull(za.w.inGameHud)) {
            VengeanceClient.INSTANCE.getLogger().warn(class_25612.getString());
            return;
        }
        za.a(class_25612.copy().withColor(za.b.a()), true);
    }

    public static void c(String string) {
        za.c((Text)Text.literal((String)string));
    }

    public static void c(Text class_25612) {
        if (Objects.isNull(za.w.inGameHud)) {
            VengeanceClient.INSTANCE.getLogger().error(class_25612.getString());
            return;
        }
        za.a(class_25612.copy().withColor(za.c.a()), true);
    }

    public static void a(boolean bl) {
        za.a(Text.literal((String)" "), bl);
    }

    public static void d(String string) {
        za.a(Text.literal((String)string));
    }

    public static void a(MutableText class_52502) {
        za.a(class_52502, true);
    }

    public static void a(String string, boolean bl) {
        za.a(Text.literal((String)string), bl);
    }

    public static void a(MutableText class_52502, boolean bl) {
        if (Objects.isNull(za.w.inGameHud)) {
            VengeanceClient.INSTANCE.getLogger().info(class_52502.getString());
            return;
        }
        MutableText class_52503 = bl ? za.a().copy().append((Text)class_52502) : class_52502;
        za.w.inGameHud.getChatHud().addMessage((Text)class_52503);
    }

    public static void e(String string) {
        if (za.w.player == null || za.w.world == null || Objects.isNull(za.w.inGameHud) || za.w.inGameHud.getChatHud() == null) {
            VengeanceClient.INSTANCE.getLogger().info("[Vengeance Client] " + string);
            return;
        }
        za.w.inGameHud.getChatHud().addMessage(Text.of((String)string));
    }

    public static MutableText a(String string, Style class_25832, Color color, Color color2) {
        MutableText class_52502 = Text.empty();
        for (int i = 0; i < string.length(); ++i) {
            float f = (float)i / (float)(string.length() - 1);
            Color color3 = com.vengeance.vengeanceclient.utils.w.zb.a(color, color2, f);
            class_52502.append((Text)Text.literal((String)String.valueOf(string.charAt(i))).setStyle(class_25832.withColor(TextColor.fromRgb((int)color3.getRGB()))));
        }
        return class_52502;
    }

    public static MutableText a() {
        return a.copy().append("[").append((Text)za.a("vengeance-client", Style.EMPTY, new Color(0, 191, 255), new Color(0, 255, 127))).append("]").append(" ");
    }

    private za() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final class za
    extends Enum<za> {
        public static final /* enum */ za a = new za(Color.GREEN);
        public static final /* enum */ za b = new za(Color.ORANGE);
        public static final /* enum */ za c = new za(Color.RED);
        private final int d;
        private final String e;
        private static final /* synthetic */ za[] f;

        public static za[] values() {
            return (za[])f.clone();
        }

        public static za valueOf(String string) {
            return Enum.valueOf(za.class, string);
        }

        private za(Color color) {
            this.d = color.getRGB();
            this.e = com.vengeance.vengeanceclient.utils.v.za.a(this.name());
        }

        public int a() {
            return this.d;
        }

        public String b() {
            return this.e;
        }

        private static /* synthetic */ za[] c() {
            return new za[]{a, b, c};
        }

        static {
            f = za.c();
        }
    }
}

