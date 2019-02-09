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
    public void whenSourceF2DestF3() {
        assertThat(new PawnWhite(Cell.F2).way(Cell.F2, Cell.F3), is(new Cell[] {Cell.F3}));
    }

    @Test
    public void whenSourceB2DestB6() {
        assertThat(new PawnWhite(Cell.B2).way(Cell.B2, Cell.B6), is(new Cell[] {Cell.B2}));
    }

}