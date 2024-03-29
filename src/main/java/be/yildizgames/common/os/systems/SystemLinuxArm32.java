/*
 * MIT License
 *
 * Copyright (c) 2021 Grégory Van den Borre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package be.yildizgames.common.os.systems;

import be.yildizgames.common.os.OperatingSystem;
import be.yildizgames.common.os.SystemUtil;

/**
 * @author Grégory Van den Borre
 */
public class SystemLinuxArm32 implements OperatingSystem {

    private final boolean current;

    public SystemLinuxArm32() {
        super();
        this.current = SystemUtil.isLinux() && SystemUtil.isArm32();
    }

    @Override
    public final String getExtension() {
        return ".so";
    }

    @Override
    public final String getName() {
        return "linuxarm32";
    }

    @Override
    public final boolean isCurrent() {
        return this.current;
    }

    @Override
    public final int hashCode() {
        return getName().hashCode() + getExtension().hashCode();
    }

    @Override
    public final boolean equals(Object o) {
        return o instanceof SystemLinuxArm32;
    }

    @Override
    public final String toString() {
        return this.getName();
    }
}
