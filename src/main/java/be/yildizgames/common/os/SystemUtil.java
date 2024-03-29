/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.os;

/**
 * This class expose functions specific for operating systems.
 *
 * @author Grégory Van den Borre
 */
public class SystemUtil {

    /**
     * Private constructor to prevent instantiation.
     */
    private SystemUtil() {
        super();
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean isArm64() {
        var arch = System.getProperty("os.arch");
        return is64bit(arch) && isArm(arch);
    }

    public static boolean isArm32() {
        var arch = System.getProperty("os.arch");
        return !is64bit(arch) && isArm(arch);
    }

    private static boolean isArm(String arch) {
        return arch.startsWith("arm") || arch.startsWith("aarch64");
    }

    private static boolean is64bit(String arch) {
        return arch.contains("64") || arch.startsWith("armv8");
    }

    public static boolean isAmd64() {
        return "amd64".equals(System.getProperty("os.arch"));
    }
}
