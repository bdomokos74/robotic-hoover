package org.bds.domain;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Created by bdomokos on 05/05/16.
 */
public class Input {
    private int[] roomSize;
    private int[] coords;
    private int [][] patches;
    private String instructions;

    public Input() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("roomSize=").append( Arrays.toString(roomSize))
                .append(", coords=").append(Arrays.toString(coords))
                .append(", patches=").append("[");

        String patchesStr = Arrays.asList(patches).stream()
                .map(Arrays::toString)
                .collect(joining(","));

        sb.append(patchesStr)
                .append("], instructions='")
                .append(instructions)
                .append('\'')
                .append("}\n");
        return sb.toString();
    }

    public int[] getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public int[][] getPatches() {
        return patches;
    }

    public void setPatches(int[][] patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}

