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

import be.yildizgames.common.os.systems.SystemLinux64;
import be.yildizgames.common.os.systems.SystemWin64;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Grégory Van den Borre
 */
public class OperatingSystemsTest {

    @Nested
    public class GetCurrent {

        @Test
        public void happyFlow() {
            if(OperatingSystems.LINUX64.getSystem().isCurrent()) {
                assertEquals(OperatingSystems.LINUX64.getSystem(), OperatingSystems.getCurrent());
            } else if (OperatingSystems.WIN64.getSystem().isCurrent()) {
                assertEquals(OperatingSystems.WIN64.getSystem(), OperatingSystems.getCurrent());
            } else {
                throw new IllegalArgumentException("No linux or windows system.");
            }
        }
    }

    @Nested
    public class GetAll {

        @Test
        public void happyFlow() {
            assertEquals(3, OperatingSystems.getAll().length);
            assertEquals(OperatingSystems.WIN64.getSystem(), OperatingSystems.getAll()[0]);
            assertEquals(OperatingSystems.LINUX64.getSystem(), OperatingSystems.getAll()[1]);
            assertEquals(OperatingSystems.LINUXARM64.getSystem(), OperatingSystems.getAll()[2]);
        }
    }

    @Nested
    public class Win64 {

        @Test
        public void happyFlow() {
            assertEquals(new SystemWin64(), OperatingSystems.WIN64.getSystem());
        }

    }

    @Nested
    public class Linux64 {

        @Test
        public void happyFlow() {
            assertEquals(new SystemLinux64(), OperatingSystems.LINUX64.getSystem());
        }

    }
}
