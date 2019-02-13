package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.white.KnightWhite;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KnightWhiteTest {
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
        assertThat(new KnightWhite(Cell.D5).possibleWays(Cell.D5), is(possibleWays));
    }

    @Test
    public void whenSourceD5DestH7() {
        boolean isException = false;
        try {
            new KnightWhite(Cell.D5).way(Cell.D5, Cell.H7);
        } catch (ImpossibleMoveException e) {
            isException = true;
        }
        assertThat(isException, is(true));
    }

    @Test
    public void whenSourceG8DestF6() throws ImpossibleMoveException {
        KnightWhite knight = new KnightWhite(Cell.G8);
        assertThat(knight.way(Cell.G8, Cell.F6), is(new Cell[] {Cell.F6}));
    }
}
