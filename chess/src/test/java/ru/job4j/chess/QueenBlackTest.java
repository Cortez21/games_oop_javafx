package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.QueenBlack;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlackTest {
    @Test
    public void whenSourceIsD5() {
        ArrayList<Cell> list = new ArrayList<>();
        list.add(Cell.E6);
        list.add(Cell.F7);
        list.add(Cell.G8);
        list.add(Cell.C6);
        list.add(Cell.B7);
        list.add(Cell.A8);
        list.add(Cell.C4);
        list.add(Cell.B3);
        list.add(Cell.A2);
        list.add(Cell.E4);
        list.add(Cell.F3);
        list.add(Cell.G2);
        list.add(Cell.H1);
        list.add(Cell.D4);
        list.add(Cell.D3);
        list.add(Cell.D2);
        list.add(Cell.D1);
        list.add(Cell.E5);
        list.add(Cell.F5);
        list.add(Cell.G5);
        list.add(Cell.H5);
        list.add(Cell.D6);
        list.add(Cell.D7);
        list.add(Cell.D8);
        list.add(Cell.C5);
        list.add(Cell.B5);
        list.add(Cell.A5);
        assertThat(new QueenBlack(Cell.D5).possibleWays(Cell.D5), is(list));
    }

    @Test
    public void whenSourceA8DestA3() {
        assertThat(new QueenBlack(Cell.A8).way(Cell.A8, Cell.A3), is(new Cell[] {Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3}));
    }

    @Test
    public void whenSourceA8DestE2() {
        assertThat(new QueenBlack(Cell.A8).way(Cell.A8, Cell.E2), is(new Cell[] {Cell.A8}));
    }
}
