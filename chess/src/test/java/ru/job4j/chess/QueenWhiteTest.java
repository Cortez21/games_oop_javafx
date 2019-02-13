package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.white.QueenWhite;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class QueenWhiteTest {

    @Test
    public void whenSourceA8DestA3() throws ImpossibleMoveException {
        assertThat(new QueenWhite(Cell.A8).way(Cell.A8, Cell.A3), is(new Cell[] {Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3}));
    }

    @Test
    public void whenSourceA8DestE2() {
        boolean isException = false;
        try {
            new QueenWhite(Cell.A8).way(Cell.A8, Cell.E2);
        } catch (ImpossibleMoveException e) {
            isException = true;
        }
        assertThat(isException, is(true));
    }
}
