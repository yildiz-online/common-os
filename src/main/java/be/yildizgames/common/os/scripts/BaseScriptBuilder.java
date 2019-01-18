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
package be.yildizgames.common.os.scripts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

abstract class BaseScriptBuilder implements ScriptBuilder {

    private static final String QUOTE = "\"";

    private final String eol;

    private final List<String> commands = new ArrayList<>();

    private final String extension;

    protected BaseScriptBuilder(String eol, String extension) {
        this.eol = eol;
        this.extension = extension;
    }

    protected static String quoted(String s) {
        return QUOTE + s + QUOTE;
    }

    protected final ScriptBuilder addCommand(String command) {
        this.commands.add(command + this.eol);
        return this;
    }

    @Override
    public final void generateFile(String file) throws IOException {
        String content = this.generate();
        File f = new File(file + this.extension);
        if(f.exists() && !f.delete()) {

        }
        Files.write(Paths.get(f.toURI()), content.getBytes(), StandardOpenOption.CREATE);
    }

    public final String generate() {
        StringBuilder sb = new StringBuilder();
        for(String s : commands) {
            sb.append(s);
        }
        return sb.toString();
    }
}
