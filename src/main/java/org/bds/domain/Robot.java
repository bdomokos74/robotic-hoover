package org.bds.domain;

/**
 * Created by bdomokos on 05/05/16.
 */
public class Robot {
    private Room room;
    private int x;
    private int y;

    public Robot(Input in, Room room) {
        this.x = in.getCoords()[0];
        this.y = in.getCoords()[1];
        this.room = room;
    }

    public void init() {
        if (!room.stepTo(x, y)) {
            throw new IllegalArgumentException("Invalid configuraiton");
        }
    }
    public void execute(Command cmd) {
        if (room.stepTo(x + cmd.getDx(), y + cmd.getDy())) {
            x = x + cmd.getDx();
            y = y + cmd.getDy();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
