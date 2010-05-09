package org.netbeans.modules.diff.builtin.visualizer;

import org.netbeans.api.diff.Difference;

import java.io.IOException;
import java.io.Reader;

public class TextDiffInfo {
    private String name1;
    private String name2;


    private Reader r1;
    private Reader r2;
    private Difference[] diffs;

    public TextDiffInfo(String name1, String name2, Reader r1, Reader r2, Difference[] diffs) {
        this.name1 = name1;
        this.name2 = name2;
        this.r1 = r1;
        this.r2 = r2;
        this.diffs = diffs;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public Reader createFirstReader() {
        return r1;
    }

    public Reader createSecondReader() {
        return r2;
    }

    public Difference[] getDifferences() {
        return diffs;
    }

    /**
     * @param numContextLine
     *      Number of context lines to generate around the diff.
     */
    public String toUnifiedDiffText(int numContextLine) throws IOException {
        return new UnifiedDiff(this, numContextLine).computeDiff();
    }

    public String toUnifiedDiffText() throws IOException {
        return toUnifiedDiffText(3);
    }
}
