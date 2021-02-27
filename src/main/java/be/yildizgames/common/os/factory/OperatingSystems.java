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

package be.yildizgames.common.os.factory;

import be.yildizgames.common.os.OperatingSystem;
import be.yildizgames.common.os.systems.SystemLinux64;
import be.yildizgames.common.os.systems.SystemLinuxArm64;
import be.yildizgames.common.os.systems.SystemWin64;

import java.util.Arrays;

/**
 * Possible different system with different files.
 *
 * @author Grégory Van den Borre
 */
public enum OperatingSystems {

    /**
     * Windows 64 bits.
     */
    WIN64(new SystemWin64()),

    /**
     * Linux 64 bits.
     */
    LINUX64(new SystemLinux64()),

    LINUXARM64(new SystemLinuxArm64());

    /**
     * Associated system.
     */
    private final OperatingSystem system;


    OperatingSystems(final OperatingSystem system) {
        this.system = system;
    }

    public OperatingSystem getSystem() {
        return this.system;
    }

    public static OperatingSystem getCurrent() {
        return Arrays
                .stream(OperatingSystems.values())
                .map(OperatingSystems::getSystem)
                .filter(OperatingSystem::isCurrent)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static OperatingSystem[] getAll() {
        return Arrays
                .stream(OperatingSystems.values())
                .map(OperatingSystems::getSystem)
                .toArray(OperatingSystem[]::new);
    }

}
