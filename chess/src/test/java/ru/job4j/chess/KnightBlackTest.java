package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KnightBlack;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KnightTest {
    @Test
    public void whenPositionIsD5() {
        ArrayList<Cell> possibleWays = new ArrayList<>();
        possibleWays.add(Cell.C3);
        possibleWays.add(Cell.E3);
        possibleWays.add(Cell.F4);
        possibleWays.add(Cell.F6);
        possibleWays.add(Cell.E7);
        possibleWays.add(Cell.C7);
        possibleWays.add(Cell.B6);
        possibleWays.add(Cell.B4);
        assertThat(new KnightBlack(Cell.D5).possibleWays(Cell.D5), is(possibleWays));
    }

    @Test
    public void whenSourceD5DestH7() {
        KnightBlack knight = new KnightBlack(Cell.D5);
        assertThat(knight.way(Cell.D5, Cell.H7), is(new Cell[] {Cell.D5}));
    }

    @Test
    public void whenSourceG8DestF6() {
        KnightBlack knight = new KnightBlack(Cell.G8);
        assertThat(knight.way(Cell.G8, Cell.F6), is(new Cell[] {Cell.F6}));
    }
}
