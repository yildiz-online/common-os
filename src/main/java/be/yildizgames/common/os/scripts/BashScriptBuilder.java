/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
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

class BashScriptBuilder extends BaseScriptBuilder {

    protected BashScriptBuilder() {
        super("\n", ".sh");
    }

    @Override
    public ScriptBuilder goToDirectory(String name) {
        return this.addCommand("cd " + name);
    }

    @Override
    public ScriptBuilder renameInCurrentDir(String oldName, String newName) {
        return this.addCommand("mv " + oldName + " " + newName);
    }

    @Override
    public ScriptBuilder renameInParentDir(String oldName, String newName) {
        return this.renameInCurrentDir("../" + oldName, newName);
    }

    @Override
    public ScriptBuilder deleteInCurrentDir(String name) {
        return this.addCommand("rm " + name);
    }

    @Override
    public ScriptBuilder deleteInParentDir(String name) {
        return this.deleteInCurrentDir("../" + name);
    }

    @Override
    public ScriptBuilder start(String name) {
        return this.addCommand("run " + name + ".sh");
    }

    @Override
    public ScriptBuilder startBin(String name) {
        return this.addCommand("run " + name);
    }

    @Override
    public ScriptBuilder exit() {
        return this.addCommand("exit 0");
    }
}
