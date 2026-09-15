/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.StringUtils
 *  org.lwjgl.glfw.GLFW
 */
package com.vengeance.vengeanceclient.utils.r;

import com.vengeance.vengeanceclient.utils.zb;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.glfw.GLFW;

public final class za
implements zb {
    public static String a(int n) {
        int n2;
        if (n <= -100) {
            n2 = -100 - n;
            if (n2 >= 0 && n2 <= 7) {
                n = n2;
            }
        } else if (n < -1 && (n2 = -(n + 1)) >= 0 && n2 <= 7) {
            n = n2;
        }
        return switch (n) {
            case 0 -> "LMB";
            case 1 -> "RMB";
            case 2 -> "MMB";
            case 3 -> "Mouse 4";
            case 4 -> "Mouse 5";
            case 5 -> "Mouse 6";
            case 6 -> "Mouse 7";
            case 7 -> "Mouse 8";
            case -1 -> "Unknown";
            case 256 -> "Esc";
            case 96 -> "Grave Accent";
            case 161 -> "World 1";
            case 162 -> "World 2";
            case 283 -> "Print Screen";
            case 284 -> "Pause";
            case 260 -> "Insert";
            case 261 -> "Delete";
            case 268 -> "Home";
            case 266 -> "Page Up";
            case 267 -> "Page Down";
            case 269 -> "End";
            case 258 -> "Tab";
            case 341 -> "Left Control";
            case 345 -> "Right Control";
            case 342 -> "Left Alt";
            case 346 -> "Right Alt";
            case 340 -> "Left Shift";
            case 344 -> "Right Shift";
            case 265 -> "Arrow Up";
            case 264 -> "Arrow Down";
            case 263 -> "Arrow Left";
            case 262 -> "Arrow Right";
            case 39 -> "Apostrophe";
            case 259 -> "Backspace";
            case 280 -> "Caps Lock";
            case 348 -> "Menu";
            case 343 -> "Left Super";
            case 347 -> "Right Super";
            case 257 -> "Enter";
            case 335 -> "Numpad Enter";
            case 282 -> "Num Lock";
            case 32 -> "Space";
            case 290 -> "F1";
            case 291 -> "F2";
            case 292 -> "F3";
            case 293 -> "F4";
            case 294 -> "F5";
            case 295 -> "F6";
            case 296 -> "F7";
            case 297 -> "F8";
            case 298 -> "F9";
            case 299 -> "F10";
            case 300 -> "F11";
            case 301 -> "F12";
            case 302 -> "F13";
            case 303 -> "F14";
            case 304 -> "F15";
            case 305 -> "F16";
            case 306 -> "F17";
            case 307 -> "F18";
            case 308 -> "F19";
            case 309 -> "F20";
            case 310 -> "F21";
            case 311 -> "F22";
            case 312 -> "F23";
            case 313 -> "F24";
            case 314 -> "F25";
            case 281 -> "Scroll Lock";
            case 91 -> "Left Bracket";
            case 93 -> "Right Bracket";
            case 59 -> "Semicolon";
            case 61 -> "Equals";
            case 92 -> "Backslash";
            case 44 -> "Comma";
            default -> {
                String var1_2 = GLFW.glfwGetKeyName((int)n, (int)0);
                if (var1_2 == null) {
                    yield "None";
                }
                yield StringUtils.capitalize((String)var1_2);
            }
        };
    }

    public static boolean b(int n) {
        try {
            int n2;
            if (n >= 0 && n <= 8) {
                return GLFW.glfwGetMouseButton((long)w.getWindow().getHandle(), (int)n) == 1;
            }
            if (n <= -100) {
                int n3 = -100 - n;
                if (n3 >= 0 && n3 <= 8) {
                    return GLFW.glfwGetMouseButton((long)w.getWindow().getHandle(), (int)n3) == 1;
                }
            } else if (n < 0 && (n2 = -(n + 1)) >= 0 && n2 <= 8) {
                return GLFW.glfwGetMouseButton((long)w.getWindow().getHandle(), (int)n2) == 1;
            }
            return GLFW.glfwGetKey((long)w.getWindow().getHandle(), (int)n) == 1;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private za() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

