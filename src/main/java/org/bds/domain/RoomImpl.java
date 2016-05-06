package org.bds.domain;

/**
 * Created by bdomokos on 05/05/16.
 */
public class RoomImpl implements Room {
    private Output out;
    private boolean[][] map;
    private int width;
    private int height;

    public RoomImpl(Input input) {
        this.out = new Output();
        width = input.getRoomSize()[0];
        height = input.getRoomSize()[1];
        map = new boolean[width][height];
        for (int[] pos : input.getPatches()) {
            map[pos[0]][pos[1]] = true;
        }
    }

    public boolean stepTo(int x, int y) {
        if(x<0||y<0||x>=width||y>=height) {
            return false;
        }
        if(map[x][y]) {
            map[x][y] = false;
            out.incPatches();
        }
        out.updateCoords(x,y);
        return true;
    }

    public Output getResult() {
        return out;
    }
}
