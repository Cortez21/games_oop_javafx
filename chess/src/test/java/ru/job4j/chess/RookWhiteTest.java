package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.white.RookWhite;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookWhiteTest {
    @Test
    public void whenSourceH8DestH5() {
        RookWhite rook = new RookWhite(Cell.H8);
        Cell[] steps = rook.way(Cell.H8, Cell.H5);
        assertThat(steps, is(new Cell[] {Cell.H7, Cell.H6, Cell.H5}));
    }

    @Test
    public void whenSourceA1DestD6() {
        RookWhite rook = new RookWhite(Cell.A1);
        Cell[] steps = rook.way(Cell.A1, Cell.D6);
        assertThat(steps, is(new Cell[] {Cell.A1}));
    }

    @Test
    public void whenCopyToC4() {
        RookWhite rook = new RookWhite(Cell.H5);
        RookWhite rookNew = new RookWhite(Cell.C4);
        assertThat(rook.copy(Cell.C4).position(), is(rookNew.position()));
    }
}

