package ru.job4j.chess;


import org.junit.Test;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.white.PawnWhite;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhiteTest {
    @Test
    public void whenSourceF2DestF3() throws ImpossibleMoveException {
        assertThat(new PawnWhite(Cell.F2).way(Cell.F2, Cell.F3), is(new Cell[] {Cell.F3}));
    }

    @Test
    public void whenSourceB7DestB2() {
        boolean isException = false;
        try {
            new PawnWhite(Cell.B7).way(Cell.B7, Cell.B2);
        } catch (ImpossibleMoveException e) {
            isException = true;
        }
        assertThat(isException, is(true));
    }

}