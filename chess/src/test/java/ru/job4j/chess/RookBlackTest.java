package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.RookBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookBlackTest {
    @Test
    public void whenSource1And1Dest1And5() throws ImpossibleMoveException {
        RookBlack rook = new RookBlack(Cell.H8);
        Cell[] steps = rook.way(Cell.H8, Cell.H5);
        assertThat(steps, is(new Cell[] {Cell.H7, Cell.H6, Cell.H5}));
    }

    @Test
    public void whenSourceG6DestF3() {
        boolean isException = false;
        try {
            new RookBlack(Cell.G6).way(Cell.G6, Cell.F3);
        } catch (ImpossibleMoveException e) {
            isException = true;
        }
        assertThat(isException, is(true));
    }
}
