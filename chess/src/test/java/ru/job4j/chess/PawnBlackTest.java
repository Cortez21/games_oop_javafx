package ru.job4j.chess;


import org.junit.Test;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.PawnBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PawnTest {
    @Test
    public void whenSourceH7DestH6() {
        assertThat(new PawnBlack(Cell.H7).way(Cell.H7, Cell.H6), is(new Cell[] {Cell.H6}));
    }

    @Test
    public void whenSourceB7DestB2() {
        assertThat(new PawnBlack(Cell.B7).way(Cell.B7, Cell.B2), is(new Cell[] {Cell.B7}));
    }

}
