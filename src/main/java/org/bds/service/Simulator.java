package org.bds.service;

import org.bds.domain.*;
import org.bds.exception.BadRequestException;

/**
 * Created by bdomokos on 05/05/16.
 */
public class Simulator {
    public static Output simulate(Input input) {
        RoomImpl room = null;
        Robot robot = null;
        try {
            room = new RoomImpl(input);
            robot = new Robot(input, room);
            robot.init();
        } catch (RuntimeException ex) {
            throw new BadRequestException("invalid parameters");
        }
        for (char cmd : input.getInstructions().toCharArray()) {
            robot.execute(Command.of(cmd));
        }
        return room.getResult();
    }
}
