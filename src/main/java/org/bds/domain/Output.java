package org.bds.domain;

import java.util.Arrays;

/**
 * Created by bdomokos on 05/05/16.
 */
public class Output {
    private int[] coords;
    private int patches;

    public Output(int[] coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public Output() {
        coords = new int[2];
        patches = 0;
    }
    public void incPatches() {
        patches++;
    }
    public void updateCoords(int x, int y) {
        coords[0] = x;
        coords[1] = y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("coords=")
                .append(Arrays.toString(coords))
                .append(", patches=")
                .append(patches)
                .append("}\n");
        return sb.toString();
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }
}
