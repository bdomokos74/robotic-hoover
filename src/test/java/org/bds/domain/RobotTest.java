package org.bds.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bdomokos on 05/05/16.
 */
public class RobotTest {
    Input in;
    int origX = 3;
    int origY = 4;

    @Before
    public void setUp() throws Exception {
        in = new Input();
        in.setCoords(new int[]{origX, origY});
    }

    @Test
    public void testExecuteInvalid() throws Exception {
        Robot r = new Robot(in, (x, y)-> false);
        r.execute(Command.of('N'));
        assertEquals(origX, r.getX());
        assertEquals(origY, r.getY());

        r.execute(Command.of('E'));
        assertEquals(origX, r.getX());
        assertEquals(origY, r.getY());

        r.execute(Command.of('S'));
        assertEquals(origX, r.getX());
        assertEquals(origY, r.getY());

        r.execute(Command.of('W'));
        assertEquals(origX, r.getX());
        assertEquals(origY, r.getY());
    }

    @Test
    public void testExecuteN() throws Exception {
        Robot r = new Robot(in, (x, y)-> true);
        r.execute(Command.of('N'));
        assertEquals(origX, r.getX());
        assertEquals(origY+1, r.getY());
    }

    @Test
    public void testExecuteE() throws Exception {
        Robot r = new Robot(in, (x, y)-> true);
        r.execute(Command.of('E'));
        assertEquals(origX+1, r.getX());
        assertEquals(origY, r.getY());
    }

    @Test
    public void testExecuteS() throws Exception {
        Robot r = new Robot(in, (x, y)-> true);
        r.execute(Command.of('S'));
        assertEquals(origX, r.getX());
        assertEquals(origY-1, r.getY());
    }

    @Test
    public void testExecuteW() throws Exception {
        Robot r = new Robot(in, (x, y)-> true);
        r.execute(Command.of('W'));
        assertEquals(origX-1, r.getX());
        assertEquals(origY, r.getY());
    }
}