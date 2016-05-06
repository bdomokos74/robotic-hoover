package org.bds.domain;

/**
 * Created by bdomokos on 05/05/16.
 */
public enum Command {
    N(0, 1), E(1, 0), S(0, -1), W(-1, 0);
    private int dx;
    private int dy;
    Command(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Command of(char ch) {
        switch (ch) {
            case 'N': return N;
            case 'E': return E;
            case 'S': return S;
            case 'W': return W;
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
