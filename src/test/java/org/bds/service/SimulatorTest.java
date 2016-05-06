package org.bds.service;

import org.bds.domain.Input;
import org.bds.domain.Output;
import org.bds.exception.BadRequestException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bdomokos on 06/05/16.
 */
public class SimulatorTest {

    @Test
    public void testSimulate_original() throws Exception {
        Input input = new Input();
        input.setRoomSize(new int[]{5, 5});
        input.setCoords(new int[]{1, 2});
        input.setPatches(new int[][]{{1, 0}, {2, 2}, {2, 3}});
        input.setInstructions("NNESEESWNWW");
        Output out = Simulator.simulate(input);
        assertArrayEquals(new int[]{1, 3}, out.getCoords());
        assertEquals(1, out.getPatches());
    }

    @Test
    public void testSimulate_1() throws Exception {
        Input input = new Input();
        input.setRoomSize(new int[]{5, 5});
        input.setCoords(new int[]{1, 2});
        input.setPatches(new int[][]{{1, 0}, {2, 2}, {2, 3}});
        input.setInstructions("NESWSSW");
        Output out = Simulator.simulate(input);
        assertArrayEquals(new int[]{0, 0}, out.getCoords());
        assertEquals(3, out.getPatches());
    }
    @Test
    public void testSimulate_2() throws Exception {
        Input input = new Input();
        input.setRoomSize(new int[]{5, 5});
        input.setCoords(new int[]{1, 2});
        input.setPatches(new int[][]{{1, 0}, {2, 2}, {2, 3}});
        input.setInstructions("NESWSSWWWWWWWWW");
        Output out = Simulator.simulate(input);
        assertArrayEquals(new int[]{0, 0}, out.getCoords());
        assertEquals(3, out.getPatches());
    }

    @Test
    public void testSimulate_3() throws Exception {
        Input input = new Input();
        input.setRoomSize(new int[]{1, 1});
        input.setCoords(new int[]{0, 0});
        input.setPatches(new int[][]{{0, 0}});
        input.setInstructions("NESWSSWWWWWWWWW");
        Output out = Simulator.simulate(input);
        assertArrayEquals(new int[]{0, 0}, out.getCoords());
        assertEquals(1, out.getPatches());
    }

    @Test
    public void testSimulate_4() throws Exception {
        Input input = new Input();
        input.setRoomSize(new int[]{2, 2});
        input.setCoords(new int[]{0, 0});
        input.setPatches(new int[][]{{0, 0}});
        input.setInstructions("NNNNNEEEE");
        Output out = Simulator.simulate(input);
        assertArrayEquals(new int[]{1, 1}, out.getCoords());
        assertEquals(1, out.getPatches());
    }

    @Test(expected = BadRequestException.class)
    public void testSimulate_5() throws Exception {
        Input input = new Input();
        input.setRoomSize(new int[]{2, 2});
        input.setCoords(new int[]{0, 2});
        input.setPatches(new int[][]{{0, 0}});
        input.setInstructions("NNNNNEEEE");
        Output out = Simulator.simulate(input);
    }
}